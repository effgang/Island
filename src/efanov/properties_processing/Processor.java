package efanov.properties_processing;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Processor {


    public String getFieldsFromFile(String param) {
        try (FileReader reader = new FileReader("/Users/effgang/dev/Island/src/animal-settings.properties")) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties.getProperty(param);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
