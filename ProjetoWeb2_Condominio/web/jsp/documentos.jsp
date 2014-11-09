<%-- 
    Document   : documentos
    Created on : 09/11/2014, 10:14:12
    Author     : João Henrique 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Documentos</title>
        <link type="text/css" rel="stylesheet" href="../css/estilo.css" />
    </head>
    <body>
        <div class="geral">
            <%@include file="cabecalho.jsp"%>
            <%@include file="menu.jsp"%>
            <div class="conteudo">
                <%@include file="siderbar.jsp"%>
                <div class="menu2">
                    <a href="adicionar_documento.jsp">Adicionar documento</a>
                </div>
                <div class="div-table">
                    <div class="div-table-caption">Documentos</div>
                    <div class="div-table-row">
                        <div class="div-table-col">Título</div>
                        <div class="div-table-col">Descrição</div>
                        <div class="div-table-col">Categorias</div>
                        <div class="div-table-col">Autor</div>
                        <div class="div-table-col">Arquivo</div>
                    </div>
                    <div class="div-table-row">
                        <div class="div-table-col">1</div>
                        <div class="div-table-col">2</div>
                        <div class="div-table-col">3</div>
                        <div class="div-table-col">4</div>
                        <div class="div-table-col">5</div>
                    </div>
                </div>
            </div>
            <%@include file="rodape.jsp"%>
        </div>
    </body>
</html>
