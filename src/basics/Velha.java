package basics;

public class Velha {
    public static void main(String[] args) {
        String[][][] tabuleiro = new String[3][3][3];
        for(int i = 0; i < tabuleiro.length; i++){
            for(int j = 0; j < tabuleiro[i].length; j++){
                for(int k = 0; k < tabuleiro[i][j].length; k++){
                    tabuleiro[i][j][k] = "-";
                }
            }
        }

        for(int i = 0; i < tabuleiro.length; i++){
            for(int j = 0; j < tabuleiro[i].length; j++){
                System.out.println("");
                for(int k = 0; k < tabuleiro[i][j].length; k++){
                    System.out.print(tabuleiro[i][j][k]);
                }
            }
        }
    }
}