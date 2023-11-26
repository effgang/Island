package efanov.simulation;


import efanov.island.IslandController;
import efanov.island.IslandMap;

public class SimulationStarter {
    private final IslandMap islandMap;
    private final SimulationSettings simulationSettings;
    private final IslandController controller;

    public SimulationStarter() {
        this.simulationSettings = new SimulationSettings();
        this.islandMap = new IslandMap(simulationSettings.getWidth(), simulationSettings.getHeight());
        this.controller = new IslandController(islandMap,null,simulationSettings);
    }

    public void start() {
        controller.getMap().init();
        controller.getMap().fillIsland(simulationSettings.getEntityCountOnCage());
        System.out.println();
    }
}
