package efanov.entities.animals.herbivores;

public class Duck extends Herbivore {
    public Duck(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
        this.health = speed;
    }

    @Override
    public Duck reproduce() {
        return new Duck(getEmoji(), getWeight(), getMaxCountOnLocation(), speed, saturation);
    }
}
