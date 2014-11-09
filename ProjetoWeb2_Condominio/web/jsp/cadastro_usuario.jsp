<%-- 
    Document   : listausuarios
    Created on : 09/11/2014, 00:44:17
    Author     : LOURIVALDO
--%>

<%@page import="br.com.condominio.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            Usuario usu = (Usuario) request.getAttribute("usuario");
        %>
        <div>
            <form method="POST" action="usucontroller.do">
                <input type="email" name="login" value="<%= usu.getLogin()%>" /><br />
                <input type="password" name="senha" value="<%=usu.getSenha()%>" /><br />
                <input type="password" name="confirmar" value="<%=usu.getSenha()%>" /><br />
                <input type="text" name="nome" value="<%=usu.getNome()%>" /><br />
                <input type="text" name="telefone" value="<%=usu.getTelefone()%>" /><br />
                <%
                    String perfil = usu.getPerfil();
                %>
                <select name="perfil" >
                    <%
                        if (perfil.equalsIgnoreCase("administrador")) {
                    %>
                    <option selected="selected">Administrador</option>
                    <%
                    } else {
                    %>
                    %>
                    <option>Administrador</option>
                    <%
                        }
                    %>
                    <%
                        if (perfil.equalsIgnoreCase("Sindico")) {
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
                        if (perfil.equalsIgnoreCase("Morador")) {
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
