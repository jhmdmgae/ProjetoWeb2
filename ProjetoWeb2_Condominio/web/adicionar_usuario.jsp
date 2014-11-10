<%-- 
    Document   : 
    Created on : 09/11/2014, 00:44:17
    Author     : LOURIVALDO
--%>

<%@page import="br.com.condominio.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro Usuário</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <form method="POST" action="usucontroller.do?acao=CadastrarUsuario">
                <input type="email" name="login" value="alguem@mail.com" /><br />
                <input type="password" name="senha" value="1234" /><br />
                <input type="password" name="confirmar" value="1234" /><br />
                <input type="text" name="nome" value="alguem" /><br />
                <input type="text" name="telefone" value="(81)9999-9999" /><br />
                <select name="perfil" >
                    <%
                        //caso haja uma sessão em que o usuario e administrador
                        Usuario usu = (Usuario) session.getAttribute("usuAutenticado");
                        if (usu != null && usu.getPerfil().equalsIgnoreCase("administrador")) {
                    %>
                    <option>Administrador</option>
                    <%
                        }
                    %>
                    <option>Sindico</option>
                    <option>Morador</option>
                </select>
                <input type="submit" value="cadastrar" />           
            </form>
        </div>
    </body>
</html>
