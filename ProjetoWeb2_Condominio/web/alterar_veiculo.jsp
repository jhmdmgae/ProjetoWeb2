<%-- 
    Document   : adicionar_veiculo
    Created on : 09/11/2014, 12:11:37
    Author     : João Henrique 2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${sessionScope.usuAutenticado != null}">
        <c:set var="veiculo" value="${requestScope.veiculoAlterar}" />
        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Adicionar Veículo</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <jsp:useBean id="veic" class="br.com.condominio.jdbc.dao.VeiculoDAO"/>
                        <form action='veiccontroller.do?acao=alterar&id=${veiculo.id}' method='post' name='formulario'>
                            <fieldset>
                                <legend>Cadastro de veículo</legend>
                                <div class="campo">
                                    <label for='tipo'>Tipo:</label>
                                    <select id="numero" name="tipo" style="width:273px" >
                                        <option value="">Selecione</option>
                                        <c:forEach items="${veic.buscarTipoVeiculo()}" var="tipo">
                                            <option value="1">${tipo}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="campo">
                                    <label for='marca'>Marca:</label>
                                    <input type='text' id='marca' name='marca' value='${veiculo.marca}'/>
                                </div>
                                <div class="campo">
                                    <label for='modelo'>Modelo:</label>
                                    <input type='text' id='modelo' name='modelo' value='${veiculo.modelo}'/>
                                </div>
                                <div class="campo">
                                    <label for='cor'>Cor:</label>
                                    <select id="cor" name="cor" style="width:273px" >
                                        <option value="">Selecione</option>
                                        <c:forEach items="${veic.buscarCor()}" var="cor">
                                            <option value="1">${cor}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="campo">
                                    <label for='placa'>Placa:</label>
                                    <input type='text' id='placa' name='placa' value='${veiculo.placa}'/>
                                </div>
                                <div class="campo">
                                    <label for='apartamento'>Apartamento:</label>
                                    <input type='text' id='apartamento' name='apartamento' value='${veiculo.apartamento}'/>
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
