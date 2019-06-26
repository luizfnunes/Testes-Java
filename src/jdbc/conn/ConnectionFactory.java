package jdbc.conn;

import java.sql.*;

public class ConnectionFactory {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection conn, Statement stmt) {
        close(conn);
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        close(conn,stmt);
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    java.sql = Connection, Statment, ResultSet
//    public Connection getConnection(){
//        String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false";
//        String user = "root";
//        String password = "12345";
//        try {
//            // A partir do jdbc4 a linha abaixo não é necessaria
//            // Class.forName("con.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(url,user,password);
//            System.out.println(connection);
//            return connection;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
