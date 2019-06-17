package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NewIOManager {
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("/home/luiz/IdeaProjects/Testes/arquivo.txt");
        Path p2 = Paths.get("/home", "luiz/IdeaProjects/Testes", "arquivo.txt");
        Path p3 = Paths.get("/home", "luiz", "IdeaProjects", "Testes", "arquivo.txt");
        System.out.println(p1.toAbsolutePath());
        System.out.println(p2.toAbsolutePath());
        System.out.println(p3.toAbsolutePath());

        Path paths = Paths.get("pasta");
        Path paths2 = Paths.get("pasta/subpasta/sub");
        Path arquivo = Paths.get("pasta/subpasta/arquivo.txt");
        if (Files.notExists(paths)) {
            Files.createDirectory(paths);
        }
        if (Files.notExists(paths2)) {
            Files.createDirectories(paths2);
        }
        if (Files.notExists(arquivo)) {
            Files.createFile(arquivo);
        }
        Path source = Paths.get(arquivo.toString());
        Path target = Paths.get(paths2.toString(), "arquivo_copiado.txt");
        // StandardCopyOption.REPLACE_EXISTING : substitui caso exista
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        Files.deleteIfExists(target);
    }
}
