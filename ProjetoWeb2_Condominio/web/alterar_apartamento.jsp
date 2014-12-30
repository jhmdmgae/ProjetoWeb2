<%-- 
    Document   : alterar_apartamento
    Created on : 23/12/2014, 22:12:03
    Author     : Lourivaldo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${sessionScope.usuAutenticado != null}">
        <c:set var="apartamento" value="${requestScope.apartamentoAlterar}" />
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
                        <c:import url="siderbar.jsp"/>
                        <form action='condocontroller.do?acao=AlterarApartamento&id=${apartamento.id}' method='post' name='formulario'>
                            <fieldset>
                                <legend>Alteração de apartamento</legend>
                                <div class="campo">
                                    <label for='numero'>Número:</label>
                                    <input type='text' id='numero' name='numero' value='${apartamento.numero}'/>
                                </div>
                                <div class="campo">
                                    <label for='numero'>Bloco:</label>
                                    <input type='text' id='bloco' name='bloco' value='${apartamento.bloco}'/>
                                </div>
                                <div class="campo">
                                    <label for='numero'>Proprietário:</label>
                                    <input type='text' id='proprietario' name='proprietario' value='${apartamento.proprietario}'/>
                                </div>
                                <div class="campo">
                                    <label for='numero'>Locatário:</label>
                                    <input type='text' id='locatario' name='locatario' value='${apartamento.locatario}'/>
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