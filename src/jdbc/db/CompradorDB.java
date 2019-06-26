package jdbc.db;

import jdbc.classes.Comprador;
import jdbc.conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompradorDB {
    public static void save(Comprador comprador){
        String sql="INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('"+comprador.getCpf()+"', '"+comprador.getNome()+"');";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn,stmt);
            System.out.println("Registro excluido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete(Comprador comprador){
        if(comprador == null || comprador.getId() == null){
            System.out.println("Não foi possível excluir o registro");
            return;
        }
        String sql="DELETE FROM `agencia`.`comprador` WHERE (`id` = '"+comprador.getId()+"');";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn,stmt);
            System.out.println("Registro excluido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Comprador comprador){
        if(comprador == null || comprador.getId() == null){
            System.out.println("Não foi possível atualizar o registro");
            return;
        }
        String sql="UPDATE `agencia`.`comprador` SET `cpf` = '"+comprador.getCpf()+"', `nome` = '"+comprador.getNome()+"' WHERE (`id` = '"+comprador.getId()+"');";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn,stmt);
            System.out.println("Registro atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> selectAll(){
        String sql="SELECT `id`, `nome`, `cpf` from `agencia`.`comprador`;";
        Connection conn = ConnectionFactory.getConnection();
        List<Comprador> listaComprador = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                listaComprador.add(new Comprador(resultSet.getInt("id"),resultSet.getString("cpf"),resultSet.getString("nome")));
            }
            ConnectionFactory.close(conn,stmt, resultSet);
            return listaComprador;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByName(String name){
        String sql="SELECT `id`, `nome`, `cpf` from `agencia`.`comprador` WHERE `nome` LIKE '%"+name+"%';";
        Connection conn = ConnectionFactory.getConnection();
        List<Comprador> listaComprador = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                listaComprador.add(new Comprador(resultSet.getInt("id"),resultSet.getString("cpf"),resultSet.getString("nome")));
            }
            ConnectionFactory.close(conn,stmt, resultSet);
            return listaComprador;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
