<%-- 
    Document   : 
    Created on : 09/11/2014, 00:44:17
    Author     : LOURIVALDO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.com.condominio.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${sessionScope.usuAutenticado != null}">
        <c:set var="usuario" value="${requestScope.usuarioAlterar}" />
        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Adicionar usuário</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <!--***************************** Alterar passagem de senha e verificaçao null-->
                        <div>
                            <form method="POST" action="usucontroller.do?acao=alterar&id=${usuario.id}">
                                <fieldset>
                                    <legend>Cadastro de Funcionário</legend>
                                    <div class="campo">
                                        <label for='login'>Login:</label>
                                        <input type="email" id="login" name="login" value="${usuario.login}" />
                                    </div>
                                    <div class="campo">
                                        <label for='senhaAtual'>Senha Atual:</label>
                                        <input type="password" id="senhaAtual" name="senhaAtual" value="1234" />
                                    </div>
                                    <div class="campo">
                                        <label for='senha'>Nova Senha:</label>
                                        <input type="password" id="senha" name="senha" value="1234" />
                                    </div>
                                    <div class="campo">
                                        <label for='confirmar'>Confirmar Senha:</label>
                                        <input type="password" id="confirmar" name="confirmar" value="1234" />
                                    </div>
                                    <div class="campo">
                                        <label for='nome'>Nome:</label>
                                        <input type="text" id="nome" name="nome" value="${usuario.nome}" />
                                    </div>
                                    <div class="campo">
                                        <label for='telefone'>Telefone:</label>
                                        <input type="text" id="telefone" name="telefone" value="${usuario.telefone}" />
                                    </div>
                                    <jsp:useBean id="usua" class="br.com.condominio.jdbc.dao.UsuarioDAO"/>
                                    <div class="campo">
                                        <label for='condominio'>Condominio:</label>
                                        <select id="condominio" name="condominio" style="width:273px" >
                                            <option value="">Selecione</option>
                                            <c:forEach items="${usua.buscarCondominio()}" var="nome">
                                                <option value="${nome}">${usua.buscarCondominio(nome)}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="campo">
                                        <label for='perfil'>Perfil:</label>
                                        <select id="perfil" name="perfil" >
                                            <c:if test="${usuario.perfil.equalsIgnoreCase('administrador')}">
                                                <option>Administrador</option>
                                            </c:if>
                                            <c:choose>
                                                <c:when test="${usuario.perfil.equalsIgnoreCase('Sindico') }">
                                                    <option selected="selected">Sindico</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option>Sindico</option>
                                                </c:otherwise>
                                            </c:choose>
                                            <c:choose>
                                                <c:when test="${usuario.perfil.equalsIgnoreCase('Morador') }">
                                                    <option selected="selected">Morador</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option>Morador</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </select>
                                    </div>
                                    <div class="campo">
                                        <input type="submit" value="Alterar" /> 
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                        <c:import url="rodape.jsp"/>
                    </div>
                </div>
            </body>
        </html>
    </c:when>            
    <c:otherwise>
        <c:redirect url="index.jsp"/>
    </c:otherwise>
</c:choose> 