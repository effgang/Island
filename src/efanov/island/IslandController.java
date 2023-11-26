package efanov.island;

import efanov.entities.animals.EatingMap;
import efanov.simulation.SimulationSettings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IslandController {
    private final IslandMap map;
    private final EatingMap eatingMap;
    private final SimulationSettings simulationSettings;

    public IslandController(IslandMap map, EatingMap eatingMap, SimulationSettings simulationSettings) {
        this.map = map;
        this.eatingMap = eatingMap;
        this.simulationSettings = simulationSettings;
    }
}
