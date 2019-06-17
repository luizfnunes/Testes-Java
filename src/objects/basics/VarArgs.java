package objects.basics;

public class VarArgs {

    public static void main(String[] args) {
        System.out.println(calculaVarArgs(1,2,3,4,5,1));
    }

    public static int calculaVarArgs(int... numbers){
        int soma = 0;
        for (int n: numbers) {
            soma += n;
        }
        return soma;
    }
}
