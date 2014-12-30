<%-- 
    Document   : listausuarios
    Created on : 09/11/2014, 00:44:17
    Author     : LOURIVALDO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.com.condominio.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${sessionScope.usuAutenticado != null}">
        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Usuários</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <div class="menu2">
                            <a href="usucontroller.do?acao=forcadastrar">Adicionar usuário</a>
                        </div>
                        <div class="div-table">
                            <div class="div-table-caption">Usuários</div>
                            <div class="div-table-row">
                                <div class="div-table-col">Ação</div>
                                <div class="div-table-col">Login</div>
                                <div class="div-table-col">Nome</div>
                                <div class="div-table-col">Perfil</div>
                                <div class="div-table-col">Telefone</div>
                            </div>
                            <jsp:useBean id="usudao" class="br.com.condominio.jdbc.dao.UsuarioDAO"/>
                            <c:forEach items="${usudao.buscarTodos()}" var="usu">
                                <div class="div-table-row">
                                    <div class="div-table-col">
                                        <a href="usucontroller.do?acao=excluir&id=${usu.id}">Excluir</a>
                                        <a href="usucontroller.do?acao=foreditar&id=${usu.id}">Editar</a>
                                    </div>
                                    <div class="div-table-col">${usu.login}</div>
                                    <div class="div-table-col">${usu.nome}</div>
                                    <div class="div-table-col">${usu.perfil}</div>
                                    <div class="div-table-col">${usu.telefone}</div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <c:import url="rodape.jsp"/>
                </div>
            </body>
        </html>
    </c:when>            
    <c:otherwise>
        <c:redirect url="index.jsp"/>
    </c:otherwise>
</c:choose> 