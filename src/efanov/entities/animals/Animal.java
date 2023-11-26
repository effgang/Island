package efanov.entities.animals;

import efanov.entities.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal extends Entity {
    private static final int BOUND = 100;
    private String emoji;
    private double weight;
    private int maxCountOnLocation;
    private int speed;
    private double saturation;
    private double health;

    public Animal(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        this.emoji = emoji;
        this.weight = weight;
        this.maxCountOnLocation = maxCountOnLocation;
        this.speed = speed;
        this.saturation = saturation;
        this.health = saturation;
    }


    public abstract Animal reproduce();

    public void eat(Entity food) {
        if (food.getWeight() >= this.getSaturation()) {
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

    @Override
    public String getEmoji() {
        return emoji;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getMaxCountOnLocation() {
        return maxCountOnLocation;
    }

}
