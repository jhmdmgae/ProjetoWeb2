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

    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO web2_condominio.usuario ( nome, login, senha, perfil, telefone) VALUES (?, ?, ?, ?, ?)";

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
        String sql = "UPDATE web2_condominio.usuario SET nome=?, login=?, senha= ?, perfil=?, telefone=? WHERE id_usuario = ?";

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
        String sql = "DELETE FROM web2_condominio.usuario WHERE id_usuario = ?";

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
        String sql = "SELECT id_usuario, nome, login, senha, perfil, telefone FROM web2_condominio.usuario";

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
        String sql = "SELECT id_usuario, nome, login, senha, perfil, telefone FROM web2_condominio.usuario WHERE id_usuario=?";
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

    public Usuario autenticar(Usuario usuario) {
        String sql = "SELECT * FROM web2_condominio.usuario WHERE login=? AND senha=?";
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

}
