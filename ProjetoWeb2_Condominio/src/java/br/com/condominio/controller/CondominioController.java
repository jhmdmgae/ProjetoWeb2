package br.com.condominio.controller;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.controller.logica.condominio.AlterarCondominio;
import br.com.condominio.controller.logica.condominio.CadastrarCondominio;
import br.com.condominio.controller.logica.condominio.ExcluirCondominio;
import br.com.condominio.controller.logica.condominio.FormAlterarCondominio;
import br.com.condominio.controller.logica.condominio.FormCadastroCondominio;
import br.com.condominio.controller.logica.condominio.ListarCondominios;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
@WebServlet(name = "CondominioController", urlPatterns = {"/condocontroller.do"})
public class CondominioController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, Logica> logicas = new HashMap<String, Logica>();
        logicas.put("alterar", new AlterarCondominio());
        logicas.put("cadastrar", new CadastrarCondominio());
        logicas.put("excluir", new ExcluirCondominio());
        logicas.put("foreditar", new FormAlterarCondominio());
        logicas.put("forcadastrar", new FormCadastroCondominio());
        logicas.put("listar", new ListarCondominios());
        
        String parametro = request.getParameter("acao");

        try {
            Logica logica = logicas.get(parametro);
            // Recebe o String após a execução da lógica
            String pagina = logica.executa(request, response);
            // Faz o forward para a página JSP
            request.getRequestDispatcher(pagina).forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("404.html");
            System.out.println("A lógica de negócios causou uma exceção ");
            e.printStackTrace();
        }
    }
}
