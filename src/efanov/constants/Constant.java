package efanov.constants;

import efanov.simulation.SimulationSettings;

public class Constant {
    public static final String RESOURCES_PROBABILITY_YAML = "/Users/effgang/dev/Island/src/efanov/resources/probability.yaml";
    public static final String ANIMAL_SETTINGS_PROPERTIES = "/Users/effgang/dev/Island/src/efanov/resources/animal-settings.properties";
    public static final int PLANT_COUNT_TO_ADD = 10;
    public static final String END = "***Simulation is over***";
    public static final String DELIMITER = "-".repeat(20);
    public static final String SIMULATION_STARTING = "Simulation starting...";
    public static final String CHANGE_DATA = """
            Would you like to change another parameter ?
            1 - Yes
            2 - No""";
    public static final String INVALID_ANSWER = "Invalid answer ";
    public static final String WRITE_1_OR_2 = " please write 1 or 2";
    public static final String IT_S_NOT_A_NUMBER = "It's not a number: ";
    public static final String ENTER_THE_PARAMETER_VALUE_FOR = "Please re-enter the parameter value for ";
    public static final String WRITE_THE_PARAMETER_VALUE = "Write the parameter value: ";
    public static final String WRITE_NUMBER_OF_PARAMETER = "Write parameter number: ";
    public static final String GREETING = "We are glad to welcome you in our simulation, choose the parameters that you want to change";
    public static final String INVALID_NUMBER_PLEASE_TRY_AGAIN = "Invalid number, please try again";
    public static final String MAP_WIDTH = "Map width";
    public static final String MAP_HEIGHT = "Map height";
    public static final String COUNT_ENTITIES_IN_ONE_LOCATION = "Count entities in one location";
    public static final String LIFE_CYCLE_OF_SIMULATION = "Life cycle of simulation (tact)";
    public static final SimulationSettings settings = new SimulationSettings();
    public static final String START_MENU = """
            1. Map width
            2. Map height
            3. Count entities in one location
            4. Life cycle of simulation (tact)
            5. Continue
            """;
    public static final String DATA = "Initial data:\n" +
            "width -> " + settings.getWidth() + "\n" +
            "height -> " + settings.getHeight() + "\n" +
            "Count entities in one location -> " + settings.getEntityCountOnCage() + "\n" +
            "Life cycle of simulation (tact) -> " + settings.getLifeCycleTact() + "\n";

}
