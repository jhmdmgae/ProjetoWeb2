<%-- 
    Document   : veiculos.jsp
    Created on : 09/11/2014, 10:13:42
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
                <title>Veículos</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <div class="menu2">
                            <a href="veiccontroller.do?acao=forcadastrar">Adicionar Veículo</a>
                        </div>
                        <div class="div-table">
                            <div class="div-table-caption">Veículos</div>
                            <div class="div-table-row">
                                <div class="div-table-col">Ação</div>
                                <div class="div-table-col">Tipo</div>
                                <div class="div-table-col">Marca</div>
                                <div class="div-table-col">Modelo</div>
                                <div class="div-table-col">Cor</div>
                                <div class="div-table-col">Placa</div>
                                <div class="div-table-col">Apartamento</div>
                            </div>
                            <jsp:useBean id="veicdao" class="br.com.condominio.jdbc.dao.VeiculoDAO"/>
                            <c:forEach items="${veicdao.buscarTodos()}" var="veic">
                                <div class="div-table-row">
                                    <div class="div-table-col">
                                        <a href="veiccontroller.do?acao=excluir&id=${veic.id}">Excluir</a>
                                        <a href="veiccontroller.do?acao=foreditar&id=${veic.id}">Editar</a>
                                    </div>
                                    <div class="div-table-col">${veic.tipoVeiculo}</div>
                                    <div class="div-table-col">${veic.marca}</div>
                                    <div class="div-table-col">${veic.modelo}</div>
                                    <div class="div-table-col">${veic.cor}</div>
                                    <div class="div-table-col">${veic.placa}</div>
                                    <div class="div-table-col">${veic.apartamento}</div>
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