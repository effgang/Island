package efanov.dialog;

import efanov.constants.Constant;
import efanov.simulation.SimulationSettings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDialog {
    public boolean exit = false;
    public String paramType = null;

    public void showMenuAndChangeParameters(SimulationSettings settings) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(Constant.DATA);
            System.out.println(Constant.GREETING);
            while (true) {
                System.out.println(Constant.DELIMITER);
                System.out.print(Constant.START_MENU);
                System.out.println(Constant.DELIMITER);
                System.out.print(Constant.WRITE_NUMBER_OF_PARAMETER);
                int ans;
                try {
                    ans = scanner.nextInt();
                    if (ans < 0 || ans > 5) {
                        System.out.println(Constant.INVALID_NUMBER_PLEASE_TRY_AGAIN);
                        continue;
                    }
                } catch (InputMismatchException e) {
                    String badValue = scanner.nextLine();
                    System.out.println(Constant.IT_S_NOT_A_NUMBER + badValue);
                    continue;
                }

                if (ans != 5) {
                    System.out.print(Constant.WRITE_THE_PARAMETER_VALUE);
                }
                if (ans == 1) {
                    paramType = Constant.MAP_WIDTH;
                }
                if (ans == 2) {
                    paramType = Constant.MAP_HEIGHT;
                }
                if (ans == 3) {
                    paramType = Constant.COUNT_ENTITIES_IN_ONE_LOCATION;
                }
                if (ans == 4) {
                    paramType = Constant.LIFE_CYCLE_OF_SIMULATION;
                }
                if (ans == 5) {
                    break;
                }

                int param;
                while (true) {
                    try {
                        param = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        String badValue = scanner.nextLine();
                        System.out.println(Constant.IT_S_NOT_A_NUMBER + badValue + "\n" + Constant.ENTER_THE_PARAMETER_VALUE_FOR + paramType);
                        continue;
                    }
                    break;
                }


                switch (ans) {
                    case 1 -> settings.setWidth(param);
                    case 2 -> settings.setHeight(param);
                    case 3 -> settings.setEntityCountOnCage(param);
                    case 4 -> settings.setLifeCycleTact(param);
                    default -> System.out.println(Constant.INVALID_NUMBER_PLEASE_TRY_AGAIN);
                }

                System.out.println(Constant.CHANGE_DATA);

                while (true) {
                    try {
                        int solution = scanner.nextInt();
                        if (solution == 1) {
                            break;
                        } else if (solution == 2) {
                            exit = true;
                            break;
                        } else {
                            System.out.println(Constant.INVALID_NUMBER_PLEASE_TRY_AGAIN);
                        }

                    } catch (InputMismatchException e) {
                        String badValue = scanner.nextLine();
                        System.out.println(Constant.INVALID_ANSWER + badValue + Constant.WRITE_1_OR_2);
                    }

                }
                if (exit) {
                    break;
                }
            }
        } finally {
            System.out.println(Constant.SIMULATION_STARTING);
        }
    }
}
