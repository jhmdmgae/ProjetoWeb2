package br.com.condominio.controller.logica.documento;

import br.com.condominio.controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class FormCadastroDocumento implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        return "adicionar_documento.jsp";
    }
    
}
