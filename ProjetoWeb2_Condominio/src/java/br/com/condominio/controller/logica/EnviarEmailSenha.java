package br.com.condominio.controller.logica;

import br.com.condominio.entidades.Usuario;
import br.com.condominio.jdbc.UsuarioDAO;
import br.com.condominio.util.EmailRecuperacao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class EnviarEmailSenha implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        String email = request.getParameter("email");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarEmail(email);

        if (usuario == null) {
            request.setAttribute("msg", "Email não cadastrado!");
             return "form_pedido_senha.jsp";
        } else {
            String codigo = getGerador();
            String emailAdm = (String) request.getServletContext().getInitParameter("adm-email");
            
            request.setAttribute("usuario", usuario);
            
            //cadastrar codigo recuperação
            usuarioDAO.setCodigoRecuperacao(usuario, codigo);

            EmailRecuperacao emailRecuperacao = new EmailRecuperacao();

            emailRecuperacao.enviarEmailHtml(emailAdm,
                    "Pedido Redefinição de Senha - Condomínio",
                    template(usuario.getNome(), usuario.getLogin(), codigo),
                    usuario.getLogin());
        }

        return "email_enviado.html";
    }

    public static String getGerador() {
        int i = 0;
        char[] codigo = new char[100];

        char[] arrayCaracter = {'2', '4', '5', '6', '7', '8', '9', '0', '1', '3', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'W', 'Y', 'Z'};

        for (int j = 0; j < codigo.length; j++) {
            i = (int) (Math.random() * arrayCaracter.length);
            codigo[j] = arrayCaracter[i];
        }

        return String.valueOf(codigo);
    }

    private String template(String usuario, String login, String cod) {
        StringBuilder sb = new StringBuilder();
        sb.append("        <table width=\"52%\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:100%;border:1px solid #b3b3b3\" align=\"center\">\n");
        sb.append("            <tbody>\n");
        sb.append("                <tr>\n");
        sb.append("                    <td colspan=\"2\" bgcolor=\"#B2B2B0\" style=\"padding:15px\">\n");
        sb.append("                        <h1>Condomínio Web</h1>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("\n");
        sb.append("                <tr>\n");
        sb.append("                    <td style=\"padding:32px 27px 27px 27px\" valign=\"top\">\n");
        sb.append("                        <table style=\"font-size:15px;width:400px\">\n");
        sb.append("                            <tbody>\n");
        sb.append("                                <tr>\n");
        sb.append("                                    <td style=\"padding-bottom:15px\">Caro(a) ");
        sb.append(usuario);
        sb.append(",</td>\n");
        sb.append("                                </tr>\n");
        sb.append("                                <tr>\n");
        sb.append("                                    <td style=\"padding-bottom:15px\">Solicitou a redefinição da sua senha. \n");
        sb.append("                                        Clique na hiperligação abaixo. Irá para uma página da Web onde \n");
        sb.append("                                        poderá alterar a sua senha.\n");
        sb.append("                                    </td>\n");
        sb.append("                                </tr>\n");
        sb.append("\n");
        sb.append("                                <tr>\n");
        sb.append("                                    <td style=\"font-size:22px;font-weight:bold;padding-bottom:15px;color:#1f4f82\">› <a href=\"http://localhost:8084/ProjetoWeb2_Condominio/usucontroller.do?acao=FormAlterarSenha&email=");
        sb.append(login);
        sb.append("&cod=");
        sb.append(cod);
        sb.append("\" target=\"_blank\"> Redefinir Senha</a></td>\n");
        sb.append("                                </tr>\n");
        sb.append("                                <tr>\n");
        sb.append("                                    <td>A hiperligação vai expirar dentro de 1 dia e só pode ser utilizada uma vez.</td>\n");
        sb.append("                                </tr>\n");
        sb.append("\n");
        sb.append("                                <tr>\n");
        sb.append("                                    <td colspan=\"2\" style=\"padding:20px 27px 10px 0\">Obrigado,</td>\n");
        sb.append("                                </tr>\n");
        sb.append("\n");
        sb.append("                                <tr>\n");
        sb.append("                                    <td colspan=\"2\" style=\"padding:0px 27px 30px 0\">A Equipe da Conta <span class=\"il\">Condomínio Web</span></td>\n");
        sb.append("                                </tr>\n");
        sb.append("                            </tbody>\n");
        sb.append("                        </table>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("            </tbody>\n");
        sb.append("        </table>\n");

        return sb.toString();
    }

}
