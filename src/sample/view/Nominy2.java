package sample.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;
public class Nominy2 {
    //private final Button button;
    //SimpleStringProperty name;
    SimpleStringProperty name;
    SimpleStringProperty symbol;
    SimpleIntegerProperty totalvote;
    ImageView image;

    public Nominy2(String name,String imagePath, Integer vote) {
        this.name=new SimpleStringProperty(name);
        //this.symbol=new SimpleStringProperty(symbol);
        this.image=new ImageView(new Image("file:" + imagePath, 50, 50, true,true));
        this.totalvote=new SimpleIntegerProperty(vote);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSymbol() {
        return symbol.get();
    }

    public SimpleStringProperty symbolProperty() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol.set(symbol);
    }

    public int getTotalvote() {
        return totalvote.get();
    }

    public SimpleIntegerProperty totalvoteProperty() {
        return totalvote;
    }

    public void setTotalvote(int totalvote) {
        this.totalvote.set(totalvote);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
