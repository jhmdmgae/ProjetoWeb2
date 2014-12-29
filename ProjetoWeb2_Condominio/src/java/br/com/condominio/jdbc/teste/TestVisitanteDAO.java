package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Visitante;
import br.com.condominio.jdbc.VisitanteDAO;
import java.util.List;

/**
 *
 * @author João Henrique 2
 */
public class TestVisitanteDAO {
    
    private static void cadastrar() {
        Visitante visitante = new Visitante();

        visitante.setNumero(3);
        visitante.setBloco(3);
        visitante.setProprietario("3");
        visitante.setLocatario("3");

        VisitanteDAO visitanteDAO = new VisitanteDAO();
        visitanteDAO.cadastrar(visitante);
    }

    private static void alterar() {
        Visitante visitante = new Visitante();

        visitante.setNumero(4);
        visitante.setBloco(4);
        visitante.setProprietario("4");
        visitante.setLocatario("4");

        visitante.setId(5);

        VisitanteDAO visitanteDAO = new VisitanteDAO();
        visitanteDAO.alterar(visitante);
    }

    private static void excluir() {
        Visitante visitante = new Visitante();

        visitante.setId(5);

        VisitanteDAO visitanteDAO = new VisitanteDAO();
        visitanteDAO.excluir(visitante);
    }

    private static void buscarTodos() {
        VisitanteDAO visitanteDAO = new VisitanteDAO();
        List<Visitante> buscarTodos = visitanteDAO.buscarTodos();

        for (Visitante visitante : buscarTodos) {
            System.out.println(visitante.getId());
        }
    }

    private static void buscar(int id) {
        VisitanteDAO visitanteDAO = new VisitanteDAO();
        Visitante visitante = visitanteDAO.buscar(id);

        if (visitante != null) {
            System.out.println("Achado " + visitante.getNumero());
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
