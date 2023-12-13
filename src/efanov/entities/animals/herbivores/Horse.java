package efanov.entities.animals.herbivores;

public class Horse extends Herbivore {


    public Horse(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Horse reproduce() {
        return new Horse(getEmoji(), getWeight(), getMaxCountOnLocation(), speed, saturation);
    }
}
