package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;

import javafx.scene.text.Text;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class voterController {

    //Login1
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    void back() throws IOException {
        Main.homePage();
    }
    @FXML
    void goVoterHome() throws Exception {
        //Main.adminHome();
        VoterList.addingVoter();
        NominyList.addingNominy();
        VoterList.addingGivenVoter();
        Voter v = new Voter(username.getText(), password.getText());
        int i=VoterList.search(v);
        if(username.getText().length()<1||password.getText().length()<1)
            errorReport.setText("All fields are required");
        else if (i==1) Main.giveVote();
        else if(i==-1)errorReport.setText("Error!Invalid username or password");
        else if(i==0) JOptionPane.showMessageDialog(null,
                "You have already given your vote");
    }

    @FXML
    private Text errorReport;

    //voting page
    @FXML
    private Text input;



}