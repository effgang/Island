package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public class Buffalo extends Herbivore {

    public Buffalo(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Buffalo() {
    }

    @Override
    public Animal reproduce() {
        return new Buffalo();
    }
}
