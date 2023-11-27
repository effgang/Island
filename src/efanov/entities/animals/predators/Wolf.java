package efanov.entities.animals.predators;

public class Wolf extends Predator {

    public Wolf(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Wolf reproduce() {
        return (Wolf) super.reproduce();
    }
}
