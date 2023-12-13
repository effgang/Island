package efanov.entities.animals;

import efanov.constants.Constant;
import lombok.Getter;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

@Getter
public class EatingMap {
    InputStream inputStream;

    {
        try {
            inputStream = new FileInputStream(Constant.RESOURCES_PROBABILITY_YAML);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Yaml yaml = new Yaml();
    Map<String, Map<String, Integer>> eatingProbability = yaml.load(inputStream);

}
