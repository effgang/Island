package efanov.island.service.impl;

import efanov.entities.animals.Animal;
import efanov.island.IslandMap;
import efanov.island.Location;
import efanov.island.service.StepService;

import java.util.Optional;

public class StepServiceImpl implements StepService {
    public Location stepUp(Animal animal, Location location, IslandMap map) {
        int currentX = location.getX();
        int currentY = location.getY();
        if (currentY > 0) {
            Location newLocation = map.getLocations()[currentY - 1][currentX];
            if (cantStep(animal, newLocation)) {
                return location;
            }
            newLocation.addEntity(animal);
            location.removeEntity(animal);
            return newLocation;
        }
        return location;
    }

    public Location stepDown(Animal animal, Location location, IslandMap map) {
        int currentX = location.getX();
        int currentY = location.getY();
        if (currentY < map.getHeight() - 1) {
            Location newLocation = map.getLocations()[currentY + 1][currentX];
            if (cantStep(animal, newLocation)) {
                return location;
            }
            newLocation.addEntity(animal);
            location.removeEntity(animal);
            return newLocation;
        }
        return location;
    }

    public Location stepLeft(Animal animal, Location location, IslandMap map) {
        int currentX = location.getX();
        int currentY = location.getY();
        if (currentX > 0) {
            Location newLocation = map.getLocations()[currentY][currentX - 1];
            if (cantStep(animal, newLocation)) {
                return location;
            }
            newLocation.addEntity(animal);
            location.removeEntity(animal);
            return newLocation;
        }
        return location;
    }

    public Location stepRight(Animal animal, Location location, IslandMap map) {
        int currentX = location.getX();
        int currentY = location.getY();
        if (currentX < map.getWidth() - 1) {
            Location newLocation = map.getLocations()[currentY][currentX + 1];
            if (cantStep(animal, newLocation)) {
                return location;
            }
            newLocation.addEntity(animal);
            location.removeEntity(animal);
            return newLocation;
        }
        return location;
    }

    public boolean cantStep(Animal animal, Location newLocation) {
        var animalCount = Optional.ofNullable(newLocation.getEntitiesCountStatistic().get(animal.getClass().getSimpleName()))
                .orElse(0);
        return animalCount >= animal.getMaxCountOnLocation();
    }
}
