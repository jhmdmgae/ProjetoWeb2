package br.com.condominio.controller;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.controller.logica.visitantes.AlterarVisitante;
import br.com.condominio.controller.logica.visitantes.CadastrarVisitante;
import br.com.condominio.controller.logica.visitantes.ExcluirVisitante;
import br.com.condominio.controller.logica.visitantes.FormAlterarVisitante;
import br.com.condominio.controller.logica.visitantes.FormCadastroVisitante;
import br.com.condominio.controller.logica.visitantes.ListarVisitantes;
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
@WebServlet(name = "VisitanteController", urlPatterns = {"/visitcontroller.do"})
public class VisitanteController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, Logica> logicas = new HashMap<String, Logica>();
        logicas.put("editar", new AlterarVisitante());
        logicas.put("cadastrar", new CadastrarVisitante());
        logicas.put("excluir", new ExcluirVisitante());
        logicas.put("foreditar", new FormAlterarVisitante());
        logicas.put("forcadastrar", new FormCadastroVisitante());
        logicas.put("listar", new ListarVisitantes());

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
