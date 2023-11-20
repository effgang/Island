package efanov.entities.animals;

import efanov.entities.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal extends Entity {
    private int speed;
    private double saturation;

    public Animal(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation);
        this.speed = speed;
        this.saturation = saturation;
    }
}
