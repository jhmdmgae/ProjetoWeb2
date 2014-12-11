<%-- 
    Document   : nova_senha
    Created on : 09/11/2014, 14:47:44
    Author     : LOURIVALDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>-->
<form name="alterarsenha" action="usucontroller.do?acao=AlterarSenha&email=<%=request.getAttribute("email")%>&cod=<%=request.getAttribute("cod")%>" method="POST">
    <label for="senha">Nova senha: </label><input type="password" id="senha" name="senha" value="123" size="45" /><br/>
    <label for="confirma" >Confirmar senha: </label><input type="password" id="confirma"  name="confirma" value="123" size="45" />
    <input type="submit" value="Alterar" name="alterar" />
</form>
<!--    </body>
</html>-->
