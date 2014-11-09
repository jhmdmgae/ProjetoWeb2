<%-- 
    Document   : visitantes
    Created on : 09/11/2014, 10:14:01
    Author     : João Henrique 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitantes</title>
        <link type="text/css" rel="stylesheet" href="../css/estilo.css" />
    </head>
    <body>
        <div class="geral">
            <%@include file="cabecalho.jsp"%>
            <%@include file="menu.jsp"%>
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
