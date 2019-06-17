package advanced.dates;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateLocaleManager {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Locale locItaly = new Locale("it","IT");
        Locale locUsa = new Locale("en","US");
        DateFormat dfIt = DateFormat.getDateInstance(DateFormat.FULL,locItaly);
        DateFormat dfEn = DateFormat.getDateInstance(DateFormat.FULL,locUsa);
        c.set(2015,Calendar.DECEMBER,23);
        System.out.println(dfIt.format(c.getTime()));
        System.out.println(dfEn.format(c.getTime()));

        System.out.println(locItaly.getDisplayCountry());
        System.out.println(locUsa.getDisplayCountry());

        System.out.println(locItaly.getDisplayLanguage(locUsa));
        System.out.println(locUsa.getDisplayLanguage(locItaly));
    }
}
