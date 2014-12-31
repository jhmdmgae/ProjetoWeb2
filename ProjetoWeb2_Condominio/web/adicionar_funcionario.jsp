<%-- 
    Document   : adicionar_funcionario
    Created on : 09/11/2014, 15:35:00
    Author     : João Henrique 2
--%>
<!--#############################333333Upload de fotos-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${sessionScope.usuAutenticado != null}">
        <c:set var="funcionario" value="${requestScope.funcionarioAlterar}" />
        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Adicionar Funcionário</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <form action='funccontroller.do?acao=cadastrar' method='post' name='formulario'>
                            <fieldset>
                                <legend>Cadastro de Funcionário</legend>
                                <div class="campo">
                                    <label for='matricula'>Matrícula:</label>
                                    <input type='text' id='matricula' name='matricula' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='nome'>Nome:</label>
                                    <input type='text' id='nome' name='nome' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='telefone_residencial'>Telefone Residencial:</label>
                                    <input type='text' id='telefone_residencial' name='telefone_residencial' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='telefone_celular'>Telefone Celular:</label>
                                    <input type='text' id='telefone_celular' name='telefone_celular' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='cep'>CEP:</label>
                                    <input type='text' id='cep' name='cep' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='endereco'>Endereço:</label>
                                    <input type='text' id='endereco' name='endereco' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='numero'>Número:</label>
                                    <input type='text' id='numero' name='numero' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='complemento'>Complemento:</label>
                                    <input type='text' id='complemento' name='complemento' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='bairro'>Bairro:</label>
                                    <input type='text' id='bairro' name='bairro' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='cidade'>Cidade:</label>
                                    <input type='text' id='cidade' name='cidade' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='uf'>UF:</label>
                                    <input type='text' id='uf' name='uf' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='rg'>RG:</label>
                                    <input type='text' id='rg' name='rg' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='cpf'>CPF:</label>
                                    <input type='text' id='cpf' name='cpf' value='' size="41"/>
                                </div>
                                <div class="campo">
                                    <label for='sexo'>Sexo:</label>
                                    <select id="tipo" name="sexo" style="width:273px" >
                                        <option value="">Selecione</option>
                                        <option value="1">M</option>
                                        <option value="1">F</option>
                                    </select>
                                </div>
                                <div class="campo">
                                    <label for='data_contratacao'>Data Contratação:</label>
                                    <input type='date' id='data_contratacao' name='data_contratacao' value='' size="41"/>
                                </div>
                                <jsp:useBean id="func" class="br.com.condominio.jdbc.dao.FuncionarioDAO"/>
                                <div class="campo">
                                    <label for='cargo'>Cargo:</label>
                                    <select id="cargo" name="cargo" style="width:273px" >
                                        <option value="">Selecione</option>
                                        <c:forEach items="${func.buscarCargo()}" var="cargo">
                                            <option value="${cargo}">${func.buscarCargo(cargo)}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="campo">
                                    <label for='tipo_contrato'>Tipo de Contrato:</label>
                                    <select id="tipo_contrato" name="tipo_contrato" style="width:273px" >
                                        <option value="">Selecione</option>
                                        <c:forEach items="${func.buscarTipoContrato()}" var="tipo">
                                           <option value="${tipo}">${func.buscarTipoContrato(tipo)}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="campo">
                                    <label for='turno'>Turno:</label>
                                    <select id="turno" name="turno" style="width:273px" >
                                        <option value="">Selecione</option>
                                        <c:forEach items="${func.buscarTurno()}" var="turno">
                                            <option value="${turno}">${func.buscarTurno(turno)}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="campo">
                                    <label for='foto'>Foto:</label>
                                    <input type='file' id='foto' name='foto' value='' size="39"/>
                                </div>
                                <div class="campo">
                                    <label for='observacao'>Observação:</label>
                                    <textarea id="observacao" name="observacao" Style="width: 267px;height: 100px;" ></textarea>
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
