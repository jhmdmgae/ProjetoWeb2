package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Documento;
import br.com.condominio.jdbc.DocumentoDAO;
import java.util.List;

/** Testado
 *
 * @author João Henrique 2
 */
public class TestDocumentoDAO {

    private static void cadastrar() {
        Documento documento = new Documento();

        documento.setTitulo("2");
        documento.setDescricao("2");
        documento.setCategoria("2");
        documento.setAutor("9");
        documento.setArquivo("1");

        DocumentoDAO documentoDAO = new DocumentoDAO();
        documentoDAO.cadastrar(documento);
    }

    private static void alterar() {
        Documento documento = new Documento();

        documento.setTitulo("6");
        documento.setDescricao("6");
        documento.setCategoria("6");
        documento.setAutor("9");
        documento.setArquivo("1");

        documento.setId(6);

        DocumentoDAO documentoDAO = new DocumentoDAO();
        documentoDAO.alterar(documento);
    }

    private static void excluir() {
        Documento documento = new Documento();

        documento.setId(6);

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
    
    private static void buscarCategoria(int id) {
        DocumentoDAO documentoDAO = new DocumentoDAO();
        String nome = documentoDAO.buscarCategoria(id);

        if (nome != null) {
            System.out.println("Nome da categoria: " + nome);
        }
    }

    public static void main(String[] args) {

//        cadastrar();
//        alterar();
//        buscarTodos();
//        buscar(6);
//        excluir();
        buscarCategoria(6);

    }

}
