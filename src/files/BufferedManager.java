package files;

import java.io.*;

public class BufferedManager {
    public static void main(String[] args) {
        normal();
        withResources();
    }
    public static void normal(){
        File file = new File("Arquivo.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Esse é um texto com BufferedWrite");
            bw.newLine();
            bw.write("Conforme-se com isso!");
            bw.flush();
            bw.close();

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s = null;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void withResources(){
        File file = new File("Arquivo.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            BufferedReader br = new BufferedReader(new FileReader(file))) {

            bw.write("Esse é um texto com BufferedWrite");
            bw.newLine();
            bw.write("Conforme-se com isso!");
            bw.flush();

            String s = null;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
