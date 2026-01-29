//Refactorización
package Infrastructure;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class smCMD {
    
    // ANSI Colors
    public static final String smANSI_RESET = "\u001B[0m";
    public static final String smANSI_BLUE = "\u001B[34m";
    public static final String smANSI_RED = "\u001B[31m";

    public static void smImprimir(String smMensaje) {
        if (smMensaje.startsWith("GOOD")) {
            System.out.println(smANSI_BLUE + smMensaje + smANSI_RESET);
        } else if (smMensaje.startsWith("ERROR")) {
            System.out.println(smANSI_RED + smMensaje + smANSI_RESET);
        } else {
            System.out.println(smMensaje);
        }
        
        smGuardarEnArchivo(smMensaje);
    }

    private static void smGuardarEnArchivo(String smMensaje) {
        try (FileWriter smFw = new FileWriter(smAppConfig.smFILE_TRACER, true);
             PrintWriter smPw = new PrintWriter(smFw)) {
            smPw.println(smMensaje);
        } catch (IOException e) {
            System.err.println("Error writing to ExoTracer.txt: " + e.getMessage());
        }
    }
}
