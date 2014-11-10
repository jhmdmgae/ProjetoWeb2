<%-- 
    Document   : adicionar_veiculo
    Created on : 09/11/2014, 12:11:37
    Author     : João Henrique 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Veículo</title>
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <div class="geral">
            <%@include file="cabecalho.jsp"%>
            <%@include file="menu.jsp"%>
            <div class="conteudo">
                <%@include file="siderbar.jsp"%>
                <form action='' method='post' name='formulario'>
                    <fieldset>
                        <legend>Cadastro de veículo</legend>
                        <div class="campo">
                            <label for='tipo'>Tipo:</label>
                            <input type='text' id='tipo' name='tipo' value=''/>
                        </div>
                        <div class="campo">
                            <label for='marca'>Marca:</label>
                            <input type='text' id='marca' name='marca' value=''/>
                        </div>
                        <div class="campo">
                            <label for='modelo'>Modelo:</label>
                            <input type='text' id='modelo' name='modelo' value=''/>
                        </div>
                        <div class="campo">
                            <label for='numero'>Cor:</label>
                            <input type='text' id='Cor' name='Cor' value=''/>
                        </div>
                        <div class="campo">
                            <label for='placa'>Placa:</label>
                            <input type='text' id='placa' name='placa' value=''/>
                        </div>
                        <div class="campo">
                            <label for='apartamento'>Apartamento:</label>
                            <input type='text' id='apartamento' name='apartamento' value=''/>
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
