package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Funcionario;
import br.com.condominio.jdbc.dao.FuncionarioDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Testado
 *
 * @author João Henrique 2
 */
public class TestFuncionarioDAO {

    private static void cadastrar() {
        Funcionario funcionario = new Funcionario();

        funcionario.setMatricula("3");
        funcionario.setNome("3");
        funcionario.setTelResidencial("4");
        funcionario.setTelCelular("1");
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

        String data = "08/01/1995";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
        try {
            funcionario.setDataContratacao(new java.sql.Date(format.parse(data).getTime()));//problema conversão de datas
        } catch (ParseException ex) {
        }

//        funcionario.setData_contratacao(11/11/2011);
        funcionario.setCargo("1");
        funcionario.setTipoContrato("1");
        funcionario.setTurno("1");
        funcionario.setFoto("1");
        funcionario.setObservacao("1");

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.cadastrar(funcionario);
    }

    private static void alterar() {
        Funcionario funcionario = new Funcionario();

        funcionario.setMatricula("4");
        funcionario.setNome("1");
        funcionario.setTelResidencial("1");
        funcionario.setTelCelular("1");
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
        funcionario.setDataContratacao(new java.sql.Date(today.getTime()));//problema conversão de datas

//        funcionario.setData_contratacao(11/11/2011);
        funcionario.setCargo("1");
        funcionario.setTipoContrato("1");
        funcionario.setTurno("1");
        funcionario.setFoto("1");
        funcionario.setObservacao("1");

        funcionario.setId(3);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.alterar(funcionario);
    }

    private static void excluir() {
        Funcionario funcionario = new Funcionario();

        funcionario.setId(3);

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
    
    private static void buscarTipoContrato() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List<String> TipoContrato = funcionarioDAO.buscarTipoContrato();

        for (String tipo : TipoContrato) {
            System.out.println(tipo);
        }
    }

    public static void main(String[] args) {

        cadastrar();
//        alterar();
//        buscarTodos();
//        buscar(3);
//        excluir();
//        buscarTurno(1);
//        buscarTipoContrato();

    }

}
