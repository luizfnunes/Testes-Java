package innerClasses;

public class LocalInnerClassManager {
    private String nome = "Luiz";

    public void fazAlgumaCoisa(){
        //Classes internas não podem utilizar atributos de metodos
        // a não ser que seja finais. até o java 7
        // A partir do java 8, se não fizer alterações na variavel ela é
        // considerada final por padrão
        String sobrenome = "Nunes";
        class Interna{
            public void imprimeClasseExterna(){
                System.out.println(nome);
                System.out.println(sobrenome);
            }
        }
        // Para chama-la é necessário instanciala dentro do metodo
        Interna in = new Interna();
        in.imprimeClasseExterna();
    }

    public static void main(String[] args) {
        LocalInnerClassManager local = new LocalInnerClassManager();
        local.fazAlgumaCoisa();
    }
}
