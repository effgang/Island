package efanov.entities.animals.predators;

import efanov.entities.animals.Animal;

public abstract class Predator extends Animal {

    public Predator(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }
}
