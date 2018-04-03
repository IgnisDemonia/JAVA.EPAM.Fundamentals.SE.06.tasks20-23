import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *Отвечаю на вопрос: при добавлении в map-коллекцию пары с ключом, аналогичным уже существующему в коллекции,
 * старая пара остаётся на месте,а новая будет проигнорирована.
 */

public class PropertiesReader {
    private static final String APPROACH_TO_PROPERTIES = "src\\main\\resources\\config.properties";

    public static void main(String[] args) {
        Properties properties = new Properties();
        Map<String, String> propertiesMap = new HashMap<>();

        try(FileInputStream fis = new FileInputStream(APPROACH_TO_PROPERTIES)) {
            properties.load(fis);

            for (String pair : properties.stringPropertyNames()) {
                propertiesMap.put(pair, properties.getProperty(pair));
            }

            for (Map.Entry<String, String> pairs : propertiesMap.entrySet()) {
                System.out.println(pairs.getKey() + " : " + pairs.getValue());
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
