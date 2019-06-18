package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class binarySearchManager {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(3);
        numeros.add(0);
        numeros.add(4);
        numeros.add(2);
        Collections.sort(numeros);
        for(int numero: numeros){
            System.out.println(numero);
        }
        System.out.println("#################");
        //Caso não encontre o indice retorna -((posição onde deveria ser colocado)-1)
        System.out.println(Collections.binarySearch(numeros,1));
        // Exemplo: retornou -2, porque deveria estar na posição 1:
        // -1-1 = -2
        System.out.println(Collections.binarySearch(numeros, 5));
        // se -p-1 = px então: -p = px + 1   -p = -5+1 troca sinais p=px-1
        int p = -(Collections.binarySearch(numeros, 1) + 1);
        System.out.println("Pos: "+p);
        System.out.println("##################");
        numeros.add(1,p);
        for(int numero: numeros){
            System.out.println(numero);
        }
    }
}
