package efanov.entities.animals;

import efanov.entities.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class Animal extends Entity {
    private static final int BOUND = 100;
    private int speed;
    private double saturation;
    private double health;

    public Animal(String emoji, Double weight, Integer maxCountOnLocation, Integer speed, Double saturation) {
        super(emoji, weight, maxCountOnLocation);
        this.speed = speed;
        this.saturation = saturation;
        this.health = saturation;
    }

    public Animal reproduce() {
        return new Animal(getEmoji(), getWeight(), getMaxCountOnLocation(), speed, saturation);
    }

    public void eat(Entity food) {
        if (food.getWeight() + this.getHealth() >= this.getSaturation()) {
            this.setHealth(this.getSaturation());
        } else {
            double saturationAfterEating = this.getHealth() + food.getWeight();
            this.setHealth(saturationAfterEating);
        }
    }

    public Direction chooseDirection() {
        return Direction.values()[ThreadLocalRandom.current().nextInt(Direction.values().length)];
    }

    public Action chooseAction() {
        var action = Action.values()[ThreadLocalRandom.current().nextInt(Action.values().length)];
        var isActiveAction = ThreadLocalRandom.current().nextInt(BOUND) < action.getActionChance();
        return isActiveAction ? action : Action.MOVE;
    }

}
