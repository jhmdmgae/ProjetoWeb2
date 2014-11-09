package br.com.condominio.jdbc.teste;

import br.com.condominio.jdbc.Conexao;
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
        Connection connection = Conexao.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_usuario,login,senha FROM usuario");
            
            while (rs.next()) {
                System.out.println(rs.getInt("id_usuario")+"\n"+rs.getString("login")+"\n"+rs.getString("senha"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
