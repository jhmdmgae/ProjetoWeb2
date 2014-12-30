package br.com.condominio.controller.logica.visitantes;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.entidades.Visitante;
import br.com.condominio.jdbc.dao.VisitanteDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class ExcluirVisitante implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        VisitanteDAO visitanteDAO = new VisitanteDAO();

        String id = request.getParameter("id");
        Visitante visitante = visitanteDAO.buscar(Integer.parseInt(id));

        if (visitante != null) {
            visitanteDAO.excluir(visitante);
        }

        return "listar_visitantes.jsp";
    }

}
