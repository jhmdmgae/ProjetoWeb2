<%-- 
    Document   : siderbar
    Created on : 09/11/2014, 13:39:27
    Author     : João Henrique 2
--%>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <div class="siderbar">
                    <jsp:useBean id="cond" class="br.com.condominio.jdbc.dao.CondominioDAO"/>
                    <%@page import="br.com.condominio.entidades.Usuario"%>
                    
                    <a><img src="imagens/condominios/${cond.buscar(1).foto}" width="256px" height="256px" title="" alt="" border="0"/></a>
                    <ul>
                        <li>Nome: ${cond.buscar(1).nome}</li>
                        <li>Blocos: ${cond.buscar(1).quantBlocos}</li>
                        <li>Total de apt: ${cond.buscar(1).quantApt}</li>
                        <li>Telefone: ${cond.buscar(1).telefone}</li>
                        <li>E-mail: ${cond.buscar(1).email}</li>
                        ${sessionScope.usuAutenticado.login}
                    </ul>
                </div>
