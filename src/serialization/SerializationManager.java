package serialization;

import java.io.*;

public class SerializationManager {
    public static void main(String[] args) {
        //gravarObject();
        leitorObject();
    }

    private static void gravarObject(){
        Aluno aluno = new Aluno(01,"Mob","yourLiveIsOwer");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.ser"));){
            oos.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitorObject(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser"));){
            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
