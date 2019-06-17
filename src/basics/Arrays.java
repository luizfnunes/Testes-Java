package basics;

public class Arrays {
    public static void main(String[] args) {
        int[] idades = new int[3];
        idades[0] = 6;
        idades[1] = 9;
        idades[2] = 12;
        for(int aux : idades){
            System.out.println(aux);
        }
    }
}
