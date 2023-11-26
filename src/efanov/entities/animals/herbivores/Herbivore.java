package efanov.entities.animals.herbivores;

import efanov.entities.Entity;
import efanov.entities.animals.Animal;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Herbivore extends Animal {

    public Herbivore(String emoji, double weight, int maxCountOnLocation, int speed, double saturation) {
        super(emoji, weight, maxCountOnLocation, speed, saturation);
    }

    @Override
    public void eat(Entity entity) {

    }
}
