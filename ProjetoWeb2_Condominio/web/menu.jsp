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
        <li>
            <c:if test="${sessionScope.usuAutenticado != null}">
                <a href="usucontroller.do?acao=ListarUsuarios">Usu�rios</a>
            </c:if>
        </li>
        <li>
            <c:if test="${sessionScope.usuAutenticado != null}">
                <a href="apartamentos.jsp">Apartamentos</a>
            </c:if>
        </li>
        <li>
            <c:if test="${sessionScope.usuAutenticado != null}">
                <a href="funcionarios.jsp">Funcion�rios</a>
            </c:if>
        </li>
        <li>
            <c:if test="${sessionScope.usuAutenticado != null}">
                <a href="documentos.jsp">Documentos </a>
            </c:if>
        </li>
        <li>
            <c:if test="${sessionScope.usuAutenticado != null}">
                <a href="visitantes.jsp">Visitantes</a>
            </c:if>
        </li>
        <li>
            <c:if test="${sessionScope.usuAutenticado != null}">
                <a href="veiculos.jsp">Ve�culo</a>
            </c:if>
        </li>
    </ul>
</div>