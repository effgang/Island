package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public class Rabbit extends Herbivore {

    public Rabbit(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Rabbit() {
    }

    @Override
    public Animal reproduce() {
        return new Rabbit();
    }
}
