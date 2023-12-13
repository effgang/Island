package efanov.entities.animals.herbivores;

public class WildBoar extends Herbivore {

    public WildBoar(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public WildBoar reproduce() {
        return new WildBoar(getEmoji(), getWeight(), getMaxCountOnLocation(), speed, saturation);
    }
}
