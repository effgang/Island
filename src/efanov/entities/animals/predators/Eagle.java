package efanov.entities.animals.predators;

import efanov.entities.animals.Animal;

public class Eagle extends Predator {

    public Eagle(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Eagle() {
    }

    @Override
    public Animal reproduce() {
        return new Eagle();
    }
}
