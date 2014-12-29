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
                <a href="usucontroller.do?acao=ListarUsuarios">Usuários</a>
            </li>
            <li>
                <a href="condocontroller.do?acao=ListarApartamentos">Apartamentos</a>
            </li>
            <li>
                <a href="funcionarios.jsp">Funcionários</a>
            </li>
            <li>
                <a href="documentos.jsp">Documentos </a>
            </li>
            <li>
                <a href="visitantes.jsp">Visitantes</a>
            </li>
            <li>
                <a href="veiculos.jsp">Veículo</a>
            </li>
        </c:if>
    </ul>
</div>