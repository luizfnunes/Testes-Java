package innerClasses;

import generics.Carro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Animal{
    public void andar(){
        System.out.println("Andando!");
    }
}
public class AnonymousClasses {
    public static void main(String[] args) {
        Animal animal = new Animal(){
            public void andar(){
                System.out.println("Andando anonimamente!");
            }
        };
        animal.andar();

        // Criar classe anonima para interface comparator
        List<Carro> carroList = new ArrayList<>();
        carroList.add(new Carro("Ferrarri"));
        carroList.add(new Carro("BMW"));
        Collections.sort(carroList, new Comparator<Carro>() {
            @Override
            public int compare(Carro carro, Carro t1) {
                return carro.getNome().compareTo(t1.getNome());
            }
        });
        System.out.println(carroList);
    }
}
