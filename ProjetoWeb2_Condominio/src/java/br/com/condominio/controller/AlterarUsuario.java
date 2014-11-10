package br.com.condominio.controller;

import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class AlterarUsuario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario usu = new Usuario();

        String id = request.getParameter("id");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String perfil = request.getParameter("perfil");
        String tel = request.getParameter("telefone");

        usu.setId(Integer.parseInt(id));
        usu.setLogin(login);
        usu.setSenha(senha);
        usu.setNome(nome);
        usu.setPerfil(perfil);
        usu.setTelefone(tel);

        usuarioDAO.alterar(usu);

        request.setAttribute("lista", new UsuarioDAO().buscarTodos());
        return "listar_usuarios.jsp";
    }

}
