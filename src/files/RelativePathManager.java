package files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativePathManager {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/luiz");
        Path classe = Paths.get("/home/luiz/Documentos/Jogo.java");
        System.out.println(dir.relativize(classe));

        Path absoluto1 = Paths.get("/home/luiz/");
        Path absoluto2 = Paths.get("/usr/local");
        Path absoluto3 = Paths.get("/home/luiz/Documentos/Pessoa.class");

        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/Funcionarios.java");

        System.out.println(absoluto1.relativize(absoluto3));
        System.out.println(absoluto3.relativize(absoluto1));
        System.out.println(absoluto1.relativize(absoluto2));

        System.out.println(relativo1.relativize(relativo2));
        System.out.println(relativo2.relativize(relativo1));
    }
}
