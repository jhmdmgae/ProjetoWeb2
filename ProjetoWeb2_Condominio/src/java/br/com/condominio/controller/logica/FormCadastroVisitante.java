package br.com.condominio.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class FormCadastroVisitante implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        return "adicionar_visitante.jsp";
    }
    
}
