package efanov.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public abstract class Entity {
    private String emoji;
    private double weight;
    private int maxCountOnLocation;

}
