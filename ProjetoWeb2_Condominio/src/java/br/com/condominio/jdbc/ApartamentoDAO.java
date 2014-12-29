package br.com.condominio.jdbc;

import br.com.condominio.entidades.Apartamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Henrique 2
 */
public class ApartamentoDAO {
 
    private Connection con = Conexao.getConnection();

    public void cadastrar(Apartamento apartamento) {
        String sql = "INSERT INTO `web2_condominio`.`apartamento` (`numero`, `bloco`, `proprietario`, `locatario`) VALUES ( ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, apartamento.getNumero());
            ps.setInt(2, apartamento.getBloco());
            ps.setString(3, apartamento.getProprietario());
            ps.setString(4, apartamento.getLocatario());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ApartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Apartamento apartamento) {
        String sql = "UPDATE `web2_condominio`.`apartamento` SET `numero` = '?', `bloco` = '?', `proprietario` = '?', `locatario` = '?' WHERE `apartamento`.`idapartamento` = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, apartamento.getNumero());
            ps.setInt(2, apartamento.getBloco());
            ps.setString(3, apartamento.getProprietario());
            ps.setString(4, apartamento.getLocatario());
            ps.setInt(5, apartamento.getId());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ApartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(Apartamento apartamento) {
        String sql = "DELETE FROM web2_condominio.apartamento WHERE idapartamento = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, apartamento.getId());
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ApartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Apartamento> buscarTodos() {
        String sql = "SELECT * FROM web2_condominio.apartamento";

        List<Apartamento> apartamentos = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            apartamentos = new ArrayList();

            while (resultSet.next()) {
                Apartamento apartamento = new Apartamento();

                apartamento.setId(resultSet.getInt("idapartamento"));
                apartamento.setNumero(resultSet.getInt("numero"));
                apartamento.setBloco(resultSet.getInt("bloco"));
                apartamento.setProprietario(resultSet.getString("proprietario"));
                apartamento.setLocatario(resultSet.getString("locatario"));
                
                apartamentos.add(apartamento);
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ApartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apartamentos;
    }

    public Apartamento buscar(Integer idApartamento) {
        String sql = "SELECT * FROM web2_condominio.apartamento WHERE idapartamento=?";
        Apartamento apartamento = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idApartamento);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                apartamento = new Apartamento();

                apartamento.setId(resultSet.getInt("idapartamento"));
                apartamento.setNumero(resultSet.getInt("numero"));
                apartamento.setBloco(resultSet.getInt("bloco"));
                apartamento.setProprietario(resultSet.getString("proprietario"));
                apartamento.setLocatario(resultSet.getString("locatario"));
                
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ApartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apartamento;
    }

    public void salvar(Apartamento apartamento) {
        if (apartamento.getId() != 0) {
            alterar(apartamento);
        } else {
            cadastrar(apartamento);
        }
    }
    
    public static void main(String[] args) {
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();

        Apartamento apartamento = new Apartamento();
        apartamento.setNumero(123);
        apartamento.setBloco(123);
        apartamento.setProprietario("123");
        apartamento.setLocatario("123");

        apartamentoDAO.cadastrar(apartamento);
    }
    
}
