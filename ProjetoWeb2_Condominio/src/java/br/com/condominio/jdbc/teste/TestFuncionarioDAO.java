package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Funcionario;
import br.com.condominio.jdbc.FuncionarioDAO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author João Henrique 2
 */
public class TestFuncionarioDAO {
    
    private static void cadastrar() {
        Funcionario funcionario = new Funcionario();

        funcionario.setMatricula("1");
        funcionario.setNome("1");
        funcionario.setTel_residencial("1");
        funcionario.setTel_celular("1");
        funcionario.setCep("1");
        funcionario.setEndereco("1");
        funcionario.setNumero(1);
        funcionario.setComplemento("1");
        funcionario.setBairro("1");
        funcionario.setCidade("1");
        funcionario.setUf("1");
        funcionario.setRg("1");
        funcionario.setCpf("1");
        funcionario.setSexo("1");
        
        java.util.Date today = new java.util.Date();
        funcionario.setData_contratacao(new java.sql.Date(today.getTime()));//problema conversão de datas
        
//        funcionario.setData_contratacao(11/11/2011);
        
        funcionario.setCargo("1");
        funcionario.setTipo_contrato("1");
        funcionario.setTurno("1");
        funcionario.setFoto("1");
        funcionario.setObservacao("1");

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.cadastrar(funcionario);
    }

    private static void alterar() {
        Funcionario funcionario = new Funcionario();

        funcionario.setMatricula("1");
        funcionario.setNome("1");
        funcionario.setTel_residencial("1");
        funcionario.setTel_celular("1");
        funcionario.setCep("1");
        funcionario.setEndereco("1");
        funcionario.setNumero(1);
        funcionario.setComplemento("1");
        funcionario.setBairro("1");
        funcionario.setCidade("1");
        funcionario.setUf("1");
        funcionario.setRg("1");
        funcionario.setCpf("1");
        funcionario.setSexo("1");
//        funcionario.setData_contratacao(11/11/2011);
        funcionario.setCargo("1");
        funcionario.setTipo_contrato("1");
        funcionario.setTurno("1");
        funcionario.setFoto("1");
        funcionario.setObservacao("1");

        funcionario.setId(5);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.alterar(funcionario);
    }

    private static void excluir() {
        Funcionario funcionario = new Funcionario();

        funcionario.setId(5);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.excluir(funcionario);
    }

    private static void buscarTodos() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> buscarTodos = funcionarioDAO.buscarTodos();

        for (Funcionario funcionario : buscarTodos) {
            System.out.println(funcionario.getId());
        }
    }

    private static void buscar(int id) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = funcionarioDAO.buscar(id);

        if (funcionario != null) {
            System.out.println("Achado " + funcionario.getNumero());
        }
    }

    public static void main(String[] args) {

        cadastrar();
//        alterar();
//        buscarTodos();
//        buscar(3);
//        excluir();

    }
    
}
