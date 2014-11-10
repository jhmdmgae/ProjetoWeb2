<%-- 
    Document   : condominio
    Created on : 09/11/2014, 10:11:21
    Author     : João Henrique 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apartamentos</title>
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <div class="geral">
            <div class="cabecalho">
                <div class="logomarca">
                    <a href="index.jsp"><img src="imagens/logo.png" width="420px" height="97px" title="" alt="" border="0"/></a>
                </div>
                <div class="navegacao-usuario">
                    <a href="login.jsp">Entrar</a>
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="listausuarios.jsp">Usuários</a></li>
                        <li><a href="apartamentos.jsp">Apartamentos</a></li>
                        <li><a href="funcionarios.jsp">Funcionários</a></li>
                        <li><a href="documentos.jsp">Documentos </a></li>
                        <li><a href="visitantes.jsp">Visitantes</a></li>
                        <li><a href="veiculos.jsp">Veículo</a></li>
                    </ul>
                </div>
            </div>
            <div class="conteudo">
                <div class="siderbar">
                     <a><img src="imagens/edificio_sombra.jpg" width="256px" height="256px" title="" alt="" border="0"/></a>
                     <ul>
                        <li>Nome: </li>
                        <li>Blocos</li>
                        <li>Total de apt:</li>
                        <li>Telefone:</li>
                        <li>E-mail:</li>
                    </ul>
                </div>
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
            <div class="rodape">
                <p>Criado por João Henrique e Lourivaldo José</p>
            </div>
        </div>
    </body>
</html>
