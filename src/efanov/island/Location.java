package efanov.island;

import efanov.entities.Entity;
import efanov.entities.animals.Animal;
import efanov.entities.plants.Herb;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Location {
    private final int x;
    private final int y;
    private final List<Entity> entities;
    private final Map<String, Integer> entitiesCountStatistic;

    public Location(int y, int x) {
        this.x = x;
        this.y = y;
        this.entities = new ArrayList<>();
        this.entitiesCountStatistic = new HashMap<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
        addToStatistic(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
        removeFromStatistic(entity);
    }

    public List<Animal> getAnimals() {
        return entities.stream()
                .filter(e -> e instanceof Animal)
                .map(e -> (Animal) e)
                .toList();
    }

    public List<Herb> getPlants() {
        return entities.stream()
                .filter(e -> e instanceof Herb)
                .map(e -> (Herb) e)
                .toList();
    }

    private void addToStatistic(Entity entity) {
        var entityAsString = getSimpleName(entity);
        entitiesCountStatistic.merge(entityAsString, 1, (oldValue, newValue) -> oldValue + 1);
    }

    private void removeFromStatistic(Entity entity) {
        var entityAsString = getSimpleName(entity);
        entitiesCountStatistic.merge(entityAsString, 1, (oldValue, newValue) -> {
            int tempCount = oldValue - 1;
            if (tempCount <= 0) {
                return null;
            }
            return tempCount;
        });
    }

    private String getSimpleName(Entity entity) {
        return entity.getClass().getSimpleName();
    }
}
