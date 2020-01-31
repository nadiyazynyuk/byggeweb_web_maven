package dk.byggeweb.infrastructure.environment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentProperties {
    private static EnvironmentProperties instance;

    private final Properties mainProperties;

    private EnvironmentProperties() {
        mainProperties = new Properties();
        FileInputStream in = null;
        try {
            String mainPropertiesFilePath = "src/main/resources/main.properties";
            in = new FileInputStream(mainPropertiesFilePath);
            mainProperties.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Main properties file not found");
        } catch (IOException e) {
            throw new RuntimeException("Could not read main properties file");
        }
    }

    public static EnvironmentProperties getInstance() {
        if (instance == null) {
            instance = new EnvironmentProperties();
        }
        return instance;
    }

    public String getProperty(String key) {
        return mainProperties.getProperty(key);
    }

    public int getIntProperty(String key) {
        return Integer.parseInt(getProperty(key));
    }

    public boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }
}
