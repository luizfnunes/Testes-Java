package jdbc.test;

import jdbc.classes.Comprador;
import jdbc.conn.ConnectionFactory;
import jdbc.db.CompradorDB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TesteConexao {
    public static void main(String[] args) {
        //deletar();
        //atualizar();
        //System.out.println(selecionaTudo());
        //System.out.println(buscaPorNome("za"));
        //CompradorDB.selectMetaData();
        //CompradorDB.checkDriverStatus();
        //CompradorDB.testTypeScroll();
        CompradorDB.updateNomesToLowerCase();
    }


    public static void inserir(){
        Comprador comprador1 = new Comprador("123.456.789-10","Peter");
        CompradorDB.save(comprador1);
    }

    public static void deletar(){
        Comprador comprador1 = new Comprador();
        comprador1.setId(2);
        CompradorDB.delete(comprador1);
    }

    public static void atualizar(){
        Comprador comprador1 = new Comprador(1,"000.555.888-78","Izaldina");
        CompradorDB.update(comprador1);
    }

    public static List<Comprador> selecionaTudo(){
        return CompradorDB.selectAll();
    }

    public static List<Comprador> buscaPorNome(String nome){
        return CompradorDB.searchByName(nome);
    }


}
