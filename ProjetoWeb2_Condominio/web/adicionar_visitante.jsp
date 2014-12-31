<%-- 
    Document   : adicionar_visitante
    Created on : 09/11/2014, 12:12:56
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
                <title>Adicionar Visitante</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <jsp:useBean id="visi" class="br.com.condominio.jdbc.dao.VisitanteDAO"/>
                        <form action='visitcontroller.do?acao=cadastrar' method='post' name='formulario'>
                            <fieldset>
                                <legend>Cadastro de visitante</legend>
                                <div class="campo">
                                    <label for='nome'>Nome:</label>
                                    <input type='text' id='nome' name='nome' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='numero'>Tipo de Visita:</label>
                                    <input type='text' id='bloco' name='bloco' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='apt'>Apartamento:</label>
                                    <select id="apt" name="apt" style="width:273px" >
                                        <option value="">Selecione</option>
                                        <c:forEach items="${visi.buscarApartamento()}" var="tipo">
                                            <option value="${tipo}">${visi.buscarApartamento(tipo)}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="campo">
                                    <label for='motivo_visita'>Motivo da visita:</label>
                                    <select id="motivo_visita" name="motivo_visita" style="width:273px" >
                                        <option value="">Selecione</option>
                                        <c:forEach items="${visi.buscarTipoVisita()}" var="tipo">
                                            <option value="${tipo}">${visi.buscarTipoVisita(tipo)}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="campo">
                                    <label for='data_hora'>Data e Hora da Visita:</label>
                                    <input type='text' id='data_hora' name='data_hora' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='observacao'>Observação:</label>
                                    <input type='text' id='observacao' name='observacao' value=''/>
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
