package advanced.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexManager {
    public static void main(String[] args) {
        //regexAdvanced();
        //buscaEmail();
        //buscaData();
        //buscaCep();
        buscaExt();
    }
    private static  void regexMedium(){
        // \d: todos os digitos (numeros)
        // \D: tudo que não for digito
        // \s: caracteres em branco \t \n \f \r
        // \S: tudo que não é espaço em branco
        // \w: caracteres de palavras: a-z,A-Z, digitos e _
        // \W: caracteres que não forem de palavras
        String regex = "\\W";
        String texto = " 02a25b\na0@1aq +7y\thah76 ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto:  "+texto);
        System.out.println("Indice: "+"0123456789");
        System.out.println("Expressão: "+matcher.pattern());
        System.out.println("Posições");
        while(matcher.find()){
            System.out.print(matcher.start()+" ");
        }
    }
    private static  void regexAdvanced(){
        // [] procura por digitos [abcABC] - intervalo [a-zA-Z]
        // Quantificadores
        // ? :zero ou uma
        // * :zero ou mais
        // + :um ou mais
        // {n,m} - de n até m ocorrencias
        // ( ) - agrupar
        // |   - ou
        // $  - fim de linha
        // . - coringa: pode ser substituido por qualquer coisa. ex: 1.3 : 123 113 1a3 1 3
        // ^ - Negação

        // Achar Hexadecimais
        //
        // Pegar 0 seguido de xouX, seguido de digitos ou letras de a até f
        // ou de A até F, com ocorrencia de uma ou mais vezes, seguido de
        // espaço em branco ou fim de linha.
        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
        String texto = "12 0x 0X 0xFFA 0x10g 0X1F3";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto:  "+texto);
        System.out.println("Indice: "+"0123456789");
        System.out.println("Expressão: "+matcher.pattern());
        System.out.println("Posições");
        while(matcher.find()){
            System.out.println(matcher.start()+" "+matcher.group());
        }
    }
    private static void regexSimples(){
        String regex = "aba";
        String texto = "abababa";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto:  "+texto);
        System.out.println("Indice: "+"0123456789");
        System.out.println("Expressão: "+matcher.pattern());
        System.out.println("Posições");
        while(matcher.find()){
            System.out.print(matcher.start()+" ");
        }
    }

    private static void buscaEmail(){
        String regex = "([a-zA-Z0-9_\\.])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String emails = "luiz@email.com, 12_luiz@gmail.com, _12@email, ma12_12.43@hotmail.com zildo@outlook.com.br";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emails);
        while(matcher.find()){
            System.out.println(matcher.start()+" "+matcher.group());
        }

        // Validar email
        System.out.println("Email Valido? "+"email_to@email".matches(regex));
    }

    public static void buscaData(){
        String regex = "\\d{2}/\\d{2}/(\\d{2}|\\d{4})(\\s|$)";
        String datas = "01/10/2008 01/05/96 08/04/1997 2/1/1000 02/08/148";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(datas);
        while(matcher.find()){
            System.out.println(matcher.start()+ " "+ matcher.group());
        }
    }

    public static void buscaCep(){
        String regex = "\\d{5}-\\d{3}(\\s|$)";
        String ceps = "87451-147 547841-741 125-412 963258741-741 14785-145 78532-85 14774-8 47851-701";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ceps);
        while(matcher.find()){
            System.out.println(matcher.start()+" "+matcher.group());
        }
    }

    public static void buscaExt(){
        String regex = "proj([^,])+";
        String texto = "proj1.txt proj2.java proj4.class file1.txt cons.java trt.txt";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        while(matcher.find()){
            System.out.println(matcher.start()+" "+matcher.group());
        }
    }
}

