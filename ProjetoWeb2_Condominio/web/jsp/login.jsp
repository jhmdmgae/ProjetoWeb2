<%-- 
    Document   : index
    Created on : 22/10/2014, 10:54:00
    Author     : LOURIVALDO
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link type="text/css" rel="stylesheet" href="css/estilo_form.css" />
        <title>JSP Acesso Sistema</title>
    </head>
    <body>
        <form action='usucontroller.do' method='post' name='formulario'>
            <fieldset>
                <legend>Acesso</legend>
                <label for='login'>Login:</label>
                <input type='text' id='login' name='login' value='Loro'/><br/>
                <label for='senha'>Senha:</label>
                <input type='password' id='senha' name='senha' value='123'/><br/>
                <a href="html/esqueceu.html">esqueceu sua senha ?</a><br/>
                <input type='submit' value="Entrar"/>
            </fieldset>
        </form>
    </body>
</html>