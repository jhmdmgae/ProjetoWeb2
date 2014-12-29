package br.com.condominio.controller.logica;

import br.com.condominio.entidades.Apartamento;
import br.com.condominio.jdbc.ApartamentoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class CadastrarApartamento implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();

        String numero = request.getParameter("numero");
        String bloco = request.getParameter("bloco");
        String proprietario = request.getParameter("proprietario");
        String locatario = request.getParameter("locatario");

        Apartamento apartamento = new Apartamento();
        apartamento.setNumero(Integer.parseInt(numero));
        apartamento.setBloco(Integer.parseInt(bloco));
        apartamento.setProprietario(proprietario);
        apartamento.setLocatario(locatario);

        apartamentoDAO.cadastrar(apartamento);

        return "apartamentos.jsp";
    }
}
