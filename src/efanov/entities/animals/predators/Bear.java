package efanov.entities.animals.predators;

public class Bear extends Predator {

    public Bear(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Bear reproduce() {
        return new Bear(getEmoji(), getWeight(), getMaxCountOnLocation(), speed, saturation);
    }
}
