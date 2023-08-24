/**
 * Создал Андрей Антонов 23.08.2023 17:36
 **/
package http.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderUtils {
    public static String getProperty(final String key) {
        try (InputStream inputStream = http.com.utils.PropertiesReaderUtils.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(key);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
