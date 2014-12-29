<%-- 
    Document   : 
    Created on : 09/11/2014, 00:44:17
    Author     : LOURIVALDO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:import url="cabecalho.jsp"/>
            <c:import url="menu.jsp"/>
            <div class="conteudo">
                <form method="POST" action="usucontroller.do?acao=CadastrarUsuario">
                    <label for='login'>Login:</label>
                    <input type="email" name="login" value="" /><br />
                    <label for='senha'>Senha:</label>
                    <input type="password" name="senha" value="" /><br />
                    <label for='confirmar'>Confirmar senha:</label>
                    <input type="password" name="confirmar" value="" /><br />
                    <label for='nome'>Nome:</label>
                    <input type="text" name="nome" value="" /><br />
                    <label for='telefone'>Telefone:</label>
                    <input type="tel" name="telefone" value="" /><br />
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
                <c:import url="rodape.jsp"/>
            </div>
    </body>
</html>

