package efanov.island;

import efanov.constants.Constant;
import efanov.entities.EntitiesFactory;
import efanov.entities.Entity;
import efanov.entities.EntityType;
import efanov.simulation.SimulationSettings;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class IslandMap {
    private final EntitiesFactory entitiesFactory;
    private final SimulationSettings settings;
    private Location[][] locations;

    public IslandMap(SimulationSettings settings) {
        this.entitiesFactory = new EntitiesFactory();
        this.settings = settings;
    }

    public void init() {
        this.locations = new Location[settings.getHeight()][settings.getWidth()];
        for (int coordY = 0; coordY < settings.getHeight(); coordY++) {
            for (int coordX = 0; coordX < settings.getWidth(); coordX++) {
                locations[coordY][coordX] = new Location(coordY, coordX);
            }
        }
    }

    public void fillIsland(int maxCount) {
        for (int coordY = 0; coordY < settings.getHeight(); coordY++) {
            for (int coordX = 0; coordX < settings.getWidth(); coordX++) {
                for (int i = 0; i < maxCount; i++) {
                    while (true) {
                        Entity entity = getRandom();
                        var count = locations[coordY][coordX].getEntities().stream()
                                .filter(entityOnLocation -> entityOnLocation.equals(entity))
                                .count();
                        if (count < entity.getMaxCountOnLocation()) {
                            locations[coordY][coordX].addEntity(entity);
                            break;
                        }
                    }
                }
            }
        }
    }

    private Entity getRandom() {
        var entityTypes = EntityType.values();
        var entityType = entityTypes[ThreadLocalRandom.current().nextInt(entityTypes.length)];
        return entitiesFactory.createEntity(entityType);
    }

    public Runnable plantGrow() {
        return () -> {
            while (true) {
                var coordY = ThreadLocalRandom.current().nextInt(getHeight());
                var coordX = ThreadLocalRandom.current().nextInt(getWidth());
                var herb = entitiesFactory.createEntity(EntityType.PLANT);
                Location location = locations[coordY][coordX];
                if (location.getPlants().size() + Constant.PLANT_COUNT_TO_ADD >= herb.getMaxCountOnLocation()) {
                    continue;
                }
                for (int i = 0; i <= Constant.PLANT_COUNT_TO_ADD; i++) {
                    location.addEntity(herb);
                }
                break;
            }
        };
    }

    public int getHeight() {
        return settings.getHeight();
    }

    public int getWidth() {
        return settings.getWidth();
    }
}
