package advanced.regex;

import java.util.Scanner;

public class ScannerManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("1 true 12 oi");
        //scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
        System.out.println("#######################");
        Scanner scanner2 = new Scanner("1 true 12 oi");
        while(scanner2.hasNext()){
            if(scanner2.hasNextInt()){
                System.out.println("Int: "+scanner2.nextInt());
            }else if(scanner2.hasNextBoolean()){
                System.out.println("Bool: "+scanner2.nextBoolean());
            }else{
                System.out.println("Str: "+scanner2.next());
            }
        }
    }
}
