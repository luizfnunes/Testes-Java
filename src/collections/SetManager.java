package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetManager {
    public static void main(String[] args) {
        Produto prod1 = new Produto("123","Teclado",120d,2);
        Produto prod2 = new Produto("321","Bateria",145.20,5);
        Produto prod3 = new Produto("012","Baixo",150.99,3);
        Produto prod4 = new Produto("425","Microfone",100d,6);
        Produto prod5 = new Produto("012","Baixo",150.99,3);
        // Set não repete elementos e não ordena (não indexa)
        Set<Produto> produtoSet = new HashSet<>();
        produtoSet.add(prod1);
        produtoSet.add(prod2);
        produtoSet.add(prod3);
        produtoSet.add(prod4);
        produtoSet.add(prod5);
        for(Produto p : produtoSet){
            System.out.println(p);
        }
        System.out.println("#########################");
        // LinkedHashSet mantém a ordem de inserção dos elementos
        Set<Produto> prodSetLinked = new LinkedHashSet<>();
        prodSetLinked.add(prod5);
        prodSetLinked.add(prod4);
        prodSetLinked.add(prod3);
        prodSetLinked.add(prod2);
        prodSetLinked.add(prod1);
        for (Produto p: prodSetLinked){
            System.out.println(p);
        }
    }
}
