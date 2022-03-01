package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class comboBoxController implements Initializable {
    @Override
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
    @FXML
    private Text errorReport;
    @FXML
    TextField name;
    ObservableList<String> observableList1= FXCollections.observableArrayList("Chairman",
            "Member","Secetary","Mayor","Councilor");
    ObservableList<String> observableList2=FXCollections.observableArrayList("Boat",
            "Peddy","Plough","Cycle","Fan","Tubewell","Umbrella","Lock-Key","Scale");
    @FXML
    void back() throws IOException {
        Main.adminHome();
    }
    @FXML
    void nominyAdd() throws Exception {

        if(comboBox1.getValue().length()<1||name.getText().length()<1||comboBox2.getValue().length()<1) {
            errorReport.setText("All fields are required");
        }
        else{
            Nominy n=new Nominy(name.getText(),comboBox2.getValue(),comboBox1.getValue());
            if(NominyList.add(n)) {
                Main.adminHome();
            }
            else errorReport.setText("Invalid Input!!");
        }
    }
}
