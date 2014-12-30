package br.com.condominio.controller.logica;

import br.com.condominio.entidades.Documento;
import br.com.condominio.jdbc.DocumentoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class AlterarDocumento implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DocumentoDAO documentoDAO = new DocumentoDAO();

        String id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        String categoria = request.getParameter("categoria");
        String autor = request.getParameter("autor");
        String arquivo = request.getParameter("arquivo");

        Documento documento = new Documento();
        documento.setId(Integer.parseInt(id));
        documento.setTitulo(titulo);
        documento.setDescricao(descricao);
        documento.setCategoria(categoria);
        documento.setAutor(autor);
        documento.setArquivo(arquivo);

        documentoDAO.alterar(documento);
        
        return "listar_documentos.jsp";
    }

}
