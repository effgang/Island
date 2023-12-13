package efanov.statistic;

import efanov.entities.Entity;
import efanov.island.IslandMap;
import efanov.island.Location;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Statistic {
    public static final String EMOJI_KEY_VALUE = "{0} - {1}";
    private final IslandMap islandMap;

    public Statistic(IslandMap islandMap) {
        this.islandMap = islandMap;
    }

    public Map<String, Integer> getAllEntitiesStatistic() {
        Map<String, Integer> allEntitiesStatistic = new ConcurrentHashMap<>();
        for (int y = 0; y < islandMap.getHeight(); y++) {
            for (int x = 0; x < islandMap.getWidth(); x++) {
                Location location = islandMap.getLocations()[y][x];
                List<Entity> entities = location.getEntities();
                for (Entity entity : entities) {
                    String emoji = entity.getEmoji();
                    allEntitiesStatistic.merge(emoji, 1, (oldValue, newValue) -> oldValue + 1);
                }
            }
        }
        return allEntitiesStatistic;
    }

    public void printStatistic(Map<String, Integer> allEntitiesStatistic) {
        allEntitiesStatistic.forEach((key, value) -> System.out.println(MessageFormat.format(EMOJI_KEY_VALUE, key, value)));
        System.out.println("\n");
    }

}
