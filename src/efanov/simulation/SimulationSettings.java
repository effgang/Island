package efanov.simulation;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SimulationSettings {
    public static final int INITIAL_GROW_TIME = 100;
    private int width = 100;
    private int height = 20;
    private int entityCountOnCage = 10;
    private double reduceHealth = 15;
    private double increaseHealth = 15;
    private int plantGrowTime = 200;
    private int lifeCycleTact = 200;

}
