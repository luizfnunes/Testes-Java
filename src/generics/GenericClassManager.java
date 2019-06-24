package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericClassManager {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>();
        carrosDisponiveis.add(new Carro("BMW"));
        carrosDisponiveis.add(new Carro("Sedan"));
        ObjetosAlugaveis<Carro> objAlugado = new ObjetosAlugaveis<>(carrosDisponiveis);
        Carro carroAlugado = objAlugado.getObjetoDisponivel();
        System.out.println("Usando Carro");
        objAlugado.devolverObjeto(carroAlugado);
        System.out.println("#####################");

        List<Computador> computadoresDisponiveis = new ArrayList<>();
        computadoresDisponiveis.add(new Computador("Megaware"));
        computadoresDisponiveis.add(new Computador("Acer"));
        ObjetosAlugaveis<Computador> compAlugaveis = new ObjetosAlugaveis<>(computadoresDisponiveis);
        Computador computadorAlugado = compAlugaveis.getObjetoDisponivel();
        System.out.println("Usando Computador");
        compAlugaveis.devolverObjeto(computadorAlugado);
    }
}

// Em classes é T, em listas é E de elementos
class ObjetosAlugaveis<T> {
    private List<T> objetosDisponiveis;
    public ObjetosAlugaveis(List<T> objetosDisponiveis){
        this.objetosDisponiveis = objetosDisponiveis;
    }

    // Alugar carro
    public T getObjetoDisponivel(){
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando objeto: "+t);
        System.out.println("Disponíveis:"+ objetosDisponiveis);
        return t;
    }
    // Devolver Carro
    public void devolverObjeto(T t){
        System.out.println("Devolvendo objeto: "+t);
        objetosDisponiveis.add(t);
        System.out.println("Disponíveis:"+ objetosDisponiveis);
    }

}

class DoisAtributos<T,X>{
    T um;
    X dois;

    public DoisAtributos(T um, X dois) {
        this.um = um;
        this.dois = dois;
    }
}


