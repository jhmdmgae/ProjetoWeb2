package br.com.condominio.controller.logica.condominio;

import br.com.condominio.controller.logica.condominio.*;
import br.com.condominio.controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class FormCadastroCondominio implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        return "adicionar_condominio.jsp";
    }
    
}
