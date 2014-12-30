<%-- 
    Document   : documentos
    Created on : 09/11/2014, 10:14:12
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
                <title>Documentos</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <div class="menu2">
                            <a href="doccontroller.do?acao=forcadastrar">Adicionar documento</a>
                        </div>
                        <div class="div-table">
                            <div class="div-table-caption">Documentos</div>
                            <div class="div-table-row">
                                <div class="div-table-col">Ação</div>
                                <div class="div-table-col">Título</div>
                                <div class="div-table-col">Descrição</div>
                                <div class="div-table-col">Categorias</div>
                                <div class="div-table-col">Autor</div>
                                <div class="div-table-col">Arquivo</div>
                            </div>
                            <jsp:useBean id="docdao" class="br.com.condominio.jdbc.dao.DocumentoDAO"/>
                            <c:forEach items="${docdao.buscarTodos()}" var="doc">
                                <div class="div-table-row">
                                    <div class="div-table-col">
                                        <a href="doccontroller.do?acao=excluir&id=${doc.id}">Excluir</a>
                                        <a href="doccontroller.do?acao=foreditar&id=${doc.id}">Editar</a>
                                    </div>
                                    <div class="div-table-col">${doc.titulo}</div>
                                    <div class="div-table-col">${doc.descricao}</div>
                                    <div class="div-table-col">${doc.categoria}</div>
                                    <div class="div-table-col">${doc.autor}</div>
                                    <div class="div-table-col">${doc.arquivo}</div>
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