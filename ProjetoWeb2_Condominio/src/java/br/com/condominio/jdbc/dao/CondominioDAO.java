package br.com.condominio.jdbc.dao;

import br.com.condominio.entidades.Condominio;
import br.com.condominio.jdbc.Conexao;
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
public class CondominioDAO {

    private Connection con = Conexao.getConnection();

    public void cadastrar(Condominio condominio) {
        String sql = "INSERT INTO condominio (cnpj, nome, cep, endereco, numero, complemetento, bairro, uf, cidade, quant_blocos, total_apartamentos, foto, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condominio.getCnpj());
            ps.setString(2, condominio.getNome());
            ps.setString(3, condominio.getCep());
            ps.setString(4, condominio.getEndereco());
            ps.setString(5, condominio.getNumero());
            ps.setString(6, condominio.getComplemento());
            ps.setString(7, condominio.getBairro());
            ps.setString(8, condominio.getUf());
            ps.setString(9, condominio.getCidade());
            ps.setInt(10, condominio.getQuantBlocos());
            ps.setInt(11, condominio.getQuantApt());//mudar no banco de dados para int
            ps.setString(12, condominio.getFoto());
            ps.setString(13, condominio.getTelefone());
            ps.setString(14, condominio.getEmail());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CondominioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Condominio condominio) {
        String sql = "UPDATE condominio SET cnpj=?,nome=?,cep=?,endereco=?,numero=?,complemetento=?,bairro=?,uf=?,cidade=?,quant_blocos=?,total_apartamentos=?,foto=?,telefone=?,email=? WHERE condominio.id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condominio.getCnpj());
            ps.setString(2, condominio.getNome());
            ps.setString(3, condominio.getCep());
            ps.setString(4, condominio.getEndereco());
            ps.setString(5, condominio.getNumero());
            ps.setString(6, condominio.getComplemento());
            ps.setString(7, condominio.getBairro());
            ps.setString(8, condominio.getUf());
            ps.setString(9, condominio.getCidade());
            ps.setInt(10, condominio.getQuantBlocos());
            ps.setInt(11, condominio.getQuantApt());
            ps.setString(12, condominio.getFoto());
            ps.setString(13, condominio.getTelefone());
            ps.setString(14, condominio.getEmail());
            
            ps.setInt(15, condominio.getId());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CondominioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(Condominio condominio) {
        String sql = "DELETE FROM web2_condominio.condominio WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, condominio.getId());
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CondominioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Condominio> buscarTodos() {
        String sql = "SELECT * FROM web2_condominio.condominio";

        List<Condominio> condominios = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            condominios = new ArrayList();

            while (resultSet.next()) {
                Condominio condominio = new Condominio();

                condominio.setId(resultSet.getInt("id"));
                condominio.setCnpj(resultSet.getString("cnpj"));
                condominio.setNome(resultSet.getString("nome"));
                condominio.setCep(resultSet.getString("cep"));
                condominio.setEndereco(resultSet.getString("endereco"));
                condominio.setNumero(resultSet.getString("numero"));
                condominio.setComplemento(resultSet.getString("complemetento"));
                condominio.setBairro(resultSet.getString("bairro"));
                condominio.setUf(resultSet.getString("uf"));
                condominio.setCidade(resultSet.getString("cidade"));
                condominio.setQuantBlocos(resultSet.getInt("quant_blocos"));
                condominio.setQuantApt(resultSet.getInt("total_apartamentos"));
                condominio.setFoto(resultSet.getString("foto"));
                condominio.setTelefone(resultSet.getString("telefone"));
                condominio.setEmail(resultSet.getString("email"));

                condominios.add(condominio);
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CondominioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return condominios;
    }

    public Condominio buscar(Integer idCondominio) {
        String sql = "SELECT * FROM web2_condominio.condominio WHERE id=?";
        Condominio condominio = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCondominio);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                condominio = new Condominio();

                condominio.setId(resultSet.getInt("id"));
                condominio.setCnpj(resultSet.getString("cnpj"));
                condominio.setNome(resultSet.getString("nome"));
                condominio.setCep(resultSet.getString("cep"));
                condominio.setEndereco(resultSet.getString("endereco"));
                condominio.setNumero(resultSet.getString("numero"));
                condominio.setComplemento(resultSet.getString("complemetento"));
                condominio.setBairro(resultSet.getString("bairro"));
                condominio.setUf(resultSet.getString("uf"));
                condominio.setCidade(resultSet.getString("cidade"));
                condominio.setQuantBlocos(resultSet.getInt("quant_blocos"));
                condominio.setQuantApt(resultSet.getInt("total_apartamentos"));
                condominio.setFoto(resultSet.getString("foto"));
                condominio.setTelefone(resultSet.getString("telefone"));
                condominio.setEmail(resultSet.getString("email"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CondominioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return condominio;
    }

    public void salvar(Condominio condominio) {
        if (condominio.getId() != 0) {
            alterar(condominio);
        } else {
            cadastrar(condominio);
        }
    }

}
