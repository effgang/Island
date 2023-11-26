package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public class Goat extends Herbivore {

    public Goat(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Goat() {
    }

    @Override
    public Animal reproduce() {
        return new Goat();
    }
}
