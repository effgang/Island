package efanov.island;

import efanov.constants.Constant;
import efanov.entities.animals.Action;
import efanov.entities.animals.Animal;
import efanov.entities.animals.EatingMap;
import efanov.island.service.impl.ActionServiceImpl;
import efanov.island.service.impl.StepServiceImpl;
import efanov.simulation.SimulationSettings;
import efanov.simulation.SimulationStarter;
import efanov.statistic.Statistic;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class IslandController {
    private final IslandMap map;
    private final EatingMap eatingMap;
    private final SimulationSettings settings;
    private final ActionServiceImpl actionService;
    private final Statistic stat;

    public IslandController(IslandMap map, EatingMap eatingMap, SimulationSettings simulationSettings) {
        this.map = map;
        this.eatingMap = eatingMap;
        this.settings = simulationSettings;
        this.actionService = new ActionServiceImpl(new StepServiceImpl(), eatingMap, simulationSettings);
        this.stat = new Statistic(map);
    }

    public void doAction(Action action, Animal animal, Location location) {
        switch (action) {
            case MOVE -> actionService.doMove(animal, location, map);
            case EAT -> actionService.doEat(animal, location);
            case REPRODUCE -> actionService.doReproduce(animal, location);
            case SLEEP -> actionService.doSleep(animal);
        }
        actionService.reduceHealth(animal);
    }

    public void startLife() {
        for (int count = 1; count <= settings.getLifeCycleTact(); count++) {
            for (int y = 0; y < settings.getHeight(); y++) {
                for (int x = 0; x < settings.getWidth(); x++) {
                    Location location = map.getLocations()[y][x];
                    List<Animal> animals = new ArrayList<>(location.getAnimals());
                    for (Animal animal : animals) {
                        if (isDead(animal)) {
                            location.removeEntity(animal);
                            continue;
                        }
                        Action action = animal.chooseAction();
                        doAction(action, animal, location);
                    }
                }
            }
            System.out.println("***" + " Tact - " + count + "***");
            stat.printStatistic(stat.getAllEntitiesStatistic());
        }
        stopSimulation();
        System.out.println(Constant.END);
    }

    private void stopSimulation() {
        SimulationStarter.executorService.shutdown();
    }

    private boolean isDead(Animal animal) {
        return animal.getHealth() <= 0;
    }


}
