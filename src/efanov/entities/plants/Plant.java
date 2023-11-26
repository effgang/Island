package efanov.entities.plants;

import efanov.entities.Entity;

public class Plant extends Entity {

    public Plant(String emoji, double weight, int maxCountOnLocation) {
        super(emoji, weight, maxCountOnLocation);
    }

    @Override
    public String getEmoji() {
        return super.getEmoji();
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public int getMaxCountOnLocation() {
        return super.getMaxCountOnLocation();
    }
}
