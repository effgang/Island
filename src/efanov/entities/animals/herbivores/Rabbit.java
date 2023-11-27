package efanov.entities.animals.herbivores;

public class Rabbit extends Herbivore {

    public Rabbit(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Rabbit reproduce() {
        return (Rabbit) super.reproduce();
    }
}
