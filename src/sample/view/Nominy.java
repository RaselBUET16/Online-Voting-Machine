package sample.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;

import java.io.*;

public class Nominy {
    private final Button button;
    SimpleStringProperty name;
    SimpleStringProperty symbol;
    SimpleStringProperty type;
    ImageView image;
    public  int totalVote;
    public static int i=1;

    public Nominy(String name, String symbol, String type) throws Exception {
        this.name = new SimpleStringProperty(name);
        this.symbol =new SimpleStringProperty(symbol);
        String imagePath=symbol+".jpg";
        this.image=new ImageView(new Image("file:"+imagePath,50,50,true,true));
        this.type = new SimpleStringProperty(type);
        NominyList.setVote();
        this.button = new Button("Click");
        button.setOnAction( e -> {
            try {
                System.out.println("setting");
                //NominyList.setVote();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            Nominy n=this;
            System.out.println(n.getName()+" "+n.getSymbol());
            n.totalVote++;
            if(i<NominyList.distinct()) {
                i++;
                try {
                    Main.giveVote();

                } catch (IOException e1) {
                    //e1.printStackTrace();
                    System.out.println("Error in nominy");
                }
            }
            else{
                try {
                    NominyList.addingVote();
                    //Main.ending();
                    //Main.showResult();
                    TableViewController.countVote();
                    Main.showResult();
                }catch (Exception e3){
                    e3.printStackTrace();
                    //System.out.println("Error in ending");
                }
            }


        });

    }
    public int getTotalVote() {
        return totalVote;
    }
    public void setTotalVote(int n){totalVote=n;}
    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public String getSymbol() {
        return symbol.get();
    }
    public void setSymbol(String symbol) {
        this.symbol.set(symbol);
    }

    public String getType() {
        return type.get();
    }
    public void setType(String type) {
        this.type.set(type);
    }

    public ImageView getImage() {
        return image;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty symbolProperty() {
        return symbol;
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public Button getButton() {
        return button;
    }
}
