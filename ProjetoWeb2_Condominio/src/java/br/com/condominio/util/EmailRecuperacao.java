package br.com.condominio.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author LOURIVALDO
 */
public class EmailRecuperacao {

    private final Email email;
    private final HtmlEmail emailHtml;

    public EmailRecuperacao() {
        this.email = new SimpleEmail();
        this.emailHtml = new HtmlEmail();
//        configurar();
    }

//    private void configurar() {
//        email.setHostName("smtp.googlemail.com");
//        email.setSmtpPort(465);
//        email.setDebug(true);
//        email.setAuthenticator(new DefaultAuthenticator("quintobackup5@gmail.com", "#quintobackup5"));
//        email.setSSLOnConnect(true);
//    }
    public void enviarEmail(String de, String assunto, String msg, String para) {

        try {
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setDebug(true);
            email.setAuthenticator(new DefaultAuthenticator("quintobackup5@gmail.com", "#quintobackup5"));
            email.setSSLOnConnect(true);
            email.setFrom(de);
            email.setSubject(assunto);
            email.setMsg(msg);
            email.addTo(para);
            email.addReplyTo(de);
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(EmailRecuperacao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void enviarEmailHtml(String de, String assunto, String html, String para) {

        try {
            emailHtml.setHostName("smtp.googlemail.com");
            emailHtml.setSmtpPort(465);
            emailHtml.setDebug(true);
            emailHtml.setAuthenticator(new DefaultAuthenticator("quintobackup5@gmail.com", "#quintobackup5"));
            emailHtml.setSSLOnConnect(true);
            emailHtml.setFrom(de);
            emailHtml.setSubject(assunto);
            emailHtml.setHtmlMsg(html);
            emailHtml.setTextMsg("Your email client does not support HTML messages");
            emailHtml.addTo(para);
            emailHtml.addReplyTo(de);
            emailHtml.send();
        } catch (EmailException ex) {
            Logger.getLogger(EmailRecuperacao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        EmailRecuperacao recuperacao = new EmailRecuperacao();
//        recuperacao.enviarEmail("quintobackup5@gmail.com",
//                "Recuperação De Senha",
//                "Testando Recuperação De Senha ... :-)",
//                "loro.vasconcelos@gmail.com");
        recuperacao.enviarEmailHtml("quintobackup5@gmail.com", "Recup", "<h1>NAHAHAHHAHH</h1>", "loro.vasconcelos@gmail.com");

    }

}
