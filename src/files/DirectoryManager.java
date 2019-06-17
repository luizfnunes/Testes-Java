package files;

import java.io.File;
import java.io.IOException;

public class DirectoryManager {
    public static void main(String[] args) {
        File directory = new File("folder");
        boolean dir = directory.mkdir();
        System.out.println("Diretorio criado? "+dir);
        File file = new File(directory, "Arquivo.txt");
        try {
            System.out.println("Diretório criado? "+ file.createNewFile());
            // Renomear arquivo
            File renomed = new File(directory,"arquivo_renomeado.txt");
            boolean isRenomed = file.renameTo(renomed);
            System.out.println("Renomeado? "+isRenomed);
            // Renomear Diretorio
            File dirRenamed = new File("folder2");
            boolean dirRn = directory.renameTo(dirRenamed);
            System.out.println("Diretorio renomeado? "+dirRn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        buscarArquivos();
    }

    public static void buscarArquivos(){
        File file = new File("folder2");
        String[] list = file.list();
        for(String item: list){
            System.out.println(item);
        }
    }
}
