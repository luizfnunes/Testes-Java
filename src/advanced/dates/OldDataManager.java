package advanced.dates;

import java.util.Date;

public class OldDataManager {
    public static void main(String[] args) {
        Date date = new Date(1_000_000_000_000L);
        System.out.println(date);
        Date atual = new Date();
        System.out.println(atual);
        System.out.println("Em ms: "+atual.getTime());
    }
}
