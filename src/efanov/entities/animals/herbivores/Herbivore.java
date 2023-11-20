package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public abstract class Herbivore extends Animal {

    public Herbivore(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }
}
