package advanced.dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatManager {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        String maskSimple = "dd/MM/YYYY";
        String maskCompost = "'Alegrete,' dd 'de' MMMM 'de' YYYY";
        SimpleDateFormat sdf = new SimpleDateFormat(maskSimple);
        SimpleDateFormat sdfCompost = new SimpleDateFormat(maskCompost);
        System.out.println(sdf.format(c.getTime()));
        System.out.println(sdfCompost.format(c.getTime()));
    }
}
