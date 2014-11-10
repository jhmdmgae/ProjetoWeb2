package br.com.condominio.controller;

import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/usucontroller.do"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String parametro = request.getParameter("acao");
        String nomeDaClasse = "br.com.condominio.controller." + parametro;

        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Logica logica = (Logica) classe.newInstance();

            // Recebe o String após a execução da lógica
            String pagina = logica.executa(request, response);

            // Faz o forward para a página JSP
            request.getRequestDispatcher(pagina).forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("404.html");
//            throw new ServletException("A lógica de negócios causou uma exceção", e);
        }
    }
}
