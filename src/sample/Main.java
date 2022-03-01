package sample;
import javafx.scene.layout.AnchorPane;
import sample.view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.text.TableView;
import java.io.IOException;

    public class Main extends Application {
    public static Stage stage;
    private static Parent borderPane;
    public static int m=0;
    public static int n=0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        stage.setTitle("Voting System");
        //stage.setMaximized(true);
        Main.homePage();
    }
    public static void homePage() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/Home.fxml"));
        borderPane=loader.load();
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void adminLogin() throws IOException {
                                                                                                                                                                                    FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/Login1.fxml"));
        Parent borderPane=loader.load();
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void voterLogin() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/Login.fxml"));
        Parent borderPane=loader.load();
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void adminHome() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/adminHome.fxml"));
        Parent borderPane=loader.load();
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void selectNominy() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/selectNominy.fxml"));
        Parent borderPane=loader.load();
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public  void selectVoter() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/selectVoter.fxml"));
        Parent borderPane=loader.load();
        //TableViewController controller = loader.getController();
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void giveVote() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/page1.fxml"));
        Parent borderPane=loader.load();
        TableViewController controller = loader.getController();
        controller.load(m);
        m++;
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
    public static void showResult() throws IOException {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/showingResult.fxml"));
            Parent borderPane=loader.load();
            tableForCount controller = loader.getController();
            controller.load1(n);
            n++;
            Scene scene=new Scene(borderPane);
            stage.setScene(scene);
            stage.show();
        }
    public static void ending()throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/endPage.fxml"));
        Parent anchorPane=loader.load();
        Scene scene=new Scene(anchorPane,600,600);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
