package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumidorMapManager {
    public static void main(String[] args) {
        Consumidor consumidor = new Consumidor("Luiz","012");
        Consumidor consumidor2 = new Consumidor("Fernando","854");
        Produto prod1 = new Produto("123","Monitor Generico",1000.0);
        Produto prod2 = new Produto("453","Teclado Astha",120.99);
        Produto prod3 = new Produto("987","Mouse Multilaser",89.90);
        Produto prod4 = new Produto("741","Impressora HP",5000.0);
        Map<Consumidor,Produto> map = new HashMap<>();
        map.put(consumidor,prod2);
        map.put(consumidor2,prod4);
        for(Map.Entry<Consumidor,Produto> entry: map.entrySet()){
            System.out.println(entry.getKey().getNome()+" - "+entry.getValue().getNome());
        }
        System.out.println("######################");

        List<Produto> list1 = new ArrayList<>();
        list1.add(prod1);
        list1.add(prod4);
        List<Produto> list2 = new ArrayList<>();
        list2.add(prod2);
        list2.add(prod3);

        Map<Consumidor, List<Produto>> mapList1 = new HashMap<>();
        mapList1.put(consumidor,list1);
        mapList1.put(consumidor2,list2);
        System.out.println("");
        for(Map.Entry<Consumidor,List<Produto>> entry: mapList1.entrySet()){
            System.out.print(entry.getKey().getNome()+": ");
            for(Produto prod: entry.getValue()){
                System.out.print(prod.getNome()+", ");
            }
            System.out.println("");
        }

    }
}
