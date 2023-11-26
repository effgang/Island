package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public class Caterpillar extends Herbivore {

    public Caterpillar(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Caterpillar() {
    }

    @Override
    public Animal reproduce() {
        return new Caterpillar();
    }
}
