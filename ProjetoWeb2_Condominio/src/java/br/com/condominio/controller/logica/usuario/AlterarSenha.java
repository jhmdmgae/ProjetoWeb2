package br.com.condominio.controller.logica.usuario;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.dao.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Recebe pedido de alteracao de senha apartir de formulario
 *
 * @author LOURIVALDO
 */
public class AlterarSenha implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String codigo = request.getParameter("cod");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (codigo != null
                && email != null
                && senha != null) {

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.buscarEmail(email);

            if (usuario != null) { //email cadastrado
                String codigoRecuperacao = usuarioDAO.getCodigoRecuperacao(usuario);

                if (codigo.equals(codigoRecuperacao)) {
                    usuario.setSenha(senha);
                    usuarioDAO.alterar(usuario);
                    return "login.jsp";
                }
            }
        }

        return "codigo_expirou.html";

    }
}
