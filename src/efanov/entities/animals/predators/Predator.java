package efanov.entities.animals.predators;

import efanov.entities.Entity;
import efanov.entities.animals.Animal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Predator extends Animal {

    public Predator(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public void eat(Entity entity) {

    }
}
