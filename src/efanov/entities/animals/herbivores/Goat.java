package efanov.entities.animals.herbivores;

public class Goat extends Herbivore {

    public Goat(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Goat reproduce() {
        return new Goat(getEmoji(), getWeight(), getMaxCountOnLocation(), speed, saturation);
    }
}
