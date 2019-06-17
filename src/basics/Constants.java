package basics;

public enum Constants {
    APRAZO(1),AVISTA(2);
    private int tipo;

    Constants(int tipo){
        this.tipo = tipo;
    }

    public int getTipo(){
        return tipo;
    }
}
