package sample.view;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NominyList{
    public static List<Nominy> nominyList=new ArrayList();
    public static int n=0;
    final static String OUTPUT_FILE_NAME = "Nominy.txt";
    BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));

    public static List<Nominy> getNominyList() {
        return nominyList;
    }
    //static BufferedReader br=new BufferedReader(new FileReader(OUTPUT_FILE_NAME));
    public static void addingNominy() throws Exception {
        BufferedReader br=new BufferedReader(new FileReader(OUTPUT_FILE_NAME));
        String s;
        while ((s=br.readLine())!=null){
            //String s=br.readLine();
            String sep[]=s.split(",");
            Nominy n=new Nominy(sep[0],sep[1],sep[2]);
            NominyList.add(n);
        }

    }
    public NominyList() throws IOException {
    }

    public static int getN() {
        return n;
    }

    public static boolean add(Nominy nominy) throws IOException {
        for(Nominy n:nominyList){
            if((nominy.getSymbol().equals(n.getSymbol()))&&
                    nominy.getType().equals(n.getType())) return false;
        }
        nominyList.add(nominy);
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for(Nominy nominy1:nominyList) {
            try {
                bw.append(nominy1.getName() + "," + nominy1.getSymbol() + "," + nominy1.getType() + "\n");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //n++;
        bw.close();
        return true;
    }
    public static int distinct()throws NullPointerException{
        int i=0, k = nominyList.size();
        String str[]=new String[k];
        for(Nominy p:nominyList){
            str[i++]=p.getType();
        }
        for (i = 0; i <str.length; i++) {
                for (int j = i + 1; j <str.length ; j++) {
                    if (str[i].equals(str[j])) {
                        k--;
                        break;
                    }
                }
            }

        return k;
    }
    public static String[] determine()throws NullPointerException{
        int k=nominyList.size();
        int i=0;
        String str[]=new String[k];
        for(Nominy p:nominyList){
            str[i++]=p.getType();
        }
        String s[]=new String[k];
        k=0;
        s[k++]=new String(str[0]);
        for(i=0;i<str.length;i++){
            for(int j=i-1;j>=0;j--){
                if(str[i].equals(str[j])){
                    break;
                }
                else if(j==0){
                    s[k++]=new String(str[i]);
                }
            }
        }
        return s;
    }

    public static List seperate(String s)throws NullPointerException{
        List<Nominy> list1=new ArrayList();
        for(Nominy n:nominyList){
            if(s.equals(n.getType())) list1.add(n);
        }
        return list1;
    }

    public static void addingVote() throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("vote.txt"));
        for(Nominy n:nominyList){
            //System.out.println(n.getTotalVote());
            String s=n.getTotalVote()+"";
            bw.append(s+'\n');
        }
        bw.close();
    }

    public static int[] readingVote() throws IOException {
        int a[]=new int[nominyList.size()];
        int i=0;
        BufferedReader br=new BufferedReader(new FileReader("vote.txt"));
        /*if(br.readLine()==null){
            System.out.println("not started");
        }
        else{*/
        String s1;
            while ((s1=br.readLine())!=null){
               //String s1=br.readLine();
                a[i++]=Integer.parseInt(s1);
            }

        return a;
    }

    public static void setVote() throws Exception {
        int a[]=new int[50];
        int i=0;
        BufferedReader br=new BufferedReader(new FileReader("vote.txt"));
        /*if(br.readLine()==null){
            System.out.println("not started");
        }
        else{*/String s;
            while ((s=br.readLine())!=null){
                //String s1=br.readLine();
                a[i++]=Integer.parseInt(s);
            }
            i=0;
            for(Nominy n:nominyList){
                //System.out.println(a[i]);
                n.setTotalVote(a[i]);
                i++;
            }

    }
}
