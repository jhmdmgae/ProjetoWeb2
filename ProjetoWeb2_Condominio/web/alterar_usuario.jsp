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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar usuário</title>
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <div class="geral">
            <%@include file="cabecalho.jsp"%>
            <%@include file="menu.jsp"%>
            <div class="conteudo">
                <%
                    Usuario usu = (Usuario) request.getAttribute("usuarioAlterar");
                %>
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
                <%@include file="rodape.jsp"%>
            </div>
    </body>
</html>
