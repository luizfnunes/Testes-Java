package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListManager {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Fernando");
        nomes.add("Alfredo");
        nomes.add("Zulmira");
        nomes.add("Luiz");
        nomes.add("Claudia");
        for(String nome: nomes){
            System.out.println(nome);
        }
        System.out.println("##############");
        Collections.sort(nomes);
        for(String nome: nomes){
            System.out.println(nome);
        }
        System.out.println("##############");
        List<Double> numeros = new ArrayList<>();
        numeros.add(5.9);
        numeros.add(7.1);
        numeros.add(6.0);
        numeros.add(1.4);
        numeros.add(2.56);
        numeros.add(2.4);
        numeros.add(1d);
        numeros.add(0.3);
        for(Double numero: numeros){
            System.out.println(numero);
        }
        System.out.println("##############");
        Collections.sort(numeros);
        for(Double numero: numeros){
            System.out.println(numero);
        }
    }
}
