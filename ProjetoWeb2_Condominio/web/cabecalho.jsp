<%-- 
    Document   : cabecalho
    Created on : 09/11/2014, 13:44:43
    Author     : João Henrique 2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.com.condominio.entidades.Usuario"%>
<div class="cabecalho">
    <div class="logomarca">
        <a href="index.jsp"><img src="imagens/logo.png" width="420px" height="97px" title="" alt="" border="0"/></a>
    </div>
    <div class="navegacao-usuario">
        <a><img src="imagens/usuario/foto-usuario.png" width="40px" height="40px" title="" alt="" border="0"/></a>
            <c:choose>
                <c:when test="${sessionScope.usuAutenticado != null}">
                <p>Bem vindo, <c:out value="${sessionScope.usuAutenticado.nome}"/></p>
                <a href="usucontroller.do?acao=sair">Sair</a>
            </c:when>            
            <c:otherwise>
                <p>Não logado, <a href="login.jsp">clique para entrar</a></p>
            </c:otherwise>
        </c:choose> 
    </div>
</div>
