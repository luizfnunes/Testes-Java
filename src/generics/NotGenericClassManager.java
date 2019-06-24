package generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NotGenericClassManager {
    public static void main(String[] args) {
        CarroAlugavel carroAlugavel = new CarroAlugavel();
        Carro carroAlugado = carroAlugavel.getCarroDisponivel();
        System.out.println("Usando o carro!");
        carroAlugavel.devolverCarro(carroAlugado);
        System.out.println("####################");
        ComputadorAlugavel computadorAlugavel = new ComputadorAlugavel();
        Computador computadorAlugado = computadorAlugavel.getComputadorDisponivel();
        System.out.println("Usando o computador");
        computadorAlugavel.devolverComputador(computadorAlugado);
    }
}

class CarroAlugavel {
    private List<Carro> carrosDisponiveis = new ArrayList<>();
    {
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("Celta"));

    }
    // Alugar carro
    public Carro getCarroDisponivel(){
        Carro c = carrosDisponiveis.remove(0);
        System.out.println("Alugando carro: "+c);
        System.out.println("Disponíveis:"+carrosDisponiveis);
        return c;
    }
    // Devolver Carro
    public void devolverCarro(Carro c){
        System.out.println("Devolvendo carro: "+c);
        carrosDisponiveis.add(c);
        System.out.println("Disponíveis:"+carrosDisponiveis);
    }

}

class ComputadorAlugavel {
    private List<Computador> computadoresDisponiveis = new ArrayList<>();
    {
        computadoresDisponiveis.add(new Computador("Acer"));
        computadoresDisponiveis.add(new Computador("Intel"));

    }
    // Alugar carro
    public Computador getComputadorDisponivel(){
        Computador c = computadoresDisponiveis.remove(0);
        System.out.println("Alugando computador: "+c);
        System.out.println("Disponíveis:"+ computadoresDisponiveis);
        return c;
    }
    // Devolver Carro
    public void devolverComputador(Computador c){
        System.out.println("Devolvendo computador: "+c);
        computadoresDisponiveis.add(c);
        System.out.println("Disponíveis:"+ computadoresDisponiveis);
    }

}
