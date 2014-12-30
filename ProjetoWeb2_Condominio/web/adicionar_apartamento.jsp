<%-- 
    Document   : adicionar_apartamento
    Created on : 09/11/2014, 12:12:03
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
                        <c:import url="siderbar.jsp"/>
                        <form action='condocontroller.do?acao=CadastrarApartamento' method='post' name='formulario'>
                            <fieldset>
                                <legend>Cadastro de apartamento</legend>
                                <div class="campo">
                                    <label for='numero'>Número:</label>
                                    <input type='text' id='numero' name='numero' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='numero'>Bloco:</label>
                                    <input type='text' id='bloco' name='bloco' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='numero'>Proprietário:</label>
                                    <input type='text' id='proprietario' name='proprietario' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='numero'>Locatário:</label>
                                    <input type='text' id='locatario' name='locatario' value=''/>
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