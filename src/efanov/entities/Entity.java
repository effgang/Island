package efanov.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Entity {
    private String emoji;
    private double weight;
    private int maxCountOnLocation;

}
