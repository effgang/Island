package efanov.island;

import efanov.entities.EntitiesFactory;
import efanov.entities.Entity;
import efanov.entities.EntityType;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;
@Getter
@Setter
public class IslandMap {
    private final EntitiesFactory entitiesFactory;
    private final int x, y;
    private Location[][] locations;

    public IslandMap(int x, int y) {
        this.entitiesFactory = new EntitiesFactory();
        this.x = x;
        this.y = y;
        this.locations = new Location[x][y];
    }

    public void init() {
        for (int coordX = 0; coordX < x; coordX++) {
            for (int coordY = 0; coordY < y; coordY++) {
                locations[coordX][coordY] = new Location(coordX, coordY);
            }
        }
    }

    public void fillIsland(int maxCount) {
        for (int coordX = 0; coordX < x; coordX++) {
            for (int coordY = 0; coordY < y; coordY++) {
                for (int i = 0; i <= maxCount; i++) {
                    Entity entity = getRandom();
                    var entityAsString = entity.getClass().getSimpleName();
                    var entityCountOnLocation = locations[coordX][coordY].getEntitiesCountStatistic().getOrDefault(entityAsString, 0);
                    if (entityCountOnLocation > maxCount) {
                        continue;
                    }
                    locations[coordX][coordY].addEntity(entity);
                }
            }
        }
    }

    private Entity getRandom() {
        var entityTypes = EntityType.values();
        var entityType = entityTypes[ThreadLocalRandom.current().nextInt(entityTypes.length)];
        return entitiesFactory.createEntity(entityType);
    }
}
