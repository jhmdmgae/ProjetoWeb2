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
        <title>Alterar Cadastro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            Usuario usu = (Usuario) request.getAttribute("usuarioAlterar");
        %>
        <h1>A senha deve ser alterada obrigatoriamente</h1>
        <!--***************************** Alterar passagem de senha e verificaçao null-->
        <div>
            <form method="POST" action="usucontroller.do?acao=AlterarUsuario&id=<%= usu.getId()%>">
                <input type="email" name="login" value="<%= usu == null ? "alguem@mail.com" : usu.getLogin()%>" /><br />
                <input type="password" name="senhaAtual" value="1234" /><br />
                <input type="password" name="senha" value="1234" /><br />
                <input type="password" name="confirmar" value="1234" /><br />
                <input type="text" name="nome" value="<%=usu == null ? "alguem" : usu.getNome()%>" /><br />
                <input type="text" name="telefone" value="<%=usu == null ? "8888888999" : usu.getTelefone()%>" /><br />
                <select name="perfil" >
                    <%
                        Usuario usuAdmin = (Usuario) session.getAttribute("usuAutenticado");
                        if (usuAdmin != null && usuAdmin.getPerfil().equalsIgnoreCase("administrador")) {
                    %>
                    <option>Administrador</option>
                    <%
                        }
                    %>
                    <%
                        if (usu.getPerfil().equalsIgnoreCase("Sindico")) {
                    %>
                    <option selected="selected">Sindico</option>
                    <%
                    } else {
                    %>
                    %>
                    <option>Sindico</option>
                    <%
                        }
                    %><%
                        if (usu.getPerfil().equalsIgnoreCase("Morador")) {
                    %>
                    <option selected="selected">Morador</option>
                    <%
                    } else {
                    %>
                    %>
                    <option>Morador</option>
                    <%
                        }
                    %>
                </select>
                <input type="submit" value="cadastrar" />           
            </form>
        </div>
    </body>
</html>
