<%-- 
    Document   : listausuarios
    Created on : 09/11/2014, 00:44:17
    Author     : LOURIVALDO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.com.condominio.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />
        <style type="text/css">
            table, tr, th, td{
                border: black solid 1px;
                border-collapse: collapse;
            } 
            table{
                /*width: 700px;*/
            }
        </style>
    </head>
    <body>
        <div class="geral">
            <c:import url="cabecalho.jsp"/>
            <c:import url="menu.jsp"/>
            <div class="conteudo">
                <table style="padding:5px">
                    <tr style="padding:5px">
                        <th style="padding:5px">Ação</th>
                        
                        <th style="padding:5px">Login</th>
                        <th style="padding:5px">Nome</th>
                        <th style="padding:5px">Perfil</th>
                        <th style="padding:5px">Telefone</th>
                    </tr>
                    <%
                        List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
                        if (lista.equals(null)) {
                            response.getWriter().write("null");
                        }
                        for (Usuario usu : lista) {
                    %>
                    <tr style="padding:5px">
                        <td style="padding:5px">
                            <a href="usucontroller.do?acao=ExcluirUsuario&id=<%= usu.getId()%>">Excluir</a>
                            <a href="usucontroller.do?acao=FormAlterarUsuario&id=<%= usu.getId()%>">Editar</a>
                        </td>
                        
                        <td style="padding:5px"><%= usu.getLogin()%></td>
                        <td style="padding:5px"><%= usu.getNome()%></td>
                        <td style="padding:5px"><%= usu.getPerfil()%></td>
                        <td style="padding:5px"><%= usu.getTelefone()%></td>
                    </tr>
                    <%
                        }
                    %>
                    <tr>
                        <td colspan="5"><a href="usucontroller.do?acao=FormCadastroUsuario">Cadastar Novo Usuario</a></td>                    
                    </tr>
                </table>
            </div>
        </div>
        <c:import url="rodape.jsp"/>
    </body>
</html>
