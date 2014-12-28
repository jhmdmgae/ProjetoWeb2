<%-- 
    Document   : index
    Created on : 09/11/2014, 09:38:09
    Author     : João Henrique 2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <div class="geral">
            <c:import url="cabecalho.jsp"/>
            <c:import url="menu.jsp"/>
            <div class="conteudo">
                
                <p>O Condomio é um Sistema Web muito útil para gestão de condomínios. Planejado para os mais diversos usuários como o síndico, moradores, porteiro e funcionários com restrinção de acesso de acordo com o perfil do usuário.
                    Com ele é possível cadastrar encomendas, visitantes, funcionários, veículos entre tantas outras informações relevantes para uma gestão eficiente e segura dos condominios tanto pequenos quanto grandes.</p>
                <br />
                <p>Cadastre uma nova conta incluindo as informações do seu condomínio nesse <a href="login.jsp"><strong>Link</strong></a></p>
            </div>
            <c:import url="rodape.jsp"/>
        </div>
    </body>
</html>
