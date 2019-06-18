package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertListToArray {
    public static void main(String[] args) {
        // Lista para Array

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        // Primeiro metodo: cria um objeto para receber
        Object[] objects = numeros.toArray();
        // Segundo metodo: informa um array já criado
        Integer[] numerosArray = new Integer[numeros.size()];
        numeros.toArray(numerosArray);
        System.out.println(numeros);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println("################");

        //Array para lista
        Integer[] numerosArray2 = new Integer[4];
        numerosArray2[0] = 10;
        numerosArray2[1] = 20;
        numerosArray2[2] = 30;
        numerosArray2[3] = 40;
        // O asList uni os dois arrays, o que fizer em um, fará no outro
        List<Integer> numeros2 = Arrays.asList(numerosArray2);
        // Trocando numero apenas em numeros2, troca do numerosArray2 tb
        numeros2.set(0,4);
        // Para nao haver problema, criamos uma outra lista que recebe o Array
        List<Integer> numeros3 = new ArrayList<>();
        numeros3.addAll(Arrays.asList(numerosArray2));
        numeros3.add(50);
        System.out.println(Arrays.toString(numerosArray2));
        System.out.println(numeros2);
        System.out.println(numeros3);
    }
}
