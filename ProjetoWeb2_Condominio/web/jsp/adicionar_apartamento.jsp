<%-- 
    Document   : adicionar_apartamento
    Created on : 09/11/2014, 12:12:03
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
                <form action='' method='post' name='formulario'>
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
            <%@include file="rodape.jsp"%>
        </div>
    </body>
</html>
