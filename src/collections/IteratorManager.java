package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorManager {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Produto prod1 = new Produto("12345","Teclado", 150.40,10);
        Produto prod2 = new Produto("65498","Piano", 2500.70,2);
        Produto prod3 = new Produto("12478","Escaleta", 20.8,0);
        Produto prod4 = new Produto("32658","Bumbo", 12.00,0);
        produtos.add(prod1);
        produtos.add(prod2);
        produtos.add(prod3);
        produtos.add(prod4);
        System.out.println(produtos.size());
        // Para remover
        Iterator<Produto> iteratorProd = produtos.iterator();
        while(iteratorProd.hasNext()){
            Produto prod = iteratorProd.next();
            if(prod.getQuantidade() == 0){
                iteratorProd.remove();
            }
        }
        System.out.println(produtos.size());
    }
}
