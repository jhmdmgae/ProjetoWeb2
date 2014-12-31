package br.com.condominio.controller.logica.condominio;

import br.com.condominio.controller.logica.condominio.*;
import br.com.condominio.controller.logica.Logica;
import br.com.condominio.entidades.Condominio;
import br.com.condominio.jdbc.dao.CondominioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class AlterarCondominio implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CondominioDAO condominioDAO = new CondominioDAO();

        Condominio condominio = new Condominio();
        
        condominio.setCnpj(request.getParameter("cnpj"));
        condominio.setNome(request.getParameter("nome"));
        condominio.setCep(request.getParameter("cep"));
        condominio.setEndereco(request.getParameter("endereco"));
        condominio.setNumero(request.getParameter("numero"));
        condominio.setComplemento(request.getParameter("complemento"));
        condominio.setBairro(request.getParameter("bairro"));
        condominio.setUf(request.getParameter("uf"));
        condominio.setCidade(request.getParameter("cidade"));
        condominio.setQuantBlocos(Integer.parseInt(request.getParameter("quantBlocos")));
        condominio.setQuantApt(Integer.parseInt(request.getParameter("quantApt")));
        condominio.setFoto(request.getParameter("foto"));
        condominio.setTelefone(request.getParameter("telefone"));
        condominio.setEmail(request.getParameter("email"));

        condominioDAO.alterar(condominio);

        return "listar_condominios.jsp";
    }

}
