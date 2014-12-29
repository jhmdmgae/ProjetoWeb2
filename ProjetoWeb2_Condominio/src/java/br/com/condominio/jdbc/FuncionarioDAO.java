package br.com.condominio.jdbc;

import br.com.condominio.entidades.Funcionario;
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
public class FuncionarioDAO {

    private Connection con = Conexao.getConnection();

    public void cadastrar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (id_funcionario, matricula, nome, telefone_residencial, telefone_comercial, cep, endereco, numero, complemento, bairro, cidade, uf, rg, cpf, sexo, data_contratacao, cargo, tipo_contrato, turno, foto, observacao) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, funcionario.getMatricula());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getTelResidencial());
            ps.setString(4, funcionario.getTelCelular());
            ps.setString(5, funcionario.getCep());
            ps.setString(6, funcionario.getEndereco());
            ps.setInt(7, funcionario.getNumero());
            ps.setString(8, funcionario.getComplemento());
            ps.setString(9, funcionario.getBairro());
            ps.setString(10, funcionario.getCidade());
            ps.setString(11, funcionario.getUf());
            ps.setString(12, funcionario.getRg());
            ps.setString(13, funcionario.getCpf());
            ps.setString(14, funcionario.getSexo());
            ps.setDate(15, new java.sql.Date(funcionario.getDataContratacao().getTime()));
            ps.setString(16, funcionario.getCargo());
            ps.setString(17, funcionario.getTipoContrato());
            ps.setString(18, funcionario.getTurno());
            ps.setString(19, funcionario.getFoto());
            ps.setString(20, funcionario.getObservacao());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET matricula=?,nome=?,telefone_residencial=?,telefone_comercial=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,uf=?,rg=?,cpf=?,sexo=?,data_contratacao=?,cargo=?,tipo_contrato=?,turno=?,foto=?,observacao=? WHERE funcionario.id_funcionario = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, funcionario.getMatricula());
            ps.setString(1, funcionario.getNome());
            ps.setString(1, funcionario.getTelResidencial());
            ps.setString(1, funcionario.getTelCelular());
            ps.setString(1, funcionario.getCep());
            ps.setString(1, funcionario.getEndereco());
            ps.setInt(1, funcionario.getNumero());
            ps.setString(1, funcionario.getComplemento());
            ps.setString(1, funcionario.getBairro());
            ps.setString(1, funcionario.getCidade());
            ps.setString(1, funcionario.getUf());
            ps.setString(1, funcionario.getRg());
            ps.setString(1, funcionario.getCpf());
            ps.setString(1, funcionario.getSexo());
            ps.setDate(1, (Date) funcionario.getDataContratacao());
            ps.setString(1, funcionario.getCargo());
            ps.setString(1, funcionario.getTipoContrato());
            ps.setString(1, funcionario.getTurno());
            ps.setString(1, funcionario.getFoto());
            ps.setString(1, funcionario.getObservacao());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(Funcionario funcionario) {
        String sql = "DELETE FROM web2_condominio.funcionario WHERE id_funcionario = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, funcionario.getId());
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Funcionario> buscarTodos() {
        String sql = "SELECT * FROM web2_condominio.funcionario";

        List<Funcionario> funcionarios = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            funcionarios = new ArrayList();

            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId(resultSet.getInt("id_funcionario"));
                funcionario.setMatricula(resultSet.getString("matricula"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setTelResidencial(resultSet.getString("telefone_residencial"));
                funcionario.setTelCelular(resultSet.getString("telefone_comercial"));
                funcionario.setCep(resultSet.getString("cep"));
                funcionario.setEndereco(resultSet.getString("endereco"));
                funcionario.setNumero(resultSet.getInt("numero"));
                funcionario.setComplemento(resultSet.getString("complemento"));
                funcionario.setBairro(resultSet.getString("bairro"));
                funcionario.setCidade(resultSet.getString("cidade"));
                funcionario.setUf(resultSet.getString("uf"));
                funcionario.setRg(resultSet.getString("rg"));
                funcionario.setCpf(resultSet.getString("cpf"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDataContratacao(resultSet.getDate("data_contratacao"));
                funcionario.setCargo(resultSet.getString("cargo"));
                funcionario.setTipoContrato(resultSet.getString("tipo_contrato"));
                funcionario.setTurno(resultSet.getString("turno"));
                funcionario.setFoto(resultSet.getString("foto"));
                funcionario.setObservacao(resultSet.getString("observacao"));

                funcionarios.add(funcionario);
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    public Funcionario buscar(Integer idFuncionario) {
        String sql = "SELECT * FROM web2_condominio.funcionario WHERE id=?";
        Funcionario funcionario = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idFuncionario);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionario();

                funcionario.setId(resultSet.getInt("id_funcionario"));
                funcionario.setMatricula(resultSet.getString("matricula"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setTelResidencial(resultSet.getString("telefone_residencial"));
                funcionario.setTelCelular(resultSet.getString("telefone_comercial"));
                funcionario.setCep(resultSet.getString("cep"));
                funcionario.setEndereco(resultSet.getString("endereco"));
                funcionario.setNumero(resultSet.getInt("numero"));
                funcionario.setComplemento(resultSet.getString("complemento"));
                funcionario.setBairro(resultSet.getString("bairro"));
                funcionario.setCidade(resultSet.getString("cidade"));
                funcionario.setUf(resultSet.getString("uf"));
                funcionario.setRg(resultSet.getString("rg"));
                funcionario.setCpf(resultSet.getString("cpf"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDataContratacao(resultSet.getDate("data_contratacao"));
                funcionario.setCargo(resultSet.getString("cargo"));
                funcionario.setTipoContrato(resultSet.getString("tipo_contrato"));
                funcionario.setTurno(resultSet.getString("turno"));
                funcionario.setFoto(resultSet.getString("foto"));
                funcionario.setObservacao(resultSet.getString("observacao"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    public void salvar(Funcionario funcionario) {
        if (funcionario.getId() != 0) {
            alterar(funcionario);
        } else {
            cadastrar(funcionario);
        }
    }

}
