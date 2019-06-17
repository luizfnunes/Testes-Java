package basics;

public class StringsPerform {
    public static void main(String[] args) {
        long prInicio = System.currentTimeMillis();
        stringConcat(100);
        long prFim = System.currentTimeMillis();
        System.out.println("Tempo gasto "+(prFim - prInicio)+" ms");

        prInicio = System.currentTimeMillis();
        stringConcatBuilder(1000000);
        prFim = System.currentTimeMillis();
        System.out.println("Tempo gasto(Builder) "+(prFim - prInicio)+" ms");

        prInicio = System.currentTimeMillis();
        stringConcatBuffer(1000000);
        prFim = System.currentTimeMillis();
        System.out.println("Tempo gasto(Buffer) "+(prFim - prInicio)+" ms");
    }

    private static void stringConcat(int tam){
        String str = "";
        for(int i = 0; i < tam; i++){
            str += i;
        }
    }

    private static void stringConcatBuilder(int tam){
        StringBuilder str = new StringBuilder("");
        for(int i = 0; i < tam; i++){
            str.append(i);
        }
    }

    private static void stringConcatBuffer(int tam){
        StringBuffer str = new StringBuffer("");
        for(int i = 0; i < tam; i++){
            str.append(i);
        }
    }
}
