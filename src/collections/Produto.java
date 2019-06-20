package collections;

import java.util.Objects;

public class Produto implements Comparable<Produto>{
    private String serialNumber;
    private String Nome;
    private Double preco;
    private int quantidade;

    public Produto(String serialNumber, String nome, Double preco) {
        this.serialNumber = serialNumber;
        Nome = nome;
        this.preco = preco;
    }


    public Produto(String serialNumber, String nome, Double preco, int quantidade) {
        this.serialNumber = serialNumber;
        Nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "serialNumber='" + serialNumber + '\'' +
                ", Nome='" + Nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(serialNumber, produto.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Produto produto) {
        // negativo se thisObject < produto
        // zero se thisObject == produto
        // positivo se this.object > produto
        return this.serialNumber.compareTo(produto.getSerialNumber());
    }
}
