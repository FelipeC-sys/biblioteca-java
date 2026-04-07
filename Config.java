import java.io.FileInputStream;
import java.util.Properties;

public class Config {

    public static Properties cargarConfig() {

        Properties prop = new Properties();

        try {

            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);

        } catch (Exception e) {

            System.out.println("Error cargando archivo de configuración");
        }

        return prop;
    }
}