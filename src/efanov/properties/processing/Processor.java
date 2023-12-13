package efanov.properties.processing;

import efanov.constants.Constant;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Processor {

    public String getEmojiFromFile(String param) {
        try (FileReader reader = new FileReader(Constant.ANIMAL_SETTINGS_PROPERTIES)) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties.getProperty(param.toLowerCase() + ".emoji");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public double getWeightFromFile(String param) {
        try (FileReader reader = new FileReader(Constant.ANIMAL_SETTINGS_PROPERTIES)) {
            Properties properties = new Properties();
            properties.load(reader);
            return Double.parseDouble(properties.getProperty(param.toLowerCase() + ".weight"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getMaxCountFromFile(String param) {
        try (FileReader reader = new FileReader(Constant.ANIMAL_SETTINGS_PROPERTIES)) {
            Properties properties = new Properties();
            properties.load(reader);
            return Integer.parseInt(properties.getProperty(param.toLowerCase() + ".maxCount"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getSpeedFromFile(String param) {
        try (FileReader reader = new FileReader(Constant.ANIMAL_SETTINGS_PROPERTIES)) {
            Properties properties = new Properties();
            properties.load(reader);
            return Integer.parseInt(properties.getProperty(param.toLowerCase() + ".speed"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double getSaturationFromFile(String param) {
        try (FileReader reader = new FileReader(Constant.ANIMAL_SETTINGS_PROPERTIES)) {
            Properties properties = new Properties();
            properties.load(reader);
            return Double.parseDouble(properties.getProperty(param.toLowerCase() + ".saturation"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
