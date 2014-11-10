package br.com.condominio.controller;

import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class FormAlterarUsuario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        String id = request.getParameter("id");
        Usuario usuario = usuarioDAO.buscar(Integer.parseInt(id));

        if (usuario == null) {
            return "usuario_nao_existe";
        }
        
        request.setAttribute("usuarioAlterar", usuario);

        return "alterar_usuario.jsp";
    }

}
