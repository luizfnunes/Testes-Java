package files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllManager extends SimpleFileVisitor<Path>{
    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/{Test*}.{java,class}");
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        if (matcher.matches(path)){
            System.out.println(path.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

public class PathMatcherManager {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("pasta/subpasta/arquivo.txt");
        Path path2 = Paths.get("arquivo.txt");
        Path path3 = Paths.get("luiz");
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        System.out.println(matcher.matches(path1));
        System.out.println(matcher.matches(path2));
        System.out.println("---------------------------------");
        // Dois ** considera qualquer coisa (incluindo diretório)
        matcher(path1,"glob:**.txt");
        matcher(path1,"glob:*.txt");
        matcher(path1,"glob:**/*.txt");
        matcher(path1,"glob:*");
        matcher(path1,"glob:**");
        System.out.println("---------------------------------");
        // Achar final com exatamente 3 caracteres ???
        matcher(path1,"glob:*.???");
        matcher(path1,"glob:**/*.???");
        matcher(path1,"glob:**.???");
        // Achar ou um ou outro
        matcher(path3,"glob:{luiz*,fernando*}");
        matcher(path3,"glob:{luiz,fernando}*");
        matcher(path3,"glob:{luiz,fernando}");
        Files.walkFileTree(Paths.get("./"),new FindAllManager());
    }

    private static void matcher(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob+" : "+matcher.matches(path));
    }
}
