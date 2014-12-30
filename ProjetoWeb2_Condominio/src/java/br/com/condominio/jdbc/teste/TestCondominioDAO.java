package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Condominio;
import br.com.condominio.jdbc.CondominioDAO;
import java.util.List;

/**  Testado
 *
 * @author João Henrique 2
 */
public class TestCondominioDAO {

    private static void cadastrar() {
        Condominio condominio = new Condominio();

        condominio.setCnpj("1");
        condominio.setNome("1");
        condominio.setCep("1");
        condominio.setEndereco("1");
        condominio.setNumero("1");
        condominio.setComplemento("1");
        condominio.setBairro("1");
        condominio.setUf("1");
        condominio.setCidade("1");
        condominio.setQuantBlocos(1);
        condominio.setQuantApt(1);
        condominio.setFoto("1");
        condominio.setTelefone("1");
        condominio.setEmail("1");

        CondominioDAO condominioDAO = new CondominioDAO();
        condominioDAO.cadastrar(condominio);
    }

    private static void alterar() {
        Condominio condominio = new Condominio();

        condominio.setCnpj("3");
        condominio.setNome("2");
        condominio.setCep("2");
        condominio.setEndereco("2");
        condominio.setNumero("2");
        condominio.setComplemento("2");
        condominio.setBairro("2");
        condominio.setUf("2");
        condominio.setCidade("2");
        condominio.setQuantBlocos(2);
        condominio.setQuantApt(2);
        condominio.setFoto("2");
        condominio.setTelefone("2");
        condominio.setEmail("2");

        condominio.setId(3);

        CondominioDAO condominioDAO = new CondominioDAO();
        condominioDAO.alterar(condominio);
    }

    private static void excluir() {
        Condominio condominio = new Condominio();

        condominio.setId(2);

        CondominioDAO condominioDAO = new CondominioDAO();
        condominioDAO.excluir(condominio);
    }

    private static void buscarTodos() {
        CondominioDAO condominioDAO = new CondominioDAO();
        List<Condominio> buscarTodos = condominioDAO.buscarTodos();

        for (Condominio condominio : buscarTodos) {
            System.out.println(condominio.getId());
        }
    }

    private static void buscar(int id) {
        CondominioDAO condominioDAO = new CondominioDAO();
        Condominio condominio = condominioDAO.buscar(id);

        if (condominio != null) {
            System.out.println("Achado " + condominio.getNumero());
        }
    }

    public static void main(String[] args) {

//        cadastrar();
//        alterar();
        buscarTodos();
//        buscar(1);
//        excluir();

    }

}
