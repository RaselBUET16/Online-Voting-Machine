package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.Main;
import sample.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminController{
    //Login1
    String str;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Text fix;
    @FXML
    Text error;
    @FXML
    Button button;
    @FXML
    void goadminHome() throws IOException {
        if(username.getText().length()<1||password.getText().length()<1)
            error.setText("All fields are required");
        else if(admin.search(username.getText(),password.getText()))
        {
            Main.adminHome();
            str=username.getText();
        }
        else error.setText("Error!Invalid Username or password");
    }
    //adminHome
    @FXML
    Button nominyButton;
    @FXML
    Button voterButton;
    @FXML
    void goNominySelection() throws IOException {
        Main.selectNominy();
        fix.setText(str);
    }
    @FXML
    void goVoterSelection() throws IOException {
        Main m=new Main();
        m.selectVoter();
    }
    @FXML
    void back() throws IOException {
        Main.adminHome();
    }
    @FXML
    private Text errorReport;

    @FXML
    TextField type;

    @FXML
    TextField name;

    @FXML
    TextField symbol;
    //for combobox
    /*@Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox1.setValue("Chairman");
        comboBox1.setItems(observableList1);
        comboBox2.setValue("Apple");
        comboBox2.setItems(observableList2);
    }

    @FXML
    ComboBox<String> comboBox1;
    @FXML
    ComboBox<String> comboBox2;
    ObservableList<String> observableList1= FXCollections.observableArrayList("Chairman",
            "Member","Secetary");
    ObservableList<String> observableList2=FXCollections.observableArrayList("Apple","Boat",
            "Peddy","Plough");

    @FXML
    void nominyAdd() throws Exception {

        if(comboBox1.getAccessibleText().length()<1||name.getText().length()<1||comboBox2.getAccessibleText().length()<1) {
            errorReport.setText("All fields are required");
        }
        else{
            Nominy n=new Nominy(name.getText(),comboBox2.getAccessibleText(),comboBox1.getAccessibleText());
            if(NominyList.add(n)) {
                Main.adminHome();
            }
            else errorReport.setText("Invalid Input!!");
        }
    }*/
    @FXML
    PasswordField passwordField;
    @FXML
    void voterAdd() throws Exception {
        //if(name.getText()==null||password)
        Voter v=new Voter(name.getText(),passwordField.getText());
        if(name.getText().length()<1||passwordField.getText().length()<1)
            errorReport.setText("All fields are required");
        else if(VoterList.add(v)==false) errorReport.setText("Invalid input");
        else {
            Main.adminHome();
        }

    }
    @FXML
    void logOut() throws IOException {
        Main.homePage();
    }
}
