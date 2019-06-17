package files;

import java.io.*;

public class StreamManager {
    public static void main(String[] args) {
        gravadorTunado();
        leitorTunado();
    }

    private static void gravador(){
        byte[] dados = {65,66,67,68,69,70};
        try(FileOutputStream gravador = new FileOutputStream("pasta/stream.txt")){
            gravador.write(dados);
            System.out.println("Dados gravados!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void gravadorTunado(){
        byte[] dados = {65,66,67,68,69,70,71,72};
        try(BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream("pasta/stream.txt"),4098)){
            buffer.write(dados);
            buffer.flush();
            System.out.println("Dados gravados!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitor(){
        try(FileInputStream leitor = new FileInputStream("pasta/stream.txt")){
            // Vai retornar -1 no final do arquivo
            int leitura;
            while((leitura = leitor.read()) != -1){
                byte b = (byte) leitura;
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitorTunado(){
        try(BufferedInputStream buffer = new BufferedInputStream(new FileInputStream("pasta/stream.txt"),4098)){
            // Vai retornar -1 no final do arquivo
            int leitura;
            while((leitura = buffer.read()) != -1){
                byte b = (byte) leitura;
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
