package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NewIOAttributes {
    public static void main(String[] args) throws IOException {
        Date primeiroDeDezembro = new GregorianCalendar(2019, Calendar.DECEMBER,1).getTime();
        // Usando forma antiga (IO)
        File file = new File("pasta/arquivo.txt");
        file.createNewFile();
        file.setLastModified(primeiroDeDezembro.getTime());
        System.out.println(file.lastModified());
        // Usando New IO (NIO)
        Path path = Paths.get("pasta/arquivo_nio.txt");
        if(!Files.exists(path))
            Files.createFile(path);
        FileTime ft = FileTime.fromMillis(primeiroDeDezembro.getTime());
        Files.setLastModifiedTime(path, ft);
        System.out.println(Files.getLastModifiedTime(path));
        System.out.println("Leitura? "+Files.isReadable(path));
        System.out.println("Escrita? "+Files.isWritable(path));

        // Interfaces para ler atributos
        // BasicFileAttributes, PosixFileAttributes, DosFileAttributes
        BasicFileAttributes basicAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println(basicAttributes.creationTime());
        System.out.println(basicAttributes.isDirectory());
        System.out.println(basicAttributes.isRegularFile());
        System.out.println(basicAttributes.lastModifiedTime());
        System.out.println(basicAttributes.isSymbolicLink());
        System.out.println(basicAttributes.size());

        // Interface para modificar atributos
        // BasicFileAttributeView, PosixileAtrributeView, DosFileAttributeView.
        // FileOwerAttributeView, AclFileAttributeView
        FileTime lastModified = basicAttributes.lastModifiedTime();
        FileTime created = basicAttributes.creationTime();
        FileTime lastAccess = FileTime.fromMillis(System.currentTimeMillis());

        BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        basicView.setTimes(lastModified,created,lastAccess);
        // Depois de mudar é necessário ler o arquivo novamente
        basicAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println("Criado: "+basicAttributes.creationTime());
        System.out.println("Modificado: "+basicAttributes.lastModifiedTime());
        System.out.println("Acesso: "+basicAttributes.lastAccessTime());

    }
}
