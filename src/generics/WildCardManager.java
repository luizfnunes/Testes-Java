package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Animal{
    abstract void consultar();
}

class Dog extends Animal{

    @Override
    void consultar() {
        System.out.println("Consultando Dog");
    }
}

class Cat extends Animal{

    @Override
    void consultar() {
        System.out.println("Consultando Cat");
    }
}
public class WildCardManager {
    public static void main(String[] args) {

        Dog[] dogs = {new Dog(), new Dog()};
        Cat[] cats = {new Cat(), new Cat()};
        consultar(dogs);
        consultar(cats);
        // Com lists
        // Lista de Cachorros
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        catList.add(new Cat());
        // Se tentar vai dar erro de compilação
        //consultarList(dogList);
        //consultarList(catList);
        List<Animal> animalList = new ArrayList<>();
        consultarList(animalList);
        System.out.println("##################");
        consultarListGeneric(dogList);
        consultarListGeneric(catList);

    }
    public static void consultar(Animal[] animals){
        for(Animal animal: animals){
            animal.consultar();
        }
        // Com array, isso vai dar erro em tempo de execução
        // animals[1] = new Cat();
    }
    public static void consultarList(List<Animal> animals){
        for(Animal animal: animals){
            animal.consultar();
        }
        animals.add(new Dog());
        animals.add(new Cat());
    }

    // ? qualquer classe que extenda Animals
    public static void consultarListGeneric(List<? extends Animal> animals){
        for(Animal animal: animals){
            animal.consultar();
        }
        //animals.add(new Animal());
    }

    // ? é da classe cachorro ou de alguma superclasse de Cachorro
    public static void consultarSuperDog(List<? super Dog> dogList){
        Dog dog1 = new Dog();
        Animal animal1 = new Dog();
        Object obj1 = new Dog();
        dogList.add(new Dog());
    }

    // ? é um comparable
    public static void ordenar(List<? extends Comparable> list){
        Collections.sort(list);
    }
}
