package br.com.condominio.jdbc.dao;

import br.com.condominio.entidades.Documento;
import br.com.condominio.jdbc.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Henrique 2
 */
public class DocumentoDAO {

    private Connection con = Conexao.getConnection();

    public void cadastrar(Documento documento) {
        String sql = "INSERT INTO web2_condominio.documento (id_documento, titulo, descricao, categorias, autor, arquivo) VALUES (NULL, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, documento.getTitulo());
            ps.setString(2, documento.getDescricao());
            ps.setString(3, documento.getCategoria());
            ps.setString(4, documento.getAutor());
            ps.setString(5, documento.getArquivo());
                    
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Documento documento) {
        String sql = "UPDATE documento SET titulo=?,descricao=?,categorias=?,autor=?,arquivo=? WHERE documento.id_documento = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, documento.getTitulo());
            ps.setString(2, documento.getDescricao());
            ps.setString(3, documento.getCategoria());
            ps.setString(4, documento.getAutor());
            ps.setString(5, documento.getArquivo());
            
            ps.setInt(6, documento.getId());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(Documento documento) {
        String sql = "DELETE FROM web2_condominio.documento WHERE id_documento = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documento.getId());
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Documento> buscarTodos() {
        String sql = "SELECT * FROM web2_condominio.documento";

        List<Documento> documentos = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            documentos = new ArrayList();

            while (resultSet.next()) {
                Documento documento = new Documento();

                documento.setId(resultSet.getInt("id_documento"));
                documento.setTitulo(resultSet.getString("titulo"));
                documento.setDescricao(resultSet.getString("descricao"));
                documento.setCategoria(resultSet.getString("categorias"));
                documento.setAutor(resultSet.getString("autor"));
                documento.setArquivo(resultSet.getString("arquivo"));

                documentos.add(documento);
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return documentos;
    }

    public Documento buscar(Integer idDocumento) {
        String sql = "SELECT * FROM web2_condominio.documento WHERE id_documento=?";
        Documento documento = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDocumento);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                documento = new Documento();

                documento.setId(resultSet.getInt("id_documento"));
                documento.setTitulo(resultSet.getString("titulo"));
                documento.setDescricao(resultSet.getString("descricao"));
                documento.setCategoria(resultSet.getString("categorias"));
                documento.setAutor(resultSet.getString("autor"));
                documento.setArquivo(resultSet.getString("arquivo"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return documento;
    }
    
    public List<String> buscarCategoria() {

        String sql = "SELECT nome FROM web2_condominio.categoria_documentos";

        List<String> nomes = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
//          
            ResultSet resultSet = ps.executeQuery();

            nomes = new ArrayList();

            while (resultSet.next()) {

                nomes.add(resultSet.getString("nome"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomes;
    }
    
    public String buscarCategoria(int chave) {
        
        String sql = "SELECT nome FROM web2_condominio.categoria_documentos WHERE id_categoria_documentos=?";
        
        String nome = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, chave);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                
                nome = resultSet.getString("nome"); 

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nome;
    }
    
    public List<String> buscarAutor() {

        String sql = "SELECT nome FROM web2_condominio.usuario";

        List<String> nomes = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
//          
            ResultSet resultSet = ps.executeQuery();

            nomes = new ArrayList();

            while (resultSet.next()) {

                nomes.add(resultSet.getString("nome"));

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomes;
    }
    
    public String buscarAutor(int chave) {
        
        String sql = "SELECT nome FROM web2_condominio.usuario WHERE id_usuario=?";
        
        String nome = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, chave);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                
                nome = resultSet.getString("nome"); 

            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nome;
    }

    public void salvar(Documento documento) {
        if (documento.getId() != 0) {
            alterar(documento);
        } else {
            cadastrar(documento);
        }
    }

}
