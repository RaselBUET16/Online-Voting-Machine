package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.admin;

import java.io.IOException;

public class serverHomeController {
    static int port;
    @FXML
    TextField adminUsername;
    @FXML
    PasswordField adminPassword;
    @FXML
    TextField portNumber;
    @FXML
    Button button;
    @FXML
    void adminUser() throws IOException {
        port=Integer.parseInt(portNumber.getText());
        admin.write(adminUsername.getText(),adminPassword.getText());
        admin.second();
    }

    public static int getPortNumber() {
        return port;
    }
}
