package efanov.entities.animals.herbivores;

import efanov.entities.Entity;
import efanov.entities.animals.Animal;

public abstract class Herbivore extends Animal {

    public Herbivore(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public void eat(Entity entity) {

    }
}
