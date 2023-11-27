package efanov.entities.animals.herbivores;

public class Deer extends Herbivore {

    public Deer(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Deer reproduce() {
        return (Deer) super.reproduce();
    }
}
