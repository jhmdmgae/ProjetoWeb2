package br.com.condominio.controller.logica;

import br.com.condominio.entidades.Documento;
import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.DocumentoDAO;
import br.com.condominio.jdbc.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class FormAlterarDocumento implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentoDAO documentoDAO = new DocumentoDAO();

        String id = request.getParameter("id");
        Documento documento = documentoDAO.buscar(Integer.parseInt(id));

        if (documento != null) {
            request.setAttribute("documentoAlterar", documento);
            return "alterar_documento.jsp";
        }

        return "listar_documentos.jsp";

    }

}
