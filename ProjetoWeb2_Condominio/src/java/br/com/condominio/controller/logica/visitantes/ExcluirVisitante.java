package br.com.condominio.controller.logica.visitantes;

import br.com.condominio.controller.logica.veiculo.*;
import br.com.condominio.controller.logica.Logica;
import br.com.condominio.entidades.Veiculo;
import br.com.condominio.jdbc.dao.VeiculoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class ExcluirVisitante implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        VeiculoDAO veiculoDAO = new VeiculoDAO();

        String id = request.getParameter("id");
        Veiculo veiculo = veiculoDAO.buscar(Integer.parseInt(id));

        if (veiculo != null) {
            veiculoDAO.excluir(veiculo);
        }

        return "listar_veiculos.jsp";
    }

}
