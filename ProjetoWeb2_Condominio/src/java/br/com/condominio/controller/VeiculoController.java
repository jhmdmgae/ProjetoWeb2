package br.com.condominio.controller;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.controller.logica.veiculo.AlterarVeiculo;
import br.com.condominio.controller.logica.veiculo.CadastrarVeiculo;
import br.com.condominio.controller.logica.veiculo.ExcluirVeiculo;
import br.com.condominio.controller.logica.veiculo.FormAlterarVeiculo;
import br.com.condominio.controller.logica.veiculo.FormCadastroVeiculo;
import br.com.condominio.controller.logica.veiculo.ListarVeiculos;
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
@WebServlet(name = "VeiculoController", urlPatterns = {"/veiccontroller.do"})
public class VeiculoController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, Logica> logicas = new HashMap<String, Logica>();
        logicas.put("alterar", new AlterarVeiculo());
        logicas.put("cadastrar", new CadastrarVeiculo());
        logicas.put("excluir", new ExcluirVeiculo());
        logicas.put("foreditar", new FormAlterarVeiculo());
        logicas.put("forcadastrar", new FormCadastroVeiculo());
        logicas.put("listar", new ListarVeiculos());

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
