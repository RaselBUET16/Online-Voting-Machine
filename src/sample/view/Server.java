package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.Main;
import sample.admin;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread extends Thread {
    ServerSocket socket;
    public int v=0;
    static int a[]=new int[20];
    /*public static void c(Nominy n){
        int k=-1;
        for (Nominy no:NominyList.getNominyList()){
            k++;
            if(no.getType()==n.getType()&&no.getSymbol()==n.getSymbol())
                break;
        }
        System.out.println(a[k]+"  "+k);
        a[k]++;
    }*/
    public static int[] r(){
        return a;
    }
    ServerThread() throws IOException {
        try {
            socket = new ServerSocket(serverHomeController.getPortNumber());
            start();
        } catch (Exception e) {
            System.out.println("Exception in se");
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        System.out.println("Server is ok");
        try {
            while (true) {
                Socket insocket = socket.accept();//with the help of accept() we can got the request from client.
                System.out.println("Client is connected");


                OutputStream out = insocket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(out);

                //oos.writeObject();
                oos.flush();
                insocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int i = 0;



}

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        admin.main(null);
        ServerThread S=new ServerThread();
        System.out.println("connected");
    }
}
