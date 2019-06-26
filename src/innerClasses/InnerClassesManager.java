package innerClasses;

public class InnerClassesManager {
    private String nome = "Luiz Nunes";

    class Interna{
        public void verClasseExterna(){
            System.out.println(nome);
            // Aqui o this se refere ao objeto da classe interna
            System.out.println(this);
            // Aqui não
            System.out.println(InnerClassesManager.this);
        }
    }

    public static void main(String[] args) {
        InnerClassesManager externa = new InnerClassesManager();
        InnerClassesManager.Interna interna = externa.new Interna();
        // Ou forma alternativa
        InnerClassesManager.Interna interna2 = new InnerClassesManager().new Interna();
        interna.verClasseExterna();
        interna2.verClasseExterna();
    }
}
