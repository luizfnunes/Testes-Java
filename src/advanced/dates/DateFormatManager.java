package advanced.dates;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatManager {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        DateFormat[] dfs = new DateFormat[6];
        dfs[0] = DateFormat.getInstance();
        dfs[1] = DateFormat.getDateInstance();
        dfs[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        dfs[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dfs[4] = DateFormat.getDateInstance(DateFormat.LONG);
        dfs[5] = DateFormat.getDateInstance(DateFormat.FULL);
        for (DateFormat df: dfs) {
            System.out.println(df.format(c.getTime()));
        }
    }
}
