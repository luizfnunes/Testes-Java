package files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RemoveChars {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("texto.txt");
        List<String> linhasArquivo = Files.readAllLines(file);
        File newFile = new File("output.txt");
        FileWriter fr = new FileWriter(newFile);
        String newLine = "";
        for (String line : linhasArquivo) {
            newLine += line.replace("\n"," ");
        }
        fr.write(newLine);
        fr.close();
    }
}
