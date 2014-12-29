package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Visitante;
import br.com.condominio.jdbc.VisitanteDAO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author João Henrique 2
 */
public class TestVisitanteDAO {

    private static void cadastrar() {
        Visitante visitante = new Visitante();

        visitante.setNome("1");
        visitante.setTipo_visita(1);
        visitante.setApartamento(1);
        visitante.setMotivo_visita("1");
        
        java.util.Date today = new java.util.Date();
        visitante.setData_hora(new java.sql.Date(today.getTime()));//problema conversão de datas
        
        visitante.setObservacao("1");

        VisitanteDAO visitanteDAO = new VisitanteDAO();
        visitanteDAO.cadastrar(visitante);
    }

    private static void alterar() {
        Visitante visitante = new Visitante();

        visitante.setNome("1");
        visitante.setTipo_visita(1);
        visitante.setApartamento(1);
        visitante.setMotivo_visita("1");
        visitante.setData_hora(null);
        visitante.setObservacao("1");

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
            System.out.println("Achado " + visitante.getNome());
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
