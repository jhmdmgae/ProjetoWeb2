package br.com.condominio.controller.logica.condominio;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.entidades.Condominio;
import br.com.condominio.jdbc.dao.CondominioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class FormAlterarCondominio implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        CondominioDAO condominioDAO = new CondominioDAO();

        String id = request.getParameter("id");
        Condominio condominio = condominioDAO.buscar(Integer.parseInt(id));

        if (condominio != null) {
            request.setAttribute("condominioAlterar", condominio);
            return "alterar_condominio.jsp";
        }

        return "listar_condominios.jsp";
    }

}
