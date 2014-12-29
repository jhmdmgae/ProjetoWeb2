<%-- 
    Document   : visitantes
    Created on : 09/11/2014, 10:14:01
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
                <title>Visitantes</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <div class="menu2">
                            <a href="adicionar_visitante.jsp">Adicionar visitante</a>
                        </div>
                        <div class="div-table">
                            <div class="div-table-caption">Visitantes</div>
                            <div class="div-table-row">
                                <div class="div-table-col">Nome</div>
                                <div class="div-table-col">Tipo de Visita</div>
                                <div class="div-table-col">Apartamento</div>
                                <div class="div-table-col">Data e Hora da Visita</div>
                            </div>
                            <jsp:useBean id="visidao" class="br.com.condominio.jdbc.VisitanteDAO"/>
                            <c:forEach items="${visidao.buscarTodos()}" var="visi">
                                <div class="div-table-row">
                                    <div class="div-table-col">${visi.nome}</div>
                                    <div class="div-table-col">${visi.tipo_visita}</div>
                                    <div class="div-table-col">${visi.apartamento}</div>
                                    <div class="div-table-col">${visi.data_hora}</div>
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