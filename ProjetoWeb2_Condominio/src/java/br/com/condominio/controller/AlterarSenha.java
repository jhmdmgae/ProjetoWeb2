package br.com.condominio.controller;


import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class AlterarSenha implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String codigo = request.getParameter("cod");

        if (codigo != null && request.getServletContext().getAttribute(codigo) != null) {
            Usuario usuario = (Usuario) request.getServletContext().getAttribute(codigo);
            String senha = request.getParameter("senha");
            usuario.setSenha(senha);

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.alterar(usuario);
        } else {
            return "codigo_expirou.html";
        }
        return "login.jsp";
    }
}
