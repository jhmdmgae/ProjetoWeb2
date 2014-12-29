package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Funcionario;
import br.com.condominio.jdbc.FuncionarioDAO;
import java.util.List;

/**
 *
 * @author João Henrique 2
 */
public class TestFuncionarioDAO {
    
    private static void cadastrar() {
        Funcionario funcionario = new Funcionario();

        funcionario.setNumero(3);
        funcionario.setBloco(3);
        funcionario.setProprietario("3");
        funcionario.setLocatario("3");

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.cadastrar(funcionario);
    }

    private static void alterar() {
        Funcionario funcionario = new Funcionario();

        funcionario.setNumero(4);
        funcionario.setBloco(4);
        funcionario.setProprietario("4");
        funcionario.setLocatario("4");

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

//        cadastrar();
//        alterar();
//        buscarTodos();
        buscar(3);
//        excluir();

    }
    
}
