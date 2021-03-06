<%-- 
    Document   : adicionar_documento
    Created on : 09/11/2014, 13:51:02
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
                <title>Adicionar documento</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <jsp:useBean id="doc" class="br.com.condominio.jdbc.dao.DocumentoDAO"/>
                        <form action='doccontroller.do?acao=cadastrar' method='post' name='formulario'>
                            <fieldset>
                                <legend>Cadastro de documento</legend>
                                <div class="campo">
                                    <label for='numero'>Título:</label>
                                    <input type='text' id='numero' name='numero' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='descricao'>Descrição:</label>
                                    <textarea id="descricao" name="descricao" Style="width: 267px;height: 100px;" ></textarea>
                                </div>
                                <div class="campo">
                                    <label for='categoria'>Categoria:</label>
                                    <select id="categoria" name="categoria" style="width:273px" >
                                        <option value="">Selecione</option>
                                        <c:forEach items="${doc.buscarCategoria()}" var="doc">
                                            <option value="1">${doc}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="campo">
                                    <label for='autor'>Autor:</label>
                                    <select id="autor" name="autor" style="width:273px" >
                                        <option value="">Selecione</option>
                                        <c:forEach items="${doc.buscarAutor()}" var="autor">
                                            <option value="1">${autor}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="campo">
                                    <label for='arquivo'>Arquivo:</label>
                                    <input type='file' id='arquivo' name='arquivo' value='' size="39"/>
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