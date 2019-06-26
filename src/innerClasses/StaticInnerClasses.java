package innerClasses;

class Externa{
    public String nome="Luiz";
    static class Interna{
        public void imprime(){
            System.out.println("Olá");
        }
    }
}
public class StaticInnerClasses {
    public static void main(String[] args) {
        Externa.Interna interna = new Externa.Interna();
        interna.imprime();

        Interna2 interna2 = new Interna2();
        interna2.imprime();
    }

    static class Interna2{
        public void imprime(){
            System.out.println("Olá");
        }
    }
}
