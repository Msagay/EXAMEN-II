//Refactorización
package DataAccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Infrastructure.smAppConfig;

public class smDataFileHelper {
    public static String smBuscarMunicion(String smArmaNombre) {
        // //Refactorización: Added helper for file reading
        try (BufferedReader smBr = new BufferedReader(new FileReader(smAppConfig.smFILE_MUNISION))) {
            String smLine;
            while ((smLine = smBr.readLine()) != null) {
                String[] smParts = smArmaNombre.split("/");
                for (String smPart : smParts) {
                    if (smLine.contains(smPart.trim())) {
                        return smLine.trim();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
