package collections;

import java.util.*;


class ProdutoNomeComparator implements Comparator<Produto>{

    @Override
    public int compare(Produto produto, Produto t1) {
        return produto.getNome().compareTo(t1.getNome());
    }
}

public class ListProdutoManager {
    public static void main(String[] args) {
        List<Produto> produtoList = new ArrayList<>();
        Produto prod1 = new Produto("123","Monitor Generico",1000.0);
        Produto prod2 = new Produto("453","Teclado Astha",120.99);
        Produto prod3 = new Produto("987","Mouse Multilaser",89.90);
        Produto prod4 = new Produto("741","Impressora HP",5000.0);
        produtoList.add(prod1);
        produtoList.add(prod2);
        produtoList.add(prod3);
        produtoList.add(prod4);
        // para ordenar, a classe deve implementar a interface:
        // Comparable
        Collections.sort(produtoList);

        // Ou ordena com a interface comparator
        Collections.sort(produtoList, new ProdutoNomeComparator());
        for(Produto produto: produtoList){
            System.out.println(produto);
        }
        System.out.println("##############");
        // Ordenação de Arrays
        Produto[] prodArray = new Produto[4];
        prodArray[0] = prod1;
        prodArray[1] = prod2;
        prodArray[2] = prod3;
        prodArray[3] = prod4;
        //Arrays.sort(prodArray);
        Arrays.sort(prodArray, new ProdutoNomeComparator());
        for(Produto produto: prodArray){
            System.out.println(produto);
        }
    }
}
