package br.com.condominio.jdbc;

import br.com.condominio.entidades.Usuario;
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
 * @author LOURIVALDO
 */
public class UsuarioDAO {

    private Connection con = Conexao.getConnection();
    private String tabela = "web2_condominio.usuario";

    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO " + this.tabela + " ( nome, login, senha, perfil, telefone) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getPerfil());
            ps.setString(5, usuario.getTelefone());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Usuario usuario) {
        String sql = "UPDATE " + this.tabela + " SET nome=?, login=?, senha= ?, perfil=?, telefone=? WHERE id_usuario = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getPerfil());
            ps.setString(5, usuario.getTelefone());
            ps.setInt(6, usuario.getId());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(Usuario usuario) {
        String sql = "DELETE FROM " + this.tabela + " WHERE id_usuario = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> buscarTodos() {
        String sql = "SELECT id_usuario, nome, login, senha, perfil, telefone FROM " + this.tabela;

        List<Usuario> usuarios = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            usuarios = new ArrayList();

            while (resultSet.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenhaHash(resultSet.getString("senha"));
                usuario.setPerfil(resultSet.getString("perfil"));
                usuario.setTelefone(resultSet.getString("telefone"));

                usuarios.add(usuario);
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public Usuario buscar(Integer idUsuario) {
        String sql = "SELECT id_usuario, nome, login, senha, perfil, telefone FROM " + this.tabela + " WHERE id_usuario=?";
        Usuario usuario = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario();

                usuario.setId(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenhaHash(resultSet.getString("senha"));
                usuario.setPerfil(resultSet.getString("perfil"));
                usuario.setTelefone(resultSet.getString("telefone"));
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    /**
     *
     * @param email
     * @return
     */
    public Usuario buscarEmail(String email) {
        String sql = "SELECT id_usuario, nome, login, senha, perfil, telefone FROM " + this.tabela + " WHERE login=?";
        Usuario usuario = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario();

                usuario.setId(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenhaHash(resultSet.getString("senha"));
                usuario.setPerfil(resultSet.getString("perfil"));
                usuario.setTelefone(resultSet.getString("telefone"));
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    /**
     *
     * @param usuario
     * @return
     */
    public Usuario autenticar(Usuario usuario) {
        String sql = "SELECT id_usuario, nome, login, senha, perfil, telefone FROM " + this.tabela + " WHERE login=? AND senha=?";
        Usuario usuarioRetorno = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                usuarioRetorno = new Usuario();

                usuario.setId(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setPerfil(resultSet.getString("perfil"));
                usuario.setTelefone(resultSet.getString("telefone"));
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioRetorno;
    }

    public void salvar(Usuario usuario) {
        if (usuario.getId() != null || usuario.getId() != 0) {
            alterar(usuario);
        } else {
            cadastrar(usuario);
        }
    }

    /**
     * Retorna apenas o codigo mais recente, e exclui todos anteriores
     *
     * @param usuario
     * @return null: se nao existe pedido de recuperaçao.
     *
     */
    public String getCodigoRecuperacao(Usuario usuario) {

        String sql = "SELECT id_codigo, codigo, data FROM web2_condominio.codigo_senha "
                + "WHERE usuario_id_usuario=?";
        String codigoRetorno = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                codigoRetorno = resultSet.getString("codigo");
                System.out.println(codigoRetorno);
            }

//            String sqlDelete = "DELETE FROM web2_condominio.codigo_senha WHERE usuario_id_usuario=?";
//
//            PreparedStatement psDelete = con.prepareStatement(sqlDelete);
//            psDelete.setInt(1, usuario.getId());
//            psDelete.execute();
            ps.close();
//            psDelete.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codigoRetorno;
    }

    public void setCodigoRecuperacao(Usuario usuario, String codigo) {

        String sql = "INSERT INTO web2_condominio.codigo_senha (codigo,usuario_id_usuario) VALUES (?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, codigo);
            ps.setInt(2, usuario.getId());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
