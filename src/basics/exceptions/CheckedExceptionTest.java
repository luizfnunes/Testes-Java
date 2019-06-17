package basics.exceptions;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionTest {
    public static void main(String[] args) {

    }

    public static void criarArquivo(){
        File file = new File("Arquivo.txt");
        try{
            file.createNewFile();
            System.out.println("Arquivo criado!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
