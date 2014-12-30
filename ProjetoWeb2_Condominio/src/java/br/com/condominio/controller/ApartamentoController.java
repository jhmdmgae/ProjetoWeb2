package br.com.condominio.controller;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.controller.logica.apartamento.AlterarApartamento;
import br.com.condominio.controller.logica.apartamento.CadastrarApartamento;
import br.com.condominio.controller.logica.apartamento.ExcluirApartamento;
import br.com.condominio.controller.logica.apartamento.FormAlterarApartamento;
import br.com.condominio.controller.logica.apartamento.FormCadastroApartamento;
import br.com.condominio.controller.logica.apartamento.ListarApartamentos;
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
@WebServlet(name = "ApartamentoController", urlPatterns = {"/apartcontroller.do"})
public class ApartamentoController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, Logica> logicas = new HashMap<String, Logica>();
        logicas.put("editar", new AlterarApartamento());
        logicas.put("cadastrar", new CadastrarApartamento());
        logicas.put("excluir", new ExcluirApartamento());
        logicas.put("foreditar", new FormAlterarApartamento());
        logicas.put("forcadastrar", new FormCadastroApartamento());
        logicas.put("listar", new ListarApartamentos());

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
