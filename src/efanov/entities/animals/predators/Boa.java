package efanov.entities.animals.predators;

import efanov.entities.animals.Animal;

public class Boa extends Predator {

    public Boa(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Boa() {
    }

    @Override
    public Animal reproduce() {
        return new Boa();
    }
}
