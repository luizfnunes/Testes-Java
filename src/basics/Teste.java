package basics;

public class Teste {
    public static void main(String[] args) {
        Classes classeUm = new Classes();
        Classes classeDois = new Classes("Luiz",31);
        System.out.println("##################");
        System.out.println(classeUm.getName());
        System.out.println(classeUm.getAge());
        System.out.println("##################");
        System.out.println(classeDois.getName());
        System.out.println(classeDois.getAge());

    }
}
