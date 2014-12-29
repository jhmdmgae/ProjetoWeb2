package br.com.condominio.jdbc;

import br.com.condominio.entidades.Veiculo;
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
public class VeiculoDAO {

    private Connection con = Conexao.getConnection();

    public void cadastrar(Veiculo veiculo) {
        String sql = "INSERT INTO `veiculo`(`id_veiculo`, `veiculo_apartamento`, `tipo_veiculo`, `modelo`, `marca`, `cor`, `placa`) VALUES (NULL, '?', '?', '?', '?', '?', '?')";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, veiculo.getApartamento());
            ps.setString(1, veiculo.getTipo_veiculo());
            ps.setString(1, veiculo.getModelo());
            ps.setString(1, veiculo.getMarca());
            ps.setString(1, veiculo.getCor());
            ps.setString(1, veiculo.getPlaca());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Veiculo veiculo) {
        String sql = "UPDATE `veiculo` SET `veiculo_apartamento`=?,`tipo_veiculo`=?,`modelo`=?,`marca`=?,`cor`=?,`placa`=? WHERE `veiculo`.`id_veiculo` = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, veiculo.getApartamento());
            ps.setString(1, veiculo.getTipo_veiculo());
            ps.setString(1, veiculo.getModelo());
            ps.setString(1, veiculo.getMarca());
            ps.setString(1, veiculo.getCor());
            ps.setString(1, veiculo.getPlaca());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(Veiculo veiculo) {
        String sql = "DELETE FROM web2_condominio.veiculo WHERE id_veiculo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, veiculo.getId());
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Veiculo> buscarTodos() {
        String sql = "SELECT * FROM web2_condominio.veiculo";

        List<Veiculo> veiculos = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            veiculos = new ArrayList();

            while (resultSet.next()) {
                Veiculo veiculo = new Veiculo();

                veiculo.setId(resultSet.getInt("id_veiculo"));
                veiculo.setApartamento(resultSet.getString("veiculo_apartamento"));
                veiculo.setTipo_veiculo(resultSet.getString("tipo_veiculo"));
                veiculo.setModelo(resultSet.getString("modelo"));
                veiculo.setMarca(resultSet.getString("marca"));
                veiculo.setCor(resultSet.getString("cor"));
                veiculo.setPlaca(resultSet.getString("placa"));

                veiculos.add(veiculo);
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculos;
    }

    public Veiculo buscar(Integer idVeiculo) {
        String sql = "SELECT * FROM web2_condominio.veiculo WHERE id=?";
        Veiculo veiculo = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVeiculo);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                veiculo = new Veiculo();

                veiculo.setId(resultSet.getInt("id_veiculo"));
                veiculo.setApartamento(resultSet.getString("veiculo_apartamento"));
                veiculo.setTipo_veiculo(resultSet.getString("tipo_veiculo"));
                veiculo.setModelo(resultSet.getString("modelo"));
                veiculo.setMarca(resultSet.getString("marca"));
                veiculo.setCor(resultSet.getString("cor"));
                veiculo.setPlaca(resultSet.getString("placa"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculo;
    }

    public void salvar(Veiculo veiculo) {
        if (veiculo.getId() != 0) {
            alterar(veiculo);
        } else {
            cadastrar(veiculo);
        }
    }

}
