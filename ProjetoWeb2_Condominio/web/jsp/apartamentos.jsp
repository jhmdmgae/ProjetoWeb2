<%-- 
    Document   : apartamentos
    Created on : 09/11/2014, 10:14:40
    Author     : João Henrique 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apartamentos</title>
        <link type="text/css" rel="stylesheet" href="../css/estilo.css" />
    </head>
    <body>
        <div class="geral">
            <%@include file="cabecalho.jsp"%>
            <%@include file="menu.jsp"%>
            <div class="conteudo">
                <%@include file="siderbar.jsp"%>
                <div class="menu2">
                    <a href="adicionar_apartamento.jsp">Adicionar Apartamento</a>
                </div>
                <div class="div-table">
                    <div class="div-table-caption">Apartamentos</div>
                    <div class="div-table-row">
                        <div class="div-table-col">Número</div>
                        <div class="div-table-col">Bloco</div>
                        <div class="div-table-col">Proprietário</div>
                        <div class="div-table-col">Locatário</div>
                    </div>
                    <div class="div-table-row">
                        <div class="div-table-col">1</div>
                        <div class="div-table-col">2</div>
                        <div class="div-table-col">3</div>
                        <div class="div-table-col">4</div>
                    </div>
                </div>
            </div>
            <%@include file="rodape.jsp"%>
        </div>
    </body>
</html>
