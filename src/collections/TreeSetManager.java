package collections;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class CelularComparator implements Comparator<Celular>{

    @Override
    public int compare(Celular celular, Celular t1) {
        return celular.getName().compareTo(t1.getName());
    }
}

public class TreeSetManager {
    public static void main(String[] args) {
        // No treeset os elementos são ordenados automaticamente
        //Para adicionar no treeset, a classe precisa implementar o Comparable
        // ou adicionar uma classe Comparator
        Produto prod1 = new Produto("123","Teclado",120d,2);
        Produto prod2 = new Produto("321","Bateria",145.20,5);
        Produto prod3 = new Produto("012","Baixo",150.99,3);
        Produto prod4 = new Produto("425","Microfone",100d,6);
        Produto prod5 = new Produto("012","Baixo",150.99,3);
        NavigableSet<Produto> produtoNavigableSet = new TreeSet<>();
        produtoNavigableSet.add(prod1);
        produtoNavigableSet.add(prod2);
        produtoNavigableSet.add(prod3);
        produtoNavigableSet.add(prod4);
        produtoNavigableSet.add(prod5);
        for(Produto p: produtoNavigableSet){
            System.out.println(p);
        }
        System.out.println("###################");
        Celular c1 = new Celular("Iphone X","123245");
        Celular c2 = new Celular("Moto G","9854725");
        NavigableSet<Celular> celularNavigableSet = new TreeSet<>(new CelularComparator());
        celularNavigableSet.add(c1);
        celularNavigableSet.add(c2);
        for (Celular celular: celularNavigableSet){
            System.out.println(celular);
        }
        System.out.println("#####################");
        // Metodos do navigableSet
        // lower <
        // floor <=
        // higher >
        // ceiling <=
        System.out.println(produtoNavigableSet.lower(prod4));
        System.out.println(produtoNavigableSet.floor(prod4));
        System.out.println(produtoNavigableSet.higher(prod5));
        System.out.println(produtoNavigableSet.ceiling(prod5));
        System.out.println("######################");
        //Ordem decrescente
        for(Produto p: produtoNavigableSet.descendingSet()){
            System.out.println(p);
        }
        System.out.println("###################");
        // Retorna e removo primeiro e ultimos elementos
        System.out.println(produtoNavigableSet.size());
        System.out.println(produtoNavigableSet.pollFirst());
        System.out.println(produtoNavigableSet.size());
        System.out.println(produtoNavigableSet.pollLast());
        System.out.println(produtoNavigableSet.size());
    }
}
