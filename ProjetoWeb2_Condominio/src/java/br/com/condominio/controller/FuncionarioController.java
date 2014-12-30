package br.com.condominio.controller;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.controller.logica.funcionario.AlterarFuncionario;
import br.com.condominio.controller.logica.funcionario.CadastrarFuncionario;
import br.com.condominio.controller.logica.funcionario.ExcluirFuncionario;
import br.com.condominio.controller.logica.funcionario.FormAlterarFuncionario;
import br.com.condominio.controller.logica.funcionario.FormCadastroFuncionario;
import br.com.condominio.controller.logica.funcionario.ListarFuncionarios;
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
@WebServlet(name = "FuncionarioController", urlPatterns = {"/funccontroller.do"})
public class FuncionarioController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, Logica> logicas = new HashMap<String, Logica>();
        logicas.put("AlterarFuncionario", new AlterarFuncionario());
        logicas.put("CadastrarFuncionario", new CadastrarFuncionario());
        logicas.put("ExcluirFuncionario", new ExcluirFuncionario());
        logicas.put("FormAlterarFuncionario", new FormAlterarFuncionario());
        logicas.put("ormCadastroFuncionario", new FormCadastroFuncionario());
        logicas.put("ListarFuncionarios", new ListarFuncionarios());

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
