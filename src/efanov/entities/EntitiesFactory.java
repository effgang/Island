package efanov.entities;

import efanov.entities.animals.Animal;
import efanov.entities.animals.herbivores.*;
import efanov.entities.animals.predators.*;
import efanov.entities.plants.Herb;
import efanov.properties.processing.Processor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EntitiesFactory {
    Processor processor = new Processor();

    public Entity createEntity(EntityType entityType) {
        return switch (entityType) {
            case WOLF -> getAnimal(entityType, Wolf.class);
            case BEAR -> getAnimal(entityType, Bear.class);
            case BOA -> getAnimal(entityType, Boa.class);
            case FOX -> getAnimal(entityType, Fox.class);
            case EAGLE -> getAnimal(entityType, Eagle.class);
            case HORSE -> getAnimal(entityType, Horse.class);
            case GOAT -> getAnimal(entityType, Goat.class);
            case SHEEP -> getAnimal(entityType, Sheep.class);
            case MOUSE -> getAnimal(entityType, Mouse.class);
            case RABBIT -> getAnimal(entityType, Rabbit.class);
            case DEER -> getAnimal(entityType, Deer.class);
            case WILDBOAR -> getAnimal(entityType, WildBoar.class);
            case DUCK -> getAnimal(entityType, Duck.class);
            case BUFFALO -> getAnimal(entityType, Buffalo.class);
            case CATERPILLAR -> getAnimal(entityType, Caterpillar.class);
            case PLANT -> new Herb(processor.getEmojiFromFile(entityType.name()),
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
