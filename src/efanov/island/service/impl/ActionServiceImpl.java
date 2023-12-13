package efanov.island.service.impl;

import efanov.entities.animals.Animal;
import efanov.entities.animals.Direction;
import efanov.entities.animals.EatingMap;
import efanov.island.IslandMap;
import efanov.island.Location;
import efanov.island.service.ActionService;
import efanov.simulation.SimulationSettings;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public class ActionServiceImpl implements ActionService {
    private final StepServiceImpl stepService;
    private final EatingMap eatingMap;
    private final SimulationSettings settings;

    public ActionServiceImpl(StepServiceImpl stepService, EatingMap eatingMap, SimulationSettings settings) {
        this.stepService = stepService;
        this.eatingMap = eatingMap;
        this.settings = settings;

    }

    @Override
    public void doMove(Animal animal, Location location, IslandMap map) {
        var stepsCount = ThreadLocalRandom.current().nextInt(animal.getSpeed() + 1);
        while (stepsCount > 0) {
            Direction direction = animal.chooseDirection();
            switch (direction) {
                case UP -> location = stepService.stepUp(animal, location, map);
                case DOWN -> location = stepService.stepDown(animal, location, map);
                case LEFT -> location = stepService.stepLeft(animal, location, map);
                case RIGHT -> location = stepService.stepRight(animal, location, map);
            }
            stepsCount--;
        }
    }

    @Override
    public void doEat(Animal animal, Location location) {
        var entities = location.getEntities()
                .stream()
                .map(e -> e.getClass().getSimpleName())
                .toList();
        var eatingProbability = eatingMap.getEatingProbability();

        Map<String, Integer> personalProbability = eatingProbability.get(animal.getClass().getSimpleName());

        var sumOfProbability = personalProbability.entrySet()
                .stream()
                .filter(animalProbability -> animalProbability.getValue() > 0)
                .filter(animalProbability -> entities.contains(animalProbability.getKey()))
                .mapToInt(Map.Entry::getValue)
                .sum();
        if (sumOfProbability == 0) {
            doSleep(animal);
            return;
        }

        var filteredPersonalProbability = personalProbability.entrySet()
                .stream()
                .filter(animalProbability -> animalProbability.getValue() > 0).map(Map.Entry::getKey)
                .sorted(Comparator.comparing(Function.identity()))
                .toList();

        var temp = ThreadLocalRandom.current().nextInt(1, sumOfProbability);

        for (String name : filteredPersonalProbability) {
            if (entities.contains(name)) {
                temp -= personalProbability.get(name);
                if (temp <= 0) {
                    var food = location.getEntities().stream()
                            .filter(e -> e.getClass().getSimpleName().equals(name)).findAny();
                    animal.eat(food.get());
                    location.removeEntity(food.get());

                }
            }
        }
    }

    @Override
    public void doReproduce(Animal animal, Location location) {
        var getAnimalCountOnCage = Optional.ofNullable(location.getEntitiesCountStatistic().get(animal.getClass().getSimpleName())).orElse(0);
        if (getAnimalCountOnCage >= animal.getMaxCountOnLocation()) {
            return;
        }
        if (checkReproducePartner(animal, location)) {
            location.addEntity(animal.reproduce());
        }
    }

    @Override
    public void doSleep(Animal animal) {
        increaseHealth(animal);
    }

    public void reduceHealth(Animal animal) {
        double healthScale = animal.getHealth() - ((animal.getSaturation() * settings.getReduceHealth()) / 100);
        animal.setHealth(healthScale);
    }

    private boolean checkReproducePartner(Animal animal, Location location) {
        var duplicate = location.getAnimals().stream()
                .map(el -> el.getClass().getSimpleName())
                .filter(el -> el.equals(animal.getClass().getSimpleName()))
                .count();
        return duplicate > 1;
    }

    private void increaseHealth(Animal animal) {
        double healthScale = animal.getHealth() + ((animal.getSaturation() * settings.getIncreaseHealth()) / 100);
        animal.setHealth(healthScale);
    }
}
