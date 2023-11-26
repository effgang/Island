package efanov.entities.animals.predators;

import efanov.entities.animals.Animal;

public class Fox extends Predator {

    public Fox(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Fox() {
    }

    @Override
    public Animal reproduce() {
        return new Fox();
    }
}
