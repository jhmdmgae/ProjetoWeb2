package br.com.condominio.controller.logica.apartamento;

import br.com.condominio.controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class ListarApartamentos implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "listar_apartamentos.jsp";
    }

}
