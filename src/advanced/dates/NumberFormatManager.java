package advanced.dates;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatManager {
    public static void main(String[] args) {
        float valor = 12524.1245f;
        Locale locJP = new Locale("jp");
        Locale locFr = new Locale("fr");
        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getInstance(locFr);
        nfa[1] = NumberFormat.getInstance(locJP);
        nfa[2] = NumberFormat.getCurrencyInstance(locFr);
        nfa[3] = NumberFormat.getCurrencyInstance(locJP);
        for(NumberFormat nf: nfa){
            System.out.println(nf.format(valor));
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(valor));

        String newValor = "12458,254";
        try {
            System.out.println(nf.parse(newValor));
            nf.setParseIntegerOnly(true);
            System.out.println(nf.parse(newValor));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
