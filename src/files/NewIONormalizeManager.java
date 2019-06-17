package files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NewIONormalizeManager {
    public static void main(String[] args) {
        Path diretorio = Paths.get("/home/luiz/IdeaProjects/Testes/pasta/subpasta/sub");
        Path arquivo = Paths.get("../arquivo.txt");
        Path p1 = Paths.get(diretorio.toString(), arquivo.toString());
        System.out.println(p1);
        System.out.println(p1.normalize());

        Path p2 = Paths.get("a/./b/./c/../");
        System.out.println(p2);
        System.out.println(p2.normalize());
    }
}
