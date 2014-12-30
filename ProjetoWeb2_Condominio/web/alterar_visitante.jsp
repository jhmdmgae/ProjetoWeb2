<%-- 
    Document   : adicionar_visitante
    Created on : 09/11/2014, 12:12:56
    Author     : João Henrique 2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${sessionScope.usuAutenticado != null}">
        <c:set var="visitante" value="${requestScope.visitanteAlterar}" />
        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Adicionar Visitante</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <jsp:useBean id="func" class="br.com.condominio.jdbc.dao.VisitanteDAO"/>
                        <form action='visitcontroller.do?acao=editar&id=${visitante.id}' method='post' name='formulario'>
                            <fieldset>
                                <legend>Alterar de visitante</legend>
                                <div class="campo">
                                    <label for='nome'>Nome:</label>
                                    <input type='text' id='nome' name='nome' value='${visitante.nome}'/>
                                </div>
                                <div class="campo">
                                    <label for='tipoVisita'>Tipo de Visita:</label>
                                    <input type='text' id='tipoVisita' name='bloco' value='${visitante.tipoVisita}'/>
                                </div>
                                <div class="campo">
                                    <label for='apartamento'>Apartamento:</label>
                                    <input type='text' id='apartamento' name='apartamento' value='${visitante.apartamento}'/>
                                </div>
                                <div class="campo">
                                    <label for='motivo_visita'>Motivo da visita:</label>
                                    <input type='text' id='motivo_visita' name='motivo_visita' value='${visitante.motivoVisita}'/>
                                </div>
                                <div class="campo">
                                    <label for='data_hora'>Data e Hora da Visita:</label>
                                    <input type='text' id='data_hora' name='data_hora' value='${visitante.dataHora}'/>
                                </div>
                                <div class="campo">
                                    <label for='observacao'>Observação:</label>
                                    <input type='text' id='observacao' name='observacao' value='${visitante.observacao}'/>
                                </div>
                                <div class="campo">
                                    <input type='submit' value="Enviar"/>
                                </div>
                            </fieldset>
                        </form>
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
