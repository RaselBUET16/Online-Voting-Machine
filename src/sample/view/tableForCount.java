package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class tableForCount implements Initializable{
    /*@FXML
    TableView<Nominy2> table1;
    @FXML
    private javafx.scene.control.TableColumn<Nominy2,String>name;
    @FXML private javafx.scene.control.TableColumn<Nominy2,String>symbol;
    @FXML private javafx.scene.control.TableColumn<Nominy2,Integer>vote;
    @FXML private Text input;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setCellValueFactory(new PropertyValueFactory<Nominy2,String>("name"));
        symbol.setCellValueFactory(new PropertyValueFactory<Nominy2,String>("symbol"));
        vote.setCellValueFactory(new PropertyValueFactory<Nominy2,Integer>("vote"));
    }
    public ObservableList<Nominy2>list=FXCollections.observableArrayList(
            new Nominy2("abser","apple",45),
            new Nominy2("ayat","ball",78)
    );
    public void load1(int l){
        int i=NominyList.distinct();
        list.removeAll();
        String str[]=NominyList.determine();
        List<Nominy>addList=NominyList.seperate(str[l]);
        //for(Nominy n:addList){
          //  Nominy2 n1=new Nominy2(n.getName(),n.getSymbol(),n.getTotalVote());
            //list.add(n1);
        //}
        table1.setEditable(true);
        table1.setItems(list);
        input.setText(str[l]);
        table1.refresh();
    }
    */@FXML
    private TableView<Nominy2> table1;
    @FXML private javafx.scene.control.TableColumn<Nominy2, String> name;
    @FXML private javafx.scene.control.TableColumn<Nominy2, Integer> totalvote;
    //@FXML private javafx.scene.control.TableColumn<Nominy2, String> symbol;
    @FXML private javafx.scene.control.TableColumn<Nominy2,Image> image;
    //@FXML private javafx.scene.control.TableColumn<Nominy,Button> button;
    @FXML private Text input;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setCellValueFactory(new PropertyValueFactory<Nominy2, String>("Name"));
        //symbol.setCellValueFactory(new PropertyValueFactory<Nominy2, String>("Symbol"));
        image.setCellValueFactory(new PropertyValueFactory<Nominy2,Image>("Image"));
        totalvote.setCellValueFactory(new PropertyValueFactory<Nominy2, Integer>("Totalvote"));
        //button.setCellValueFactory(new PropertyValueFactory<Nominy2, Button>("Button"));

    }
    ObservableList<Nominy2> list= FXCollections.observableArrayList(

    );

    public void load1(int l)throws NullPointerException{
        int i = NominyList.distinct();
        list.removeAll();
        String str[] = NominyList.determine();
        List<Nominy> addList = NominyList.seperate(str[l]);
        for (Nominy n : addList) {
            Nominy2 n1=new Nominy2(n.getName(),"test.jpg",n.getTotalVote());
            list.add(n1);
            //System.out.println("adding"+" "+n1.getVote());
        }
        table1.setEditable(true);
        table1.setItems(list);
        input.setText(str[l]);
        table1.refresh();
    }
    @FXML
    Button button;
    static int i=1;
    @FXML
    void work(){
        button.setOnAction(e ->{
                    if(i<NominyList.distinct()) {
                        i++;
                        try {
                            Main.showResult();

                        } catch (IOException e1) {
                            //e1.printStackTrace();
                            System.out.println("Error in nominy2");
                        }
                    }
                    else{
                        try {
                            Main.ending();
                            //Main.showResult();
                            //TableViewController.countVote();
                            //Main.showResult();
                        }catch (Exception e3){
                            e3.printStackTrace();
                            //System.out.println("Error in ending");
                        }
                    }
                }

        );
    }
}
