package efanov.entities.animals.herbivores;

import efanov.entities.animals.Animal;

public class WildBoar extends Herbivore {

    public WildBoar(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    public WildBoar() {
    }

    @Override
    public Animal reproduce() {
        return new WildBoar();
    }
}
