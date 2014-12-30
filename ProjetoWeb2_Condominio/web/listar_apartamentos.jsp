<%-- 
    Document   : apartamentos
    Created on : 09/11/2014, 10:14:40
    Author     : João Henrique 2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${sessionScope.usuAutenticado != null}">
        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Apartamentos</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <div class="menu2">
                            <a href="usucontroller.do?acao=FormCadastroApartamento">Adicionar Apartamento</a>
                        </div>
                        <div class="div-table">
                            <div class="div-table-caption">Apartamentos</div>
                            <div class="div-table-row">
                                <div class="div-table-col">Ação</div>
                                <div class="div-table-col">Número</div>
                                <div class="div-table-col">Bloco</div>
                                <div class="div-table-col">Proprietário</div>
                                <div class="div-table-col">Locatário</div>
                            </div>
                            <jsp:useBean id="aparts" class="br.com.condominio.jdbc.ApartamentoDAO"/>
                            <c:forEach items="${aparts.buscarTodos()}" var="apt">
                                <div class="div-table-row">
                                    <div class="div-table-col">
                                        <a href="condocontroller.do?acao=ExcluirApartamento&id=${apt.id}">Excluir</a>
                                        <a href="condocontroller.do?acao=FormAlterarApartamento&id=${apt.id}">Editar</a>
                                    </div>
                                    <div class="div-table-col">${apt.numero}</div>
                                    <div class="div-table-col">${apt.bloco}</div>
                                    <div class="div-table-col">${apt.proprietario}</div>
                                    <div class="div-table-col">${apt.locatario}</div>
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