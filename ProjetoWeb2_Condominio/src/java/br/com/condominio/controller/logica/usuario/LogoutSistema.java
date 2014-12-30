package br.com.condominio.controller.logica.usuario;

import br.com.condominio.controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LOURIVALDO
 */
public class LogoutSistema implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);

        if (session == null) {
            return "not_logged.html";
        } else {
            session.invalidate();
        }

        return "index.jsp";
    }

}
