package br.com.condominio.controller.logica;

import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LOURIVALDO
 */
public class LogarSistema implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if (login == null || senha == null) {
            return "login_error.html";
        }

        Usuario novoUsuario;
        UsuarioDAO usuarioDAO;
        HttpSession session;

        if (request.getSession(false) == null
                || request.getSession(false).getAttribute("usuAutenticado") == null) {
            novoUsuario = new Usuario();
            usuarioDAO = new UsuarioDAO();

            novoUsuario.setLogin(login);
            novoUsuario.setSenha(senha);

//            Usuario usuAutenticado = usuarioDAO.autenticar(novoUsuario);
            Usuario usuAutenticado = usuarioDAO.buscarEmail(login);
            if (usuAutenticado == null) {
                return "login.jsp";
            }
            session = request.getSession();
            if(usuAutenticado.getNome() == null){
                return "login_error.html";
            }
            session.setAttribute("usuAutenticado", usuAutenticado);

        }
        return "index.jsp";
    }

}
