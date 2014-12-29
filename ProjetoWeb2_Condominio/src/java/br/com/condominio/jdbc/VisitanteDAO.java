package br.com.condominio.jdbc;

import br.com.condominio.entidades.Visitante;
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
        String sql = "INSERT INTO `visitante`(`id_visitante`, `nome`, `tipo_visita`, `apartamento`, `motivo_visita`, `data_hora`, `observacao`) VALUES (NULL, '?', '?', '?', '?', '?', '?')";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, visitante.getNome());
            ps.setString(1, visitante.getTipo_visita());
            ps.setInt(1, visitante.getApartamento());
            ps.setString(1, visitante.getMotivo_visita());
            ps.setDate(1, (Date) visitante.getData_hora());
            ps.setString(1, visitante.getObservacao());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VisitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Visitante visitante) {
        String sql = "UPDATE `visitante` SET `nome`=?,`tipo_visita`=?,`apartamento`=?,`motivo_visita`=?,`data_hora`=?,`observacao`=? WHERE `visitante`.`id_visitante` = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, visitante.getNome());
            ps.setString(1, visitante.getTipo_visita());
            ps.setInt(1, visitante.getApartamento());
            ps.setString(1, visitante.getMotivo_visita());
            ps.setDate(1, (Date) visitante.getData_hora());
            ps.setString(1, visitante.getObservacao());

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
                visitante.setTipo_visita(resultSet.getString("tipo_visita"));
                visitante.setApartamento(resultSet.getInt("apartamento"));
                visitante.setMotivo_visita(resultSet.getString("motivo_visita"));
                visitante.setData_hora(resultSet.getDate("data_hora"));
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
        String sql = "SELECT * FROM web2_condominio.visitante WHERE id=?";
        Visitante visitante = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVisitante);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                visitante = new Visitante();

                visitante.setId(resultSet.getInt("id_visitante"));
                visitante.setNome(resultSet.getString("nome"));
                visitante.setTipo_visita(resultSet.getString("tipo_visita"));
                visitante.setApartamento(resultSet.getInt("apartamento"));
                visitante.setMotivo_visita(resultSet.getString("motivo_visita"));
                visitante.setData_hora(resultSet.getDate("data_hora"));
                visitante.setObservacao(resultSet.getString("observacao"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VisitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visitante;
    }

    public void salvar(Visitante visitante) {
        if (visitante.getId() != 0) {
            alterar(visitante);
        } else {
            cadastrar(visitante);
        }
    }

}
