package files;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileManager {
    public static void main(String[] args) {
        File file = new File("Teste.txt");
        try {
            boolean isCreate = file.createNewFile();
            System.out.println("Pode ler? "+file.canRead());
            System.out.println("Path: "+file.getPath());
            System.out.println("Absolute Path: "+file.getAbsolutePath());
            System.out.println("É diretório? "+file.isDirectory());
            System.out.println("É oculto? "+file.isHidden());
            System.out.println("Ultima Mod: "+new Date(file.lastModified()));
            System.out.println("Arquivo foi criado? "+isCreate);
            System.out.println("Arquivo existe? "+file.exists());
            System.out.println("Arquivo foi deletado? "+file.delete());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
