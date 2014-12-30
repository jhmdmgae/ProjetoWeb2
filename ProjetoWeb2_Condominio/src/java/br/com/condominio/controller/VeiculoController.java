package br.com.condominio.controller;

import br.com.condominio.controller.logica.usuario.AlterarSenha;
import br.com.condominio.controller.logica.usuario.AlterarUsuario;
import br.com.condominio.controller.logica.usuario.CadastrarUsuario;
import br.com.condominio.controller.logica.usuario.EnviarEmailSenha;
import br.com.condominio.controller.logica.usuario.ExcluirUsuario;
import br.com.condominio.controller.logica.usuario.FormAlterarUsuario;
import br.com.condominio.controller.logica.usuario.FormCadastroUsuario;
import br.com.condominio.controller.logica.usuario.FormPedidoSenha;
import br.com.condominio.controller.logica.usuario.ListarUsuarios;
import br.com.condominio.controller.logica.usuario.LogarSistema;
import br.com.condominio.controller.logica.Logica;
import br.com.condominio.controller.logica.usuario.LogoutSistema;
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
        logicas.put("entrar", new LogarSistema());
        logicas.put("sair", new LogoutSistema());
        logicas.put("forpedirsenha", new FormPedidoSenha());
        logicas.put("email", new EnviarEmailSenha());
        logicas.put("listar", new ListarUsuarios());
        logicas.put("excluir", new ExcluirUsuario());
        logicas.put("foreditar", new FormAlterarUsuario());
        logicas.put("editar", new AlterarUsuario());
        logicas.put("forcadastrar", new FormCadastroUsuario());
        logicas.put("cadastrar", new CadastrarUsuario());
        logicas.put("altsenha", new AlterarSenha());

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
