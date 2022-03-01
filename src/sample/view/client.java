package sample.view;

import sample.Main;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class client {

    public static void main(String[] args) throws IOException {
        try{
            Socket s=new Socket("127.0.0.1",8765);
            InputStream is;
            OutputStream os;
            ObjectInputStream ois;
            ObjectOutputStream oos;
            is=s.getInputStream();
            os=s.getOutputStream();
            ois=new ObjectInputStream(is);
            oos=new ObjectOutputStream(os);
            Main.main(null);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
