package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public class Duck extends Herbivore {

    public Duck(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Duck() {
    }

    @Override
    public Animal reproduce() {
        return new Duck();
    }
}
