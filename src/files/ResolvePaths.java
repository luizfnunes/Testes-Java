package files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvePaths {
    public static void main(String[] args) {
        Path absoluto = Paths.get("/home/luiz");
        Path relativo = Paths.get("documentos");
        Path arquivo = Paths.get("arquivo.txt");
        System.out.println(absoluto.resolve(relativo));
        System.out.println(relativo.resolve(absoluto));
        System.out.println(absoluto.resolve(arquivo));
        System.out.println(relativo.resolve(arquivo));
        System.out.println(arquivo.resolve(absoluto));
        System.out.println(arquivo.resolve(relativo));
    }
}
