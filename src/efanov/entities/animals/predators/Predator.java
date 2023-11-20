package efanov.entities.animals.predators;

import efanov.entities.animals.Animal;

public abstract class Predator extends Animal {

    public Predator(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }
}
