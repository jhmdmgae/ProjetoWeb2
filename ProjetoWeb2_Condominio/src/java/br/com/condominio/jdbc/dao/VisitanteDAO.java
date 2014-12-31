package br.com.condominio.jdbc.dao;

import br.com.condominio.entidades.Visitante;
import br.com.condominio.jdbc.Conexao;
import java.sql.Connection;
import java.sql.Date;
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
public class VisitanteDAO {

    private Connection con = Conexao.getConnection();

    public void cadastrar(Visitante visitante) {
        String sql = "INSERT INTO visitante(nome, tipo_visita, apartamento, motivo_visita, data_hora, observacao) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, visitante.getNome());
            ps.setInt(2, visitante.getTipoVisita());
            ps.setInt(3, visitante.getApartamento());
            ps.setString(4, visitante.getMotivoVisita());
            ps.setDate(5, (Date) visitante.getDataHora());
            ps.setString(6, visitante.getObservacao());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VisitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Visitante visitante) {
        String sql = "UPDATE visitante SET nome=?,tipo_visita=?,apartamento=?,motivo_visita=?,data_hora=?,observacao=? WHERE visitante.id_visitante = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, visitante.getNome());
            ps.setInt(2, visitante.getTipoVisita());
            ps.setInt(3, visitante.getApartamento());
            ps.setString(4, visitante.getMotivoVisita());
            ps.setDate(5, (Date) visitante.getDataHora());
            ps.setString(6, visitante.getObservacao());
            
            ps.setInt(7, visitante.getId());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VisitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(Visitante visitante) {
        String sql = "DELETE FROM web2_condominio.visitante WHERE id_visitante = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, visitante.getId());
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VisitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Visitante> buscarTodos() {
        String sql = "SELECT * FROM web2_condominio.visitante";

        List<Visitante> visitantes = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            visitantes = new ArrayList();

            while (resultSet.next()) {
                Visitante visitante = new Visitante();

                visitante.setId(resultSet.getInt("id_visitante"));
                visitante.setNome(resultSet.getString("nome"));
                visitante.setTipoVisita(resultSet.getInt("tipo_visita"));
                visitante.setApartamento(resultSet.getInt("apartamento"));
                visitante.setMotivoVisita(resultSet.getString("motivo_visita"));
                visitante.setDataHora(resultSet.getDate("data_hora"));
                visitante.setObservacao(resultSet.getString("observacao"));

                visitantes.add(visitante);
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VisitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visitantes;
    }

    public Visitante buscar(Integer idVisitante) {
        String sql = "SELECT * FROM web2_condominio.visitante WHERE id_visitante=?";
        Visitante visitante = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVisitante);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                visitante = new Visitante();

                visitante.setId(resultSet.getInt("id_visitante"));
                visitante.setNome(resultSet.getString("nome"));
                visitante.setTipoVisita(resultSet.getInt("tipo_visita"));
                visitante.setApartamento(resultSet.getInt("apartamento"));
                visitante.setMotivoVisita(resultSet.getString("motivo_visita"));
                visitante.setDataHora(resultSet.getDate("data_hora"));
                visitante.setObservacao(resultSet.getString("observacao"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VisitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visitante;
    }
    
    public List<String> buscarTipoVisita() {

        String sql = "SELECT id_tipo_visita FROM web2_condominio.tipo_visita";

        List<String> tipos = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
//          
            ResultSet resultSet = ps.executeQuery();

            tipos = new ArrayList();

            while (resultSet.next()) {

                tipos.add(resultSet.getString("id_tipo_visita"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipos;
    }
    
    public List<String> buscarApartamento() {

        String sql = "SELECT idapartamento FROM web2_condominio.apartamento";

        List<String> apts = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
//          
            ResultSet resultSet = ps.executeQuery();

            apts = new ArrayList();

            while (resultSet.next()) {

                apts.add(resultSet.getString("idapartamento"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apts;
    }
    
    public String buscarTipoVisita(int chave) {
        
        String sql = "SELECT tipo FROM web2_condominio.tipo_visita WHERE id_tipo_visita=?";
        
        String tipo = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, chave);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                
                tipo = resultSet.getString("tipo"); 

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipo;
    }
    
    public String buscarApartamento(int chave) {
        
        String sql = "SELECT numero FROM web2_condominio.apartamento WHERE idapartamento=?";
        
        String apt = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, chave);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                
                apt = resultSet.getString("numero"); 

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apt;
    }

    public void salvar(Visitante visitante) {
        if (visitante.getId() != 0) {
            alterar(visitante);
        } else {
            cadastrar(visitante);
        }
    }

}
