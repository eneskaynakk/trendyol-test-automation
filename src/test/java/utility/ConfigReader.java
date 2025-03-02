package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            File configProperties = new File("configuration.properties");
            if (configProperties.exists()) {
                loadProperties(configProperties);
            }

            File resourcesDir = new File("src/test/resources");
            File[] files = resourcesDir.listFiles((dir, name) -> name.endsWith(".properties"));
            if (files != null) {
                for (File file : files) {
                    loadProperties(file);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration dosyası yüklenemedi!");
        }
    }

    private static void loadProperties(File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            properties.load(fileInputStream);
        }
    }

    public static String getProperty(String key) {
        String envValue = System.getenv(key);
        if (envValue != null) {
            return envValue;
        }

        String value = properties.getProperty(key);
        if (value == null) {
            System.out.println("Anahtar bulunamadı: " + key);
        }
        return value;
    }
}