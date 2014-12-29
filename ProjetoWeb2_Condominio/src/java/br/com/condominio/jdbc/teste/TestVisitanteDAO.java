package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Visitante;
import br.com.condominio.jdbc.VisitanteDAO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/** Testado
 *
 * @author João Henrique 2
 */
public class TestVisitanteDAO {

    private static void cadastrar() {
        Visitante visitante = new Visitante();

        visitante.setNome("2");
        visitante.setTipo_visita(1);
        visitante.setApartamento(1);
        visitante.setMotivo_visita("2");
        
        java.util.Date today = new java.util.Date();
        visitante.setData_hora(new java.sql.Date(today.getTime()));//problema conversão de datas
        
        visitante.setObservacao("2");

        VisitanteDAO visitanteDAO = new VisitanteDAO();
        visitanteDAO.cadastrar(visitante);
    }

    private static void alterar() {
        Visitante visitante = new Visitante();

        visitante.setNome("3");
        visitante.setTipo_visita(1);
        visitante.setApartamento(1);
        visitante.setMotivo_visita("3");
        
        java.util.Date today = new java.util.Date();
        visitante.setData_hora(new java.sql.Date(today.getTime()));//problema conversão de datas
        
        visitante.setObservacao("3");

        visitante.setId(2);

        VisitanteDAO visitanteDAO = new VisitanteDAO();
        visitanteDAO.alterar(visitante);
    }

    private static void excluir() {
        Visitante visitante = new Visitante();

        visitante.setId(2);

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
    
    private static void buscarTipoVisita(int id) {
        VisitanteDAO visitanteDAO = new VisitanteDAO();
        String tipo = visitanteDAO.buscarTipoVisita(id);

        if (tipo != null) {
            System.out.println("Tipo de Visita: " + tipo);
        }
    }
    
    private static void buscarApt(int id) {
        VisitanteDAO visitanteDAO = new VisitanteDAO();
        String apt = visitanteDAO.buscarApartamento(id);

        if (apt != null) {
            System.out.println("Apartamento: " + apt);
        }
    }

    public static void main(String[] args) {

//        cadastrar();
//        alterar();
//        buscarTodos();
//        buscar(2);
//        excluir();
//        buscarApt(1);
        buscarTipoVisita(1);
        
    }

}
