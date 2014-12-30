package br.com.condominio.controller.logica.documento;

import br.com.condominio.controller.logica.Logica;
import br.com.condominio.entidades.Apartamento;
import br.com.condominio.entidades.Documento;
import br.com.condominio.jdbc.dao.DocumentoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class ExcluirDocumento implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        DocumentoDAO documentoDAO = new DocumentoDAO();

        String id = request.getParameter("id");
        Documento documento = documentoDAO.buscar(Integer.parseInt(id));

        if (documento != null) {
            documentoDAO.excluir(documento);
        }

        return "listar_documentos.jsp";
    }

}
