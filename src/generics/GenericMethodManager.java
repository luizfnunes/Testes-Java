package generics;


import java.util.ArrayList;
import java.util.List;

public class GenericMethodManager {
    public static void main(String[] args) {
        criarArray(new Dog());
        List<Dog> listaDog = criarArrayList(new Dog());
        System.out.println(listaDog);
        criarArrayAnimal(new Cat());
    }

    public static <T> void criarArray(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
    }

    public static <T> List<T> criarArrayList(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        return lista;
    }

    public static <T extends Animal> void criarArrayAnimal(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
    }
}
