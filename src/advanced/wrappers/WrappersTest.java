package advanced.wrappers;

public class WrappersTest {
    public static void main(String[] args) {
        // Primitivos normais
        byte nByte = 1;
        short nShort = 1;
        long nLong = 1L;
        int nInt = 1;
        float nFloat = 1F;
        double nDouble = 1D;
        char nChar = 'a';
        boolean nBool = true;

        // Classes Wrappers
        //Autobox
        Byte wByte = 1;
        Short wShort = 1;
        Integer wInt = new Integer("10");
        Character wChar = 'A';
        Boolean wBool = false;
        // Filhos da Classe Number
        Long wLong = 10L;
        Float wFloat = 10F;
        Double wDouble = 10D;

        //Unbox
        int i = wInt;

        //Conversão (Parse)
        String valor = "10";
        Float f = Float.parseFloat(valor);

        //Value Of
        Long vLong = Long.valueOf("10");
        System.out.println(vLong);
    }
}
