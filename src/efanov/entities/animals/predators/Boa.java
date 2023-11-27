package efanov.entities.animals.predators;

public class Boa extends Predator {

    public Boa(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public Boa reproduce() {
        return (Boa) super.reproduce();
    }
}
