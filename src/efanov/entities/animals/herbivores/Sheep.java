package efanov.entities.animals.herbivores;

public class Sheep extends Herbivore {

    public Sheep(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Sheep reproduce() {
        return new Sheep(getEmoji(), getWeight(), getMaxCountOnLocation(), speed, saturation);
    }
}
