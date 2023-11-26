package efanov.entities.animals.predators;

import efanov.entities.animals.Animal;

public class Wolf extends Predator {

    public Wolf(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Wolf() {
    }

    @Override
    public Animal reproduce() {
        return new Wolf();
    }
}
