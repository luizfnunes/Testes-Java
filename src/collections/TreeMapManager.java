package collections;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapManager {
    // Apenas chaves que implementam a interface comparable
    public static void main(String[] args) {
        NavigableMap<String,String> map = new TreeMap<>();
        map.put("A","Letra A");
        map.put("C","Letra C");
        map.put("D","Letra D");
        map.put("B","Letra B");
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("#################");
        //Metodos
        // headMap: retorna map com tudo que for menor que a chave informada
        // true ou false, inclui a chave
        System.out.println(map.headMap("C"));
        System.out.println(map.headMap("C",true));
        // ordem inversa
        System.out.println(map.descendingMap());

    }
}
