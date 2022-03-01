package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;
import javafx.scene.control.Button;
import java.io.IOException;

public class HomeController {

    //for admin button
    @FXML
    Button adminButton;
    @FXML
    void goadmin() throws IOException {
        Main.adminLogin();
    }

    //for voter button
    @FXML
    Button voterButton;
    @FXML
    void goVoter() throws IOException {
        Main.voterLogin();
    }



}