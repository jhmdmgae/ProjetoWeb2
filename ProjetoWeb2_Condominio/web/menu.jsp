<%-- 
    Document   : menu
    Created on : 09/11/2014, 13:33:22
    Author     : Jo�o Henrique 2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">
    <ul>
        <li>
            <a href="index.jsp">Home</a>
        </li>
        <c:if test="${sessionScope.usuAutenticado != null}">
            <li>
                <a href="usucontroller.do?acao=listar">Usu�rios</a>
            </li>
            <li>
                <a href="apartcontroller.do?acao=ListarApartamentos">Apartamentos</a>
            </li>
            <li>
                <a href="funccontroller.do?acao=listar">Funcion�rios</a>
            </li>
            <li>
                <a href="doccontroller.do?acao=ListarDocumentos">Documentos</a>
            </li>
            <li>
                <a href="visitcontroller.do?acao=ListarVisitantes">Visitantes</a>
            </li>
            <li>
                <a href="veiccontroller.do?acao=ListarVeiculos">Ve�culo</a>
            </li>
        </c:if>
    </ul>
</div>