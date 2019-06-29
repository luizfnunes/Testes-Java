package jdbc.db;

import jdbc.classes.Comprador;
import jdbc.conn.ConnectionFactory;

import java.sql.*;
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

    public static void selectMetaData(){
        String sql = "SELECT * from `agencia`.`comprador`";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            resultSet.next();
            int qtdColumn = metaData.getColumnCount();
            for(int i = 1; i <= qtdColumn;i++){
                System.out.println(metaData.getTableName(i));
                System.out.println(metaData.getColumnName(i));
                System.out.println(metaData.getColumnDisplaySize(i));
            }
            ConnectionFactory.close(conn,stmt,resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkDriverStatus(){
        Connection conn = ConnectionFactory.getConnection();
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            //Move o cursor apenas para a frente
            if(dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
                System.out.println("Driver suporta TYPE_FORWARD_ONLY");
                // Atualizar campo enquanto é percorrido
                if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println("e tambem suporta CONCUR_UPDATABLE");
                }
            }

            //Move o cursor para frente e para traz, mas não altera as mudanças enquanto ele estiver aberto
            if(dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){
                System.out.println("Driver suporta TYPE_SCROLL_INSENSITIVE");
                // Atualizar campo enquanto é percorrido
                if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println("e tambem suporta CONCUR_UPDATABLE");
                }
            }

            //Move o cursor para frente e para tras e registra as mudanças quando esta aberto
            if(dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){
                System.out.println("Driver suporta TYPE_SCROLL_SENSITIVE");
                // Atualizar campo enquanto é percorrido
                if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println("e tambem suporta CONCUR_UPDATABLE");
                }
            }
            ConnectionFactory.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testTypeScroll(){
        String sql="SELECT `id`, `nome`, `cpf` from `agencia`.`comprador`;";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = stmt.executeQuery(sql);
            if(resultSet.last()){
                System.out.println("Ultima linha: "+new Comprador(resultSet.getInt("id"),resultSet.getString("cpf"),resultSet.getString("nome")));
                System.out.println("Nro Ultima Linha: "+resultSet.getRow());
            }
            System.out.println("Retornou para a primeira linha? "+resultSet.first());
            System.out.println("Nro Linha: "+resultSet.getRow());
            // Mover cursor linha 4
            resultSet.absolute(4);
            System.out.println("Linha 4: "+new Comprador(resultSet.getInt("id"),resultSet.getString("cpf"),resultSet.getString("nome")));
            // Move relativo a linha em que está
            resultSet.relative(-1);
            System.out.println("Linha 3: "+new Comprador(resultSet.getInt("id"),resultSet.getString("cpf"),resultSet.getString("nome")));

            System.out.println(resultSet.isFirst());
            System.out.println(resultSet.isLast());
            System.out.println("#################");

            //Ordem Inversa
            resultSet.afterLast();
            while(resultSet.previous()){
                System.out.println(new Comprador(resultSet.getInt("id"),resultSet.getString("cpf"),resultSet.getString("nome")));
            }

            ConnectionFactory.close(conn,stmt, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateNomesToLowerCase(){
        String sql="SELECT `id`, `nome`, `cpf` from `agencia`.`comprador`;";
        Connection conn = ConnectionFactory.getConnection();
        try {
            DatabaseMetaData dbmt = conn.getMetaData();
            System.out.println(dbmt.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println(dbmt.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println(dbmt.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                //Atualiza no resultset
                resultSet.updateString("nome", resultSet.getString("nome").toLowerCase());
                resultSet.updateRow();
            }
//            resultSet.beforeFirst();
//            while(resultSet.next()){
//                System.out.println(resultSet.getString("nome"));
//            }

//            resultSet.absolute(2);
//            String nome = resultSet.getString("nome");
//            resultSet.moveToInsertRow();
//            resultSet.updateString("nome",nome.toUpperCase());
//            resultSet.updateString("cpf","000.000.000-00");
//            resultSet.insertRow();
//            resultSet.moveToCurrentRow();
//            System.out.println(resultSet.getString("nome")+" : "+resultSet.getRow());

            resultSet.absolute(7);
            resultSet.deleteRow();

            ConnectionFactory.close(conn,stmt, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
