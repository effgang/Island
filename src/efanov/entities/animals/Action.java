package efanov.entities.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Action {
    EAT(30),
    REPRODUCE(30),
    MOVE(30),
    SLEEP(10);

    private final int actionChance;
}
