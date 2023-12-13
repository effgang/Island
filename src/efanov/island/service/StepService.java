package efanov.island.service;

import efanov.entities.animals.Animal;
import efanov.island.IslandMap;
import efanov.island.Location;

public interface StepService {
    Location stepUp(Animal animal, Location location, IslandMap map);

    Location stepDown(Animal animal, Location location, IslandMap map);

    Location stepLeft(Animal animal, Location location, IslandMap map);

    Location stepRight(Animal animal, Location location, IslandMap map);
}
