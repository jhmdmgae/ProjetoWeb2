package br.com.condominio.controller.logica.funcionario;

import br.com.condominio.controller.logica.apartamento.*;
import br.com.condominio.controller.logica.Logica;
import br.com.condominio.entidades.Apartamento;
import br.com.condominio.entidades.Funcionario;
import br.com.condominio.jdbc.dao.ApartamentoDAO;
import br.com.condominio.jdbc.dao.FuncionarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class ExcluirFuncionario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        String id = request.getParameter("id");
        Funcionario funcionario = funcionarioDAO.buscar(Integer.parseInt(id));

        if (funcionario != null) {
            funcionarioDAO.excluir(funcionario);
        }

        return "listar_funcionarios.jsp";
    }

}
