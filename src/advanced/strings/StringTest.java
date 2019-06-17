package advanced.strings;

public class StringTest {
    public static void main(String[] args) {
        // Strings são imutáveis
        String nome = "Luiz";
        nome = nome.concat(" Fernando");
        System.out.println(nome);

        long iTime = System.currentTimeMillis();
        concatString(1000);
        long fTime = System.currentTimeMillis();
        System.out.println("String Normal: "+(fTime - iTime)+" ms");

        System.out.println("###############");

        iTime = System.currentTimeMillis();
        concatStringBuilder(10000);
        fTime = System.currentTimeMillis();
        System.out.println("String Builder: "+(fTime - iTime)+" ms");

        System.out.println("###############");

        iTime = System.currentTimeMillis();
        concatStringBuilder(10000);
        fTime = System.currentTimeMillis();
        System.out.println("String Buffer: "+(fTime - iTime)+" ms");

    }

    private static void concatString(int tam){
        String value = "";
        for(int i=0; i<tam; i++){
            value += i;
        }
    }

    private static void concatStringBuilder(int tam){
        StringBuilder sb = new StringBuilder(tam);
        for(int i=0; i<tam; i++){
            sb.append(i);
        }
    }

    private static void concatStringBuffer(int tam){
        // Ambientes Multi-Thread
        StringBuffer sb = new StringBuffer(tam);
        for(int i=0; i<tam; i++){
            sb.append(i);
        }
    }
}

