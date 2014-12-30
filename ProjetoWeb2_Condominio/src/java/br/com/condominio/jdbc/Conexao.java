package br.com.condominio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lourivaldo
 */
public class Conexao {

    public static Connection getConnection() {
//        String url = "jdbc:mysql://25.138.13.112:3306/web2_condominio";
//        String url = "jdbc:mysql://localhost:3306/web2_condominio";
//        String url = "jdbc:mysql://192.168.200.102:3306/web2_condominio";
        String url = "jdbc:mysql://192.168.0.49:3306/web2_condominio";
        String username = "root";
//        String password = "ljfcv08011994";
        String password = "Cq3nep%";
        Connection connection = null;

        try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }

        try {
            System.out.println("Connecting database...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        }
//        finally {
//            System.out.println("Closing the connection.");
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ignore) {
//                }
//            }
//        }

        return connection;
    }
}
