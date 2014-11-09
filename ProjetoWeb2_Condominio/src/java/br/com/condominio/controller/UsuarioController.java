package br.com.condominio.controller;

import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 *
 * @author LOURIVALDO
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/usucontroller.do"})
public class UsuarioController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao" );
        UsuarioDAO usuarioDAO;
        usuarioDAO = new UsuarioDAO();

        if (acao != null && acao.equals("exc")) {
            String id = request.getParameter("id");

            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(id));
            usuarioDAO.excluir(usuario);

        }
        if (acao != null && acao.equals("alt")) {
            String id = request.getParameter("id");

            Usuario usuario = usuarioDAO.buscar(Integer.parseInt(id));
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("jsp/cadastro_usuario.jsp").forward(request, response);

        } 
       if (acao != null && acao.equals("list")) {
            request.setAttribute("lista", new UsuarioDAO().buscarTodos());
            request.getRequestDispatcher("jsp/listausuarios.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.salvar(usuario);

        response.getWriter().write("Cadastrado");

    }

}
