package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public class Sheep extends Herbivore {

    public Sheep(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Sheep() {
    }

    @Override
    public Animal reproduce() {
        return new Sheep();
    }
}
