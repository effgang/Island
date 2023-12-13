package efanov.entities.plants;

import efanov.entities.Entity;
import lombok.Getter;

@Getter
public class Herb extends Entity {

    public Herb(String emoji, double weight, int maxCountOnLocation) {
        super(emoji, weight, maxCountOnLocation);
    }

}
