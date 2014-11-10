<%-- 
    Document   : index
    Created on : 22/10/2014, 10:54:00
    Author     : LOURIVALDO
--%>

<%@ page import = "javax.servlet.RequestDispatcher" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link type="text/css" rel="stylesheet" href="../css/estilo.css" />
    </head>
    <body>
        <div class="geral">
            <%@include file="cabecalho.jsp"%>
            <%@include file="menu.jsp"%>
            <div class="conteudo">
                <form action='usucontroller.do' method='post' name='formulario'>
                    <fieldset>
                        <legend>Acesso</legend>
                        <div class="campo">
                            <label for='login'>Login:</label>
                            <input type='text' id='login' name='login' value='Loro'/>
                        </div>
                        <div class="campo">
                            <label for='senha'>Senha:</label>
                            <input type='password' id='senha' name='senha' value='123'/>
                        </div>
                        <div class="campo">
                            <a href="html/esqueceu.html">esqueceu sua senha?</a>
                        </div>
                        <div class="campo">
                            <input type='submit' value="Entrar"/>
                        </div>
                    </fieldset>
                </form>
            </div>
            <%@include file="rodape.jsp"%>
        </div>
    </body>
</html>