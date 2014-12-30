package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Apartamento;
import br.com.condominio.jdbc.dao.ApartamentoDAO;
import java.util.List;

/** Testado
 *
 * @author João Henrique 2
 */
public class TestApartamentoDAO {

    private static void cadastrar() {
        Apartamento apartamento = new Apartamento();

        apartamento.setNumero(4);
        apartamento.setBloco(4);
        apartamento.setProprietario("4");
        apartamento.setLocatario("4");

        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        apartamentoDAO.cadastrar(apartamento);
    }

    private static void alterar() {
        Apartamento apartamento = new Apartamento();

        apartamento.setNumero(5);
        apartamento.setBloco(5);
        apartamento.setProprietario("5");
        apartamento.setLocatario("5");

        apartamento.setId(6);

        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        apartamentoDAO.alterar(apartamento);
    }

    private static void excluir() {
        Apartamento apartamento = new Apartamento();

        apartamento.setId(6);

        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        apartamentoDAO.excluir(apartamento);
    }

    private static void buscarTodos() {
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        List<Apartamento> buscarTodos = apartamentoDAO.buscarTodos();

        for (Apartamento apartamento : buscarTodos) {
            System.out.println(apartamento.getId());
        }
    }

    private static void buscar(int id) {
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        Apartamento apartamento = apartamentoDAO.buscar(id);

        if (apartamento != null) {
            System.out.println("Achado " + apartamento.getNumero());
        }
    }

    public static void main(String[] args) {

        cadastrar();
//        alterar();
//        buscarTodos();
//        buscar(1);
//        excluir();

    }

}
