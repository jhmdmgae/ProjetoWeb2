<%-- 
    Document   : funcionarios
    Created on : 09/11/2014, 10:14:29
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
                <title>Funcionários</title>
                <link type="text/css" rel="stylesheet" href="css/estilo.css" />
            </head>
            <body>
                <div class="geral">
                    <c:import url="cabecalho.jsp"/>
                    <c:import url="menu.jsp"/>
                    <div class="conteudo">
                        <%@include file="siderbar.jsp"%>
                        <div class="menu2">
                            <a href="condocontroller.do?acao=FormCadastroFuncionario">Adicionar funcionario</a>
                        </div>
                        <div class="div-table">
                            <div class="div-table-caption">Funcionários</div>
                            <div class="div-table-row">
                                <div class="div-table-col">Ação</div>
                                <div class="div-table-col">Foto</div>
                                <div class="div-table-col">Matrícula</div>
                                <div class="div-table-col">Nome</div>
                                <div class="div-table-col">Sexo</div>
                                <div class="div-table-col">Cargo</div>
                                <div class="div-table-col">Turno</div>
                            </div>
                            <jsp:useBean id="funcdao" class="br.com.condominio.jdbc.dao.FuncionarioDAO"/>
                            <c:forEach items="${funcdao.buscarTodos()}" var="func">
                                <div class="div-table-row">
                                    <div class="div-table-col">
                                        <a href="condocontroller.do?acao=ExcluirFuncionario&id=${func.id}">Excluir</a>
                                        <a href="condocontroller.do?acao=FormAlterarFuncionario&id=${func.id}">Editar</a>
                                    </div>
                                    <div class="div-table-col">${func.foto}</div>
                                    <div class="div-table-col">${func.matricula}</div>
                                    <div class="div-table-col">${func.nome}</div>
                                    <div class="div-table-col">${func.sexo}</div>
                                    <div class="div-table-col">${func.cargo}</div>
                                    <div class="div-table-col">${func.turno}</div>
                                </div>
                            </c:forEach>
                        </div>
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