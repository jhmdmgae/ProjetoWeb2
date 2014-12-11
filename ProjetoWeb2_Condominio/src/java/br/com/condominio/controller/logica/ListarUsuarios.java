package br.com.condominio.controller.logica;

import br.com.condominio.jdbc.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class ListarUsuarios implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("lista", new UsuarioDAO().buscarTodos());
        return "listar_usuarios.jsp";
    }

}
