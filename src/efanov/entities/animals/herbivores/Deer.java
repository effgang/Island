package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public class Deer extends Herbivore {

    public Deer(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Deer() {
    }

    @Override
    public Animal reproduce() {
        return new Deer();
    }
}
