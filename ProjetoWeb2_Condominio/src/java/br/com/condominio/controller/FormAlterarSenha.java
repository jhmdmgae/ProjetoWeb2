package br.com.condominio.controller;

import br.com.condominio.entidades.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class FormAlterarSenha implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String codigo = request.getParameter("cod");
        String email = request.getParameter("email");
        //o código de verificação foi setado no contexto 
        //quando a requisição de alteração foi feita

        if (codigo != null
                && email != null
                && request.getServletContext().getAttribute(codigo) != null) {

//            Usuario usuario = (Usuario) request.getServletContext().getAttribute(codigo);
//            if (usuario.getLogin().equals(email)) {
//                request.setAttribute("usuario", usu);
            return "nova_senha.jsp";
//            }
        } else {
            return "codigo_expirou.html";
        }

    }
}
