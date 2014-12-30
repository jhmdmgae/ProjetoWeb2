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
        String sql = "INSERT INTO veiculo(veiculo_apartamento, tipo_veiculo, modelo, marca, cor, placa) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, veiculo.getApartamento());
            ps.setInt(2, veiculo.getTipoVeiculo());
            ps.setString(3, veiculo.getModelo());
            ps.setString(4, veiculo.getMarca());
            ps.setInt(5, veiculo.getCor());
            ps.setString(6, veiculo.getPlaca());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Veiculo veiculo) {
        String sql = "UPDATE veiculo SET veiculo_apartamento=?,tipo_veiculo=?,modelo=?,marca=?,cor=?,placa=? WHERE veiculo.id_veiculo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, veiculo.getApartamento());
            ps.setInt(2, veiculo.getTipoVeiculo());
            ps.setString(3, veiculo.getModelo());
            ps.setString(4, veiculo.getMarca());
            ps.setInt(5, veiculo.getCor());
            ps.setString(6, veiculo.getPlaca());
            
            ps.setInt(7, veiculo.getId());

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
                veiculo.setApartamento(resultSet.getInt("veiculo_apartamento"));
                veiculo.setTipoVeiculo(resultSet.getInt("tipo_veiculo"));
                veiculo.setModelo(resultSet.getString("modelo"));
                veiculo.setMarca(resultSet.getString("marca"));
                veiculo.setCor(resultSet.getInt("cor"));
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
        String sql = "SELECT * FROM web2_condominio.veiculo WHERE id_veiculo=?";
        Veiculo veiculo = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVeiculo);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                veiculo = new Veiculo();

                veiculo.setId(resultSet.getInt("id_veiculo"));
                veiculo.setApartamento(resultSet.getInt("veiculo_apartamento"));
                veiculo.setTipoVeiculo(resultSet.getInt("tipo_veiculo"));
                veiculo.setModelo(resultSet.getString("modelo"));
                veiculo.setMarca(resultSet.getString("marca"));
                veiculo.setCor(resultSet.getInt("cor"));
                veiculo.setPlaca(resultSet.getString("placa"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculo;
    }
    
    public List<String> buscarCor() {

        String sql = "SELECT nome FROM web2_condominio.cor";

        List<String> cores = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
//          
            ResultSet resultSet = ps.executeQuery();

            cores = new ArrayList();

            while (resultSet.next()) {

                cores.add(resultSet.getString("nome"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cores;
    }
    
    public List<String> buscarTipoVeiculo() {

        String sql = "SELECT tipo FROM web2_condominio.tipo_veiculo";

        List<String> tipos = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
//          
            ResultSet resultSet = ps.executeQuery();

            tipos = new ArrayList();

            while (resultSet.next()) {

                tipos.add(resultSet.getString("tipo"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipos;
    }
    
    public String buscarCor(int chave) {
        
        String sql = "SELECT nome FROM web2_condominio.cor WHERE id_cor=?";
        
        String cor = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, chave);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                
                cor = resultSet.getString("nome"); 

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cor;
    }
    
    public String buscarTipoVeiculo(int chave) {
        
        String sql = "SELECT tipo FROM web2_condominio.tipo_veiculo WHERE id_tipo_veiculo=?";
        
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

    public void salvar(Veiculo veiculo) {
        if (veiculo.getId() != 0) {
            alterar(veiculo);
        } else {
            cadastrar(veiculo);
        }
    }

}
