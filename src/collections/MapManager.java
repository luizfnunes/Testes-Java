package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapManager {
    public static void main(String[] args) {
        // Map possui chave e valor
        // Hashmap não garante ordem
        // Keys não se repetem (set)
        Map<String, String> map = new HashMap<>();
        map.put("tevlado","teclado");
        map.put("mause","mouse");
        map.put("vc","você");
        // chaves repetidas tem seu valor sobrescrito
        map.put("vc","voce");
        for(String key: map.keySet()){
            System.out.println(key);
        }
        System.out.println("#################");
        for(String value: map.values()){
            System.out.println(value);
        }
        System.out.println("##################");
        // Para pegar chave e valor
        for(Map.Entry<String, String> entry: map.entrySet()){
            System.out.println("Chave: "+entry.getKey()+" - Valor: "+entry.getValue());
        }
        System.out.println("##################");
        //Para manter a ordem de inserção: LinkedHashMap
        Map<String,String> jogo = new LinkedHashMap<>();
        jogo.put("goleiro","Ghroe");
        jogo.put("zagueiro","Kanneman");
        jogo.put("atacante","cebolinha");
        for(Map.Entry<String,String> pos: jogo.entrySet()){
            System.out.println(pos.getKey()+":"+pos.getValue());
        }

    }
}
