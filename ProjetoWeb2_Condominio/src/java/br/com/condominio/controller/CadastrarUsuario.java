package br.com.condominio.controller;

import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class CadastrarUsuario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String perfil = request.getParameter("perfil");
        String tel = request.getParameter("telefone");

        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setNome(nome);
        usuario.setPerfil(perfil);
        usuario.setTelefone(tel);

        usuarioDAO.cadastrar(usuario);

        request.setAttribute("lista", new UsuarioDAO().buscarTodos());
        return "listar_usuarios.jsp";
    }
}
