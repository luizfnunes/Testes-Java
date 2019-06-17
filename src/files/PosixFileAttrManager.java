package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttrManager {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta/teste_linux.txt");
        if(Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PosixFileAttributes pf = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println(pf.permissions());
        System.out.println("Modificando...");
        Set<PosixFilePermission> permission = PosixFilePermissions.fromString("rwxrw-rw-");
        Files.setPosixFilePermissions(path,permission);
        pf = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println(pf.permissions());
    }
}
