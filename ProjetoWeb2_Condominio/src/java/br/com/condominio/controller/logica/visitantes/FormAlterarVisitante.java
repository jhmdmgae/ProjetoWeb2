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
public class FormAlterarVisitante implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        VisitanteDAO visitanteDAO = new VisitanteDAO();

        String id = request.getParameter("id");
        Visitante visitante = visitanteDAO.buscar(Integer.parseInt(id));

        if (visitante != null) {
            request.setAttribute("visitanteAlterar", visitante);
            return "alterar_visitante.jsp";
        }

        return "listar_visitantes.jsp";
    }

}
