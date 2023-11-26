package efanov.entities.animals.predators;

import efanov.entities.animals.Animal;

public class Bear extends Predator {

    public Bear(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);

    }

    public Bear() {
    }

    @Override
    public Animal reproduce() {
        return new Bear();
    }
}
