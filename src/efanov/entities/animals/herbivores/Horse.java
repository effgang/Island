package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public class Horse extends Herbivore {


    public Horse(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Horse() {
    }

    @Override
    public Animal reproduce() {
        return new Horse();
    }
}
