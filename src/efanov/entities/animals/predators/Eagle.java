package efanov.entities.animals.predators;

public class Eagle extends Predator {

    public Eagle(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Eagle reproduce() {
        return (Eagle) super.reproduce();
    }
}
