package efanov.entities.animals.herbivores;

public class Mouse extends Herbivore {

    public Mouse(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Mouse reproduce() {
        return new Mouse(getEmoji(), getWeight(), getMaxCountOnLocation(), speed, saturation);
    }
}
