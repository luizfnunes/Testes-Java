package advanced.regex;

public class TokenManager {
    public static void main(String[] args) {
        simples();
    }
    public static void simples(){
        String nomes = "João, Paulo, Pedro, Maria, Joana, Paula";
        String[] arr = nomes.split(",");
        for(String aux: arr){
            System.out.println(aux.trim());
        }
    }
}
