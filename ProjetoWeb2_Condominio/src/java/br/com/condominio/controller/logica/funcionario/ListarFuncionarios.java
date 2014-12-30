package br.com.condominio.controller.logica.funcionario;

import br.com.condominio.controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class ListarFuncionarios implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "listar_funcionarios.jsp";
    }

}
