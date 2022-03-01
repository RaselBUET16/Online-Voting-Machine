package sample.view;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
public class VoterList{
    static List<Voter>voterList=new ArrayList();
    final static String OUTPUT_FILE_NAME="voter.txt";
    static List<Voter>givenVoterList=new ArrayList();
    //static BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));

    public static int i=0;
    public static boolean add(Voter voter) throws Exception{
        for(Voter v:voterList){
            if(voter.getPassword().equals(v.getPassword())) return false;
        }
        voterList.add(voter);
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));

        for(Voter voter1:voterList) {
            try {
                bw.append(voter1.getName() + "," + voter1.getPassword() + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        bw.close();
        i++;
        return true;
    }

    public static List<Voter> getVoterList() {
        return voterList;
    }

    public static int getI() {
        return i;
    }

    public static void addingVoter() throws Exception {
        BufferedReader br=new BufferedReader(new FileReader(OUTPUT_FILE_NAME));
        String s;
        while ((s=br.readLine())!=null){
            //String s=br.readLine();
            String sep[]=s.split(",");
            Voter v=new Voter(sep[0],sep[1]);
            VoterList.add(v);
        }

    }

    public static void addingGivenVoter() throws Exception {
        BufferedReader br=new BufferedReader(new FileReader("givenVoter.txt"));
        String s;
        while ((s=br.readLine())!=null){
            //String s=br.readLine();
            String sep[]=s.split(",");
            Voter v=new Voter(sep[0],sep[1]);
            givenVoterList.add(v);
        }

    }

    public static int search(Voter voter) throws IOException {
        for(Voter v:givenVoterList) {
            if (voter.getPassword().equals(v.getPassword()) &&
                    voter.getName().equals(v.getName())) return 0;
        }
        for(Voter v:voterList){
            if(voter.getPassword().equals(v.getPassword())&&
                    voter.getName().equals(v.getName())) {
                voterList.remove(v);
                givenVoterList.add(v);
                BufferedWriter bw=new BufferedWriter(new FileWriter("givenVoter.txt"));
                bw.append(voter.getName()+","+voter.getPassword());
                bw.close();
                return 1;
            }
        }
        return -1;
    }

    public static void FileOperations(int k) throws Exception {
        //final String INPUT_FILE_NAME = "in.txt";
        final String OUTPUT_FILE_NAME = "Voter.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));

        //bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for (Voter v : voterList) {
            try {
                bw.append(v.getName()+ "," + v.getPassword() + "\n");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
