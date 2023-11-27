package efanov.entities;

import efanov.entities.animals.Animal;
import efanov.entities.animals.herbivores.*;
import efanov.entities.animals.predators.*;
import efanov.entities.plants.Plant;
import efanov.properties.processing.Processor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EntitiesFactory {
    Processor processor = new Processor();

    public Entity createEntity(EntityType entityType) {
        return switch (entityType) {
            case WOLF -> (Wolf) getAnimal(entityType, Wolf.class);
            case BEAR -> (Bear) getAnimal(entityType,Bear.class);
            case BOA -> (Boa) getAnimal(entityType, Boa.class);
            case FOX -> (Fox) getAnimal(entityType, Fox.class);
            case EAGLE -> (Eagle) getAnimal(entityType, Eagle.class);
            case HORSE -> (Horse) getAnimal(entityType, Horse.class);
            case GOAT -> (Goat) getAnimal(entityType, Goat.class);
            case SHEEP -> (Sheep) getAnimal(entityType, Sheep.class);
            case MOUSE -> (Mouse) getAnimal(entityType, Mouse.class);
            case RABBIT -> (Rabbit) getAnimal(entityType, Rabbit.class);
            case DEER -> (Deer) getAnimal(entityType, Deer.class);
            case WILDBOAR -> (WildBoar) getAnimal(entityType, WildBoar.class);
            case DUCK -> (Duck) getAnimal(entityType, Duck.class);
            case BUFFALO -> (Buffalo) getAnimal(entityType, Buffalo.class);
            case CATERPILLAR -> (Caterpillar) getAnimal(entityType, Caterpillar.class);
            case PLANT -> new Plant(processor.getEmojiFromFile(entityType.name()),
                    processor.getWeightFromFile(entityType.name()),
                    processor.getMaxCountFromFile(entityType.name()));
        };
    }

    private Animal getAnimal(EntityType entityType, Class<? extends Animal> clazz) {
        Constructor<? extends Animal> constructor;
        try {

            constructor = clazz.getDeclaredConstructor(String.class, Double.class, Integer.class, Integer.class, Double.class);

            return constructor.newInstance(processor.getEmojiFromFile(entityType.name()),
                    processor.getWeightFromFile(entityType.name()),
                    processor.getMaxCountFromFile(entityType.name()),
                    processor.getSpeedFromFile(entityType.name()),
                    processor.getSaturationFromFile(entityType.name()));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
