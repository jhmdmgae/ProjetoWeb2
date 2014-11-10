<%-- 
    Document   : index
    Created on : 22/10/2014, 10:54:00
    Author     : LOURIVALDO
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<form action='usucontroller.do?acao=LogarSistema' method='post' name='formulario'>
    <div >
        <label for='login'>Login:</label>
        <input type='email' id='login' name='login' value='loro.vasconcelos@gmail.com'/>
        <label for='senha'>Senha:</label>
        <input type='password' id='senha' name='senha' value='1234'/>
        <input type='submit' value="Entrar"/>
        <div>
            <a href="usucontroller.do?acao=FormPedidoSenha">Esqueceu a senha ?</a><br/>
            <a href="#">Cadastre seu condomínio</a><br>
            <a href="usucontroller.do?acao=FormCadastroUsuario">Não é cadastrado ?</a>
        </div>
    </div>
</form>