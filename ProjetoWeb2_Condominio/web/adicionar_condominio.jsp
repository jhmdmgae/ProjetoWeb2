<%-- 
    Document   : adicionar_condominio
    Created on : 30/12/2014, 21:14:13
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
                <title>Condominios</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <c:import url="siderbar.jsp"/>
                        <form action='condocontroller.do?acao=cadastrar' method='post' name='formulario'>
                            <fieldset>
                                <legend>Cadastro de condominio</legend>
                                <div class="campo">
                                    <label for='cnpj'>Número:</label>
                                    <input type='text' id='cnpj' name='cnpj' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='nome'>Bloco:</label>
                                    <input type='text' id='nome' name='nome' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='cep'>Proprietário:</label>
                                    <input type='text' id='cep' name='cep' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='endereco'>Locatário:</label>
                                    <input type='text' id='endereco' name='endereco' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='numero'>Número:</label>
                                    <input type='text' id='numero' name='numero' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='complemento'>Complemento:</label>
                                    <input type='text' id='complemento' name='complemento' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='bairro'>Bairro:</label>
                                    <input type='text' id='bairro' name='bairro' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='uf'>UF:</label>
                                    <input type='text' id='uf' name='uf' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='cidade'>Cidade:</label>
                                    <input type='text' id='cidade' name='cidade' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='quantBlocos'>Quantidade de blocos:</label>
                                    <input type='text' id='quantBlocos' name='quantBlocos' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='quantApt'>Quantidade de apts:</label>
                                    <input type='text' id='quantApt' name='quantApt' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='foto'>Foto:</label>
                                    <input type='text' id='foto' name='foto' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='telefone'>Telefone:</label>
                                    <input type='text' id='telefone' name='telefone' value=''/>
                                </div>
                                <div class="campo">
                                    <label for='email'>Email:</label>
                                    <input type='text' id='email' name='email' value=''/>
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
