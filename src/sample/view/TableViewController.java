package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import javax.swing.table.TableColumn;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewController implements Initializable{
    //List<Nominy> addList=NominyList.getNominyList();
    @FXML private  TableView<Nominy> table;
    @FXML private javafx.scene.control.TableColumn<Nominy,String> name;
    @FXML private javafx.scene.control.TableColumn<Nominy,String> type;
    //@FXML private javafx.scene.control.TableColumn<Nominy,String> symbol;
    @FXML private javafx.scene.control.TableColumn<Nominy,Image> image;
    @FXML private javafx.scene.control.TableColumn<Nominy,Button> button;
    @FXML private  Text input;
    public  ObservableList<Nominy> list=FXCollections.observableArrayList(

    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setCellValueFactory(new PropertyValueFactory<Nominy, String>("Name"));
        //symbol.setCellValueFactory(new PropertyValueFactory<Nominy, String>("Symbol"));
        image.setCellValueFactory(new PropertyValueFactory<Nominy,Image>("Image"));
        type.setCellValueFactory(new PropertyValueFactory<Nominy, String>("Type"));
        button.setCellValueFactory(new PropertyValueFactory<Nominy, Button>("Button"));

    }
    public void load(int l){
        int i = NominyList.distinct();
        list.removeAll();
        String str[] = NominyList.determine();
        List<Nominy> addList = NominyList.seperate(str[l]);
        for (Nominy n : addList) {
            list.add(n);
        }
        table.setEditable(true);
        table.setItems(list);
        input.setText(str[l]);
        table.refresh();
    }

    @FXML
    public static void countVote() throws IOException {
        /*List<Nominy>list=NominyList.getNominyList();
        int n=NominyList.distinct();
        int a[]=new int[10];
        int i=0;
        for(Nominy m:list){
            a[i++]=m.getTotalVote();
        }*/
        int a[]=NominyList.readingVote();
        int i=0;
        int k=a[0];
        for(i=0;i<a.length;i++){
            if(a[i]>k) k=a[i];
        }
        System.out.println(k);
    }
    //@FXML
    /*public void load1(int l){
        //int i = NominyList.distinct();
        //list.removeAll();
        String str[] = NominyList.determine();
        List<Nominy> addList = NominyList.seperate(str[l]);
        int n=NominyList.distinct();
        int a[]=new int[10];
        int i=0;
        for(Nominy m:list){
            a[i++]=m.getTotalVote();
        }
        int k=a[0];
        for(i=0;i<a.length;i++){
            if(a[i]>k) k=a[i];
        }

    }*/
}

