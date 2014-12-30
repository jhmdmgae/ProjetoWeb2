package br.com.condominio.controller.logica;

import br.com.condominio.entidades.Apartamento;
import br.com.condominio.jdbc.ApartamentoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class FormAlterarApartamento implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();

        String id = request.getParameter("id");
        Apartamento apartamento = apartamentoDAO.buscar(Integer.parseInt(id));

        if (apartamento != null) {
            request.setAttribute("apartamentoAlterar", apartamento);
            return "alterar_apartamento.jsp";
        }

        return "listar_apartamentos.jsp";
    }

}