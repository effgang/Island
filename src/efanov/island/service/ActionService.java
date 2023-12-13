package efanov.island.service;

import efanov.entities.animals.Animal;
import efanov.island.IslandMap;
import efanov.island.Location;

public interface ActionService {
    void doMove(Animal animal, Location location, IslandMap map);

    void doEat(Animal animal, Location location);

    void doReproduce(Animal animal, Location location);

    void doSleep(Animal animal);

}
