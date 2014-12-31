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
public class AlterarCondominio implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CondominioDAO condominioDAO = new CondominioDAO();

        String id = request.getParameter("id");
        
        
        
        
        Condominio condominio = new Condominio();
        
        condominio.setId(Integer.parseInt(id));
        
        
        
        
        condominioDAO.alterar(condominio);

        return "listar_condominios.jsp";
    }

}
