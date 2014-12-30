package br.com.condominio.controller.logica.usuario;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.dao.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class ExcluirUsuario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        String id = request.getParameter("id");
        Usuario usuario = usuarioDAO.buscar(Integer.parseInt(id));

        if (usuario != null) {
            usuarioDAO.excluir(usuario);
            
        }

        request.setAttribute("lista", new UsuarioDAO().buscarTodos());
        return "listar_usuarios.jsp";
    }

}
