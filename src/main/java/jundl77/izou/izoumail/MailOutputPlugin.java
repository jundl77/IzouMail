package jundl77.izou.izoumail;

import intellimate.izou.output.OutputPlugin;
import intellimate.izou.system.Context;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * The MailOutputPlugin is capable of sending an email
 */
public class MailOutputPlugin extends OutputPlugin<MailOutputData> {
    /**
     * The ID of the output plugin
     */
    public static final String ID = MailAddOn.class.getCanonicalName();

    public MailOutputPlugin(Context context) {
        super(ID, context);
    }

    @Override
    public void renderFinalOutput() {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        getContext().logger.getLogger().debug("Starting new mail session");
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        String username = "intellimate.izou@gmail.com";//
        String password = "Karlskrone";

        for (MailOutputData outputData : pollTDoneList()) {
            try{
                Session session = Session.getDefaultInstance(props, new Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }});

                MimeMessage message = new MimeMessage(session);

                getContext().logger.getLogger().debug("Adding content of e-mail");
                message.setFrom(new InternetAddress(username));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(outputData.getToAddress()));
                message.setSubject(outputData.getSubject());
                message.setText(outputData.getContent());

                getContext().logger.getLogger().debug("Sending e-mail");
                Transport.send(message);
                getContext().logger.getLogger().debug("E-mail sent successfully");
            } catch (MessagingException e) {
                getContext().logger.getLogger().error("Unable to send e-mail", e);
            }
        }
    }
}
