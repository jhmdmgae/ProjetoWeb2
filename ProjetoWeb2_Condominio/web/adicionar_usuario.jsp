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
        <title>Cadastrar Usuário</title>
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <div class="geral">
            <c:import url="cabecalho.jsp"/>
            <c:import url="menu.jsp"/>
            <div class="conteudo">
                <form method="POST" action="usucontroller.do?acao=CadastrarUsuario">
                    <div class="campo">
                        <label for='login'>Login:</label>
                        <input type="email" id="login" name="login" value="" />
                    </div>
                    <div class="campo">
                        <label for='senha'>Senha:</label>
                        <input type="password" id="senha" name="senha" value="" />
                    </div>
                    <div class="campo">
                        <label for='confirmar'>Confirmar senha:</label>
                        <input type="password" id="confirmar" name="confirmar" value="" />
                    </div>
                    <div class="campo">
                        <label for='nome'>Nome:</label>
                        <input type="text" id="nome" name="nome" value="" />
                    </div>
                    <div class="campo">
                        <label for='telefone'>Telefone:</label>
                        <input type="tel" id="telefone" name="telefone" value="" />
                    </div>

                    <div class="campo">
                        <label for="perfil">Perfil:</label>
                        <select id="perfil" name="perfil" >
                            <!--caso haja uma sessão em que o usuario e administrador-->
                            <c:if test="${sessionScope.usuAutenticado.perfil.equalsIgnoreCase('administrador')}">
                                <option>Administrador</option>
                            </c:if>
                            <option>Sindico</option>
                            <option>Morador</option>
                        </select>
                    </div>
                    <input type="submit" value="cadastrar" />           
                </form>
                <c:import url="rodape.jsp"/>
            </div>
    </body>
</html>

