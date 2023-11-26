package efanov.entities.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Action {
    EAT(90),
    REPRODUCE(60),
    MOVE(100);

    private final int actionChance;
}
