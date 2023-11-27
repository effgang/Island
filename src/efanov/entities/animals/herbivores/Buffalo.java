package efanov.entities.animals.herbivores;

public class Buffalo extends Herbivore {

    public Buffalo(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Buffalo reproduce() {
        return (Buffalo) super.reproduce();
    }
}
