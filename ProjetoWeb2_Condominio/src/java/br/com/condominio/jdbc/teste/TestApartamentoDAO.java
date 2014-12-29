package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Apartamento;
import br.com.condominio.jdbc.ApartamentoDAO;
import java.util.List;

/**
 *
 * @author João Henrique 2
 */
public class TestApartamentoDAO {

    private static void cadastrar() {
        Apartamento apartamento = new Apartamento();

        apartamento.setNumero(3);
        apartamento.setBloco(3);
        apartamento.setProprietario("3");
        apartamento.setLocatario("3");

        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        apartamentoDAO.cadastrar(apartamento);
    }

    private static void alterar() {
        Apartamento apartamento = new Apartamento();

        apartamento.setNumero(4);
        apartamento.setBloco(4);
        apartamento.setProprietario("4");
        apartamento.setLocatario("4");

        apartamento.setId(5);

        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        apartamentoDAO.alterar(apartamento);
    }

    private static void excluir() {
        Apartamento apartamento = new Apartamento();

        apartamento.setId(5);

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

//        cadastrar();
//        alterar();
//        buscarTodos();
        buscar(3);
//        excluir();

    }

}
