package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;

public class admin extends Application{
    final static String OUTPUT_FILE_NAME="admin.txt";
    public static Stage stage;
    private static Parent borderPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;
        stage.setTitle("Server");
        admin.home();
    }
    public static void home() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(admin.class.getResource("view/serverHome.fxml"));
        borderPane=loader.load();
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void second() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(admin.class.getResource("view/serverEnd.fxml"));
        borderPane=loader.load();
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void write(String username,String password) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        bw.write(username+","+password);
        bw.close();
    }
    public static boolean search(String username,String password) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(OUTPUT_FILE_NAME));
        String s=br.readLine();
        String s1[]=s.split(",");
        if(s1[0].equals(username)&&s1[1].equals(password)) return true;
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}