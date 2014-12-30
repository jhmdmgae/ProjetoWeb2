<%-- 
    Document   : menu
    Created on : 09/11/2014, 13:33:22
    Author     : João Henrique 2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">
    <ul>
        <li>
            <a href="index.jsp">Home</a>
        </li>
        <c:if test="${sessionScope.usuAutenticado != null}">
            <li>
                <a href="usucontroller.do?acao=listar">Usuários</a>
            </li>
            <li>
                <a href="apartcontroller.do?acao=ListarApartamentos">Apartamentos</a>
            </li>
            <li>
                <a href="condocontroller.do?acao=ListarFuncionarios">Funcionários</a>
            </li>
            <li>
                <a href="condocontroller.do?acao=ListarDocumentos">Documentos </a>
            </li>
            <li>
                <a href="listar_visitantes.jsp">Visitantes</a>
            </li>
            <li>
                <a href="listar_veiculos.jsp">Veículo</a>
            </li>
        </c:if>
    </ul>
</div>