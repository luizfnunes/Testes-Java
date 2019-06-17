package files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

class AcharTodosTxt extends SimpleFileVisitor<Path>{
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes var2){
        if(file.getFileName().toString().endsWith(".txt")){
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

public class FileVisitorManager {
    public static void main(String[] args) throws IOException {
        //Files.walkFileTree(Paths.get("pasta"),new AcharTodosTxt());
        Files.walkFileTree(Paths.get("pasta"),new PrintDirs());
    }
}

class PrintDirs extends SimpleFileVisitor<Path>{
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes var2){
        System.out.println("Diretorio: "+dir);
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes var2){
        System.out.println("Arquivo: "+file.getFileName());
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException var2){
        System.out.println("Post: "+dir);
        return FileVisitResult.CONTINUE;
    }

}