package br.com.condominio.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lourivaldo
 */
public class ConnectionTest {

    public static void main(String[] args) {
        Connection connection = ConnectionMySql.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID,USUARIO,SENHA FROM USUARIOS");
            
            while (rs.next()) {
                System.out.println(rs.getInt("id")+"\n"+rs.getString("usuario")+"\n"+rs.getString("senha"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
