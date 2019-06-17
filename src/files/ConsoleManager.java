package files;

import java.io.Console;

// Não funciona no Intellij

public class ConsoleManager {
    public static void main(String[] args) {
        Console c = System.console();
        char[] pw = c.readPassword("%s","pw: ");
        for(char pass: pw){
            c.format("%c ", pass);
        }
        c.format("\n");
        String s = c.readLine("%s", "Digite um texto: ");
        c.format("%s \n",s);
    }
}
