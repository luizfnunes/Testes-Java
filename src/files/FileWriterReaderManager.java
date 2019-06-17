package files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderManager {
    public static void main(String[] args) {
        //normal();
        withResources();
    }
    public static void normal(){
        File file = new File("Arquivo.txt");
        try {
            // Um file, e true para append
            FileWriter fw = new FileWriter(file);
            fw.write("Esse texto é legal\nMuito legal Man!!");
            fw.flush();
            fw.close();

            // Ler
            FileReader fr = new FileReader(file);
            char[] in = new char[500];
            int size = fr.read(in);
            System.out.println("Tamanho: "+size);
            for (char c: in){
                System.out.print(c);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void withResources(){
        File file = new File("Arquivo.txt");
        try (FileWriter fw = new FileWriter(file);
             FileReader fr = new FileReader(file)){

            fw.write("Esse texto é legal\nMuito legal Man!!");
            fw.flush();

            char[] in = new char[500];
            int size = fr.read(in);
            System.out.println("Tamanho: "+size);
            for (char c: in){
                System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
