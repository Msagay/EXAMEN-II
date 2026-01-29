//Refactorización
package Infrastructure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class smAppConfig {
    public static String smDB_URL;
    public static String smDRIVER;
    public static String smFILE_MUNISION;
    public static String smFILE_TRACER;

    static {
        Properties smProps = new Properties();
        try (FileInputStream smFis = new FileInputStream("src/app.properties")) {
            smProps.load(smFis);
            smDB_URL = smProps.getProperty("db.url");
            smDRIVER = smProps.getProperty("db.driver");
            smFILE_MUNISION = smProps.getProperty("file.munision");
            smFILE_TRACER = smProps.getProperty("file.tracer");
        } catch (IOException e) {
            System.err.println("ERROR: No se pudo cargar app.properties");
            e.printStackTrace();
        }
    }
}
