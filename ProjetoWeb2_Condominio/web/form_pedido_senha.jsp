<%-- 
    Document   : formulario_email
    Created on : 09/11/2014, 10:27:44
    Author     : LOURIVALDO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Recuperar Login</title>
    </head>
    <body>
        <form name="formulario_email" method="post" action="usucontroller.do?acao=EnviarEmailSenha">  
            <h1 align="center">Recuperar Login</h1>
            <h4 align="center">
                Digite no campo abaixo o e-mail/login que você cadastrou anteriormente  
                para receber um formulário de redefinição de senha por e-mail.
            </h4>
            <div>
                <label for="email">Login/E-mail: </label>
                <input name="email" id="email" type="email" size="50" value="" onkeyup="limpar()"/>
                <c:if test="${(msg != null) && !msg.equals('')}">
                    <span style="color:red;" id="erroemail"><c:out value="${msg}"/></span>
                </c:if>
            </div>
            <script type="text/javascript">
                function limpar() {
                    var element = document.getElementById("erroemail");
                    element.parentNode.removeChild(element);
                }
            </script>
            <input type="submit" name="op" value="Enviar" /> 
            <input name="reset" type="reset" id="reset" value="Voltar" onClick="location.href = 'login.jsp'" />  
        </form>  
    </body>
</html>
