package advanced.dates;

import java.util.Calendar;
import java.util.Date;

public class CalendarManager {
    public static void main(String[] args) {
        // Classe calendar é abstrata, pega-se a instancia
        Calendar c = Calendar.getInstance();

        //c.setTime(new Date(1658521458522L));
        System.out.println(c.getTime());

        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        System.out.println("######################");
        System.out.println("Hora: "+c.get(Calendar.HOUR));
        // Add adiciona ao field
        c.add(Calendar.HOUR,1);
        System.out.println("Hora: "+c.get(Calendar.HOUR));
        // Roll adiciona sem incrementar ao proximo(dia, mes, ano)
        c.roll(Calendar.HOUR, 10);
        System.out.println("Hora: "+c.get(Calendar.HOUR));
        System.out.println(c.get(Calendar.YEAR));


    }
}
