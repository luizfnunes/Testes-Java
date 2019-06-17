package advanced.strings;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nova String");
        // Dentro do SOUT é chamado sb.toString
        System.out.println(sb.length());
        System.out.println(sb);
        sb.append("Builder");
        System.out.println(sb.length());
        System.out.println(sb);
        sb.delete(0,3);
        System.out.println(sb);
        System.out.println(sb.reverse());
        System.out.println(sb.insert(0,"Mais caracteres"));
    }
}
