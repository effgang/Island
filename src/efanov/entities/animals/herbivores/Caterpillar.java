package efanov.entities.animals.herbivores;

public class Caterpillar extends Herbivore {

    public Caterpillar(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
        this.health = maxCountOnLocation;
    }

    @Override
    public Caterpillar reproduce() {
        return new Caterpillar(getEmoji(), getWeight(), getMaxCountOnLocation(), speed, saturation);
    }
}
