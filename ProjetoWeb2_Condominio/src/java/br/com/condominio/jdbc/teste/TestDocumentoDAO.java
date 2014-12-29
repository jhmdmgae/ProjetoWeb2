package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Documento;
import br.com.condominio.jdbc.DocumentoDAO;
import java.util.List;

/**
 *
 * @author João Henrique 2
 */
public class TestDocumentoDAO {

    private static void cadastrar() {
        Documento documento = new Documento();

        documento.setTitulo("1");
        documento.setDescricao("1");
        documento.setCategoria("1");
        documento.setAutor("9");
        documento.setArquivo("1");

        DocumentoDAO documentoDAO = new DocumentoDAO();
        documentoDAO.cadastrar(documento);
    }

    private static void alterar() {
        Documento documento = new Documento();

        documento.setTitulo("");
        documento.setDescricao("");
        documento.setCategoria("");
        documento.setAutor("");
        documento.setArquivo("");

        documento.setId(5);

        DocumentoDAO documentoDAO = new DocumentoDAO();
        documentoDAO.alterar(documento);
    }

    private static void excluir() {
        Documento documento = new Documento();

        documento.setId(5);

        DocumentoDAO documentoDAO = new DocumentoDAO();
        documentoDAO.excluir(documento);
    }

    private static void buscarTodos() {
        DocumentoDAO documentoDAO = new DocumentoDAO();
        List<Documento> buscarTodos = documentoDAO.buscarTodos();

        for (Documento documento : buscarTodos) {
            System.out.println(documento.getId());
        }
    }

    private static void buscar(int id) {
        DocumentoDAO documentoDAO = new DocumentoDAO();
        Documento documento = documentoDAO.buscar(id);

        if (documento != null) {
            System.out.println("Achado " + documento.getAutor());
        }
    }

    public static void main(String[] args) {

        cadastrar();
//        alterar();
//        buscarTodos();
//        buscar(3);
//        excluir();

    }

}
