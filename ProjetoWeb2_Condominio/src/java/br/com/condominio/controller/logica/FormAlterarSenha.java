package br.com.condominio.controller.logica;

import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Formulario acessado atraves do e-mail pessoal. Verificar se existe alguma
 * entrada de recuperaçao (na tabela codigo_senha) para o e-mail(do paramentro),
 * e que o codigo seja igual ao da tabela.
 *
 * @author LOURIVALDO
 */
public class FormAlterarSenha implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String codigo = request.getParameter("cod");
        String email = request.getParameter("email");

        if (codigo != null
                && email != null) {
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.buscarEmail(email);

            if (usuario != null) { //email cadastrado
                String codigoRecuperacao = usuarioDAO.getCodigoRecuperacao(usuario);
//                System.out.println(codigoRecuperacao);
                if (codigo.equals(codigoRecuperacao)) {
                    request.setAttribute("cod",codigo);
                    request.setAttribute("email",email);
//                    return "404.html";
                    return "nova_senha.jsp";
                }
            }
        }

        return "codigo_expirou.html";
    }
}
