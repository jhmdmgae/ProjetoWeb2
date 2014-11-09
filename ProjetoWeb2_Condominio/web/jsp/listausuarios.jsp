<%-- 
    Document   : listausuarios
    Created on : 09/11/2014, 00:44:17
    Author     : LOURIVALDO
--%>

<%@page import="br.com.condominio.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            table, tr, th, td{
                border: black solid 1px;
                border-collapse: collapse;
            } 
            table{
                width: 700px;
            }
        </style>
    </head>
    <body>
        <table>
            <tr>
                <th>AÇÃO</th>
                <th>ID</th>
                <th>LOGIN</th>
                <th>PERFIL</th>
                <th>TELEFONE</th>
            </tr>
            <%
                List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
                if(lista.equals(null)){
                    response.getWriter().write("null");
                }
                for (Usuario usu : lista) {
            %>
            <tr>
                <td>
                    <a href="usucontroller.do?acao=exc&id=<%= usu.getId()%>">Excluir</a>
                    <a href="usucontroller.do?acao=alt&id=<%= usu.getId()%>">Editar</a>
                </td>
                <td><%= usu.getId()%></td>
                <td><%= usu.getLogin()%></td>
                <td><%= usu.getPerfil()%></td>
                <td><%= usu.getTelefone()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
