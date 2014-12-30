package br.com.condominio.controller.logica.apartamento;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.entidades.Apartamento;
import br.com.condominio.jdbc.dao.ApartamentoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class AlterarApartamento implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();

        String id = request.getParameter("id");
        String numero = request.getParameter("numero");
        String bloco = request.getParameter("bloco");
        String proprietario = request.getParameter("proprietario");
        String locatario = request.getParameter("locatario");

        Apartamento apartamento = new Apartamento();
        
        apartamento.setId(Integer.parseInt(id));
        apartamento.setNumero(Integer.parseInt(numero));
        apartamento.setBloco(Integer.parseInt(bloco));
        apartamento.setProprietario(proprietario);
        apartamento.setLocatario(locatario);

        apartamentoDAO.alterar(apartamento);

        return "listar_apartamentos.jsp";
    }

}
