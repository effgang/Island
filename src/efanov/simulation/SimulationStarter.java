package efanov.simulation;


import efanov.dialog.UserDialog;
import efanov.entities.animals.EatingMap;
import efanov.island.IslandController;
import efanov.island.IslandMap;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulationStarter {
    public static ScheduledExecutorService executorService;
    private final SimulationSettings simulationSettings;
    private final IslandController controller;
    private final IslandMap islandMap;
    private final UserDialog dialog;

    public SimulationStarter() {
        this.dialog = new UserDialog();
        this.simulationSettings = new SimulationSettings();
        EatingMap eatingMap = new EatingMap();
        this.islandMap = new IslandMap(simulationSettings);
        this.controller = new IslandController(islandMap, eatingMap, simulationSettings);
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void start() {
        dialog.showMenuAndChangeParameters(simulationSettings);
        controller.getMap().init();
        controller.getMap().fillIsland(simulationSettings.getEntityCountOnCage());
        executorService.scheduleWithFixedDelay(islandMap.plantGrow(),
                SimulationSettings.INITIAL_GROW_TIME,
                simulationSettings.getPlantGrowTime(),
                TimeUnit.MILLISECONDS);
        controller.startLife();

    }

}
