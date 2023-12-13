package efanov.entities.animals.predators;

public class Fox extends Predator {

    public Fox(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Fox reproduce() {
        return new Fox(getEmoji(), getWeight(), getMaxCountOnLocation(), speed, saturation);
    }
}
