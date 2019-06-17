package collections;

import java.util.ArrayList;
import java.util.List;

public class ListManager {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Luiz");
        nomes.add("Fernando");
        nomes.add("Maria");
        nomes.add("Joana");
        nomes.add("Felicia");
        for(String nome: nomes){
            System.out.println(nome);
        }
        System.out.println("Size: "+nomes.size());
        System.out.println("#############");
        nomes.remove("Luiz");
        for(int i = 0; i < nomes.size(); i++){
            System.out.println(nomes.get(i));
        }
        System.out.println("Size: "+nomes.size());
        System.out.println("#############");
        // Add from other collection
        List<String> nomes2 = new ArrayList<>();
        nomes2.add("Goku");
        nomes2.add("Trunks");
        nomes2.add("Vegeta");
        nomes.addAll(nomes2);
        for(String nome : nomes){
            System.out.println(nome);
        }
        System.out.println("Size: "+nomes.size());
        // limpar a lista
        nomes2.clear();
        for(String nome : nomes2){
            System.out.println(nome);
        }
        System.out.println("######!!!!#######");
        // List com objects
        Celular cel1 = new Celular("Iphone X","12345");
        Celular cel2 = new Celular("Sansung Galaxy","98765");
        Celular cel3 = new Celular("Moto G","12345");
        List<Celular> celularList = new ArrayList<>();
        celularList.add(cel1);
        celularList.add(cel2);
        celularList.add(cel3);
        for(Celular cel: celularList){
            System.out.println(cel);
        }
        System.out.println(celularList.get(0).equals(cel1));
        System.out.println(celularList.contains(cel2));
    }
}
