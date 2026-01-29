import ConsoleApp.smLogin;
import UserInterface.smExoTrooperForm;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        // Init Login
        smLogin smLoginService = new smLogin();
        
        if (smLoginService.smAutenticar()) {
            // Launch GUI if auth is successful
            SwingUtilities.invokeLater(() -> {
                smExoTrooperForm smForm = new smExoTrooperForm();
                smForm.setVisible(true);
            });
        } else {
            System.exit(0);
        }
    }
}
