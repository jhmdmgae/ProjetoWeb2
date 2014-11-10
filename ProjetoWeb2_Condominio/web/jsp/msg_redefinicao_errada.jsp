<%-- 
    Document   : msg_redefinicao
    Created on : 09/11/2014, 15:46:28
    Author     : LOURIVALDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String usuario = request.getParameter("usuario");
    String cod = request.getParameter("cod");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <table width="52%" cellpadding="0" cellspacing="0" style="max-width:100%;border:1px solid #b3b3b3" align="center">
            <tbody>
                <tr>
                    <td colspan="2" bgcolor="#B2B2B0" style="padding:15px">
                        <img src="../imagens/logo.png" class="CToWUd">
                    </td>
                </tr>

                <tr>
                    <td style="padding:32px 27px 27px 27px" valign="top">
                        <table style="font-size:15px;width:400px">
                            <tbody>
                                <tr>
                                    <td style="padding-bottom:15px">Caro(a) <%=usuario%>,</td>
                                </tr>
                                <tr>
                                    <td style="padding-bottom:15px">Solicitou a redefinição da sua senha. 
                                        Clique na hiperligação abaixo. Irá para uma página da Web onde 
                                        poderá alterar a sua senha.
                                    </td>
                                </tr>

                                <tr>
                                    <td style="font-size:22px;font-weight:bold;padding-bottom:15px;color:#1f4f82">› <a href="usucontroller.do?reset=reset&cod=<%=cod%>" target="_blank"> Redefinir Senha</a></td>
                                </tr>
                                <tr>
                                    <td>A hiperligação vai expirar dentro de 1 dia e só pode ser utilizada uma vez.</td>
                                </tr>

                                <tr>
                                    <td colspan="2" style="padding:20px 27px 10px 0">Obrigado,</td>
                                </tr>

                                <tr>
                                    <td colspan="2" style="padding:0px 27px 30px 0">A Equipa da Conta <span class="il">Condomínio Web</span></td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
