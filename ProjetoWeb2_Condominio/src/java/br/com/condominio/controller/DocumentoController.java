package br.com.condominio.controller;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.controller.logica.documento.AlterarDocumento;
import br.com.condominio.controller.logica.documento.CadastrarDocumento;
import br.com.condominio.controller.logica.documento.ExcluirDocumento;
import br.com.condominio.controller.logica.documento.FormAlterarDocumento;
import br.com.condominio.controller.logica.documento.FormCadastroDocumento;
import br.com.condominio.controller.logica.documento.ListarDocumentos;
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
@WebServlet(name = "DocumentoController", urlPatterns = {"/doccontroller.do"})
public class DocumentoController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, Logica> logicas = new HashMap<String, Logica>();
        logicas.put("alterar", new AlterarDocumento());
        logicas.put("cadastrar", new CadastrarDocumento());
        logicas.put("excluir", new ExcluirDocumento());
        logicas.put("foreditar", new FormAlterarDocumento());
        logicas.put("forcadastrar", new FormCadastroDocumento());
        logicas.put("listar", new ListarDocumentos());
        
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
