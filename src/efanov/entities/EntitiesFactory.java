package efanov.entities;

import efanov.entities.animals.herbivores.*;
import efanov.entities.animals.predators.*;
import efanov.entities.plants.Plant;
import efanov.properties_processing.Processor;

public class EntitiesFactory {
    Processor processor = new Processor();
    public Entity createEntity(EntityType entityType) {
        return switch (entityType) {
            case WOLF -> new Wolf();
            case BEAR -> new Bear();
            case BOA -> new Boa();
            case FOX -> new Fox();
            case EAGLE -> new Eagle();
            case HORSE -> new Horse();
            case GOAT -> new Goat();
            case SHEEP -> new Sheep();
            case MOUSE -> new Mouse();
            case RABBIT -> new Rabbit();
            case DEER -> new Deer();
            case WILD_BOAR -> new WildBoar();
            case DUCK -> new Duck();
            case BUFFALO -> new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case PLANT -> new Plant(processor.getEmojiFromFile("plant"), processor.getWeightFromFile("plant"), processor.getMaxCountFromFile("plant") );
        };
    }
}
