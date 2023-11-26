package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public class Mouse extends Herbivore {

    public Mouse(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public Mouse() {
    }

    @Override
    public Animal reproduce() {
        return new Mouse();
    }
}
