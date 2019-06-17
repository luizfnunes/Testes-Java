package basics;

public class Classes {
    private String name;
    private int age;
    private String code;
    private static Double gravity;
    // Bloco de Inicialização Estatico
    static{
        System.out.println("Static Inicialization");
        gravity = 0.5;
    }
    // Bloco de Inicialização
    {
        System.out.println("Normal Inicialization");
        this.code = "01010101";
    }
    // Constructor
    public Classes(String name, int age){
        System.out.println("Constructor");
        this.name = name;
        this.age = age;
    }
    // Sobrecarga
    public Classes(){
        System.out.println("Constructor sem dados");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
