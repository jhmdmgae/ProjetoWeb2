package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.UsuarioDAO;
import java.util.List;

/**
 *
 * @author LOURIVALDO
 */
public class TestUserDAO {

    private static void cadastrar() { 
        Usuario usuario = new Usuario();
        usuario.setNome("João Henrique Medeiros");
        usuario.setLogin("jogodavelha65565@gmail.com");
        usuario.setSenha("1234"); 
        usuario.setPerfil("administrador");
        usuario.setTelefone("(81) 0000-0000");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.cadastrar(usuario);
    }

    private static void alterar() {
        Usuario usuario = new Usuario();
        usuario.setNome("João Henrique Medeiros");
        usuario.setLogin("jogodavelha@gmail.com");
        usuario.setSenha("12345");
        usuario.setPerfil("administrador");
        usuario.setTelefone("(81) 9999-0000");

        usuario.setId(8);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.alterar(usuario);
    }

    private static void excluir() {
        Usuario usuario = new Usuario();
        usuario.setNome("João Henrique Medeiros");
        usuario.setLogin("jogodavelha@gmail.com");
        usuario.setSenha("12345"); 
        usuario.setPerfil("administrador");
        usuario.setTelefone("(81) 9999-0000");

        usuario.setId(8);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.excluir(usuario);
    }

    private static void buscarTodos() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> buscarTodos = usuarioDAO.buscarTodos();

        for (Usuario usuario : buscarTodos) {
            System.out.println(usuario.getLogin());
        }
    }

    private static void buscar(int id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscar(id);

        if (usuario != null) {
            System.out.println("Achado " + usuario.getLogin());
        }

    }

    private static void autenticar(String login, String senha) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        Usuario usuarioAutenticado = usuarioDAO.autenticar(usuario);

        if (usuarioAutenticado != null) {
            System.out.println("Autenticado");
        }

    }

    public static void main(String[] args) {
//        cadastrar();
//        alterar();
//        excluir();
//        buscarTodos();
//        buscar(8);
        autenticar("loro.vasconcelos@gmail.com", "1234");
    }

}
