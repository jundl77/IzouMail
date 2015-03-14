import jundl77.izou.izoumail.MailOutputData;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Use this class to debug
 */
public class Debug {
    public static void main(String[] args) {
//        LinkedList<AddOn> addOns = new LinkedList<>();
//
//        Main main = new Main(addOns, true);

        MailOutputData outputData = new MailOutputData("sbrendl@yahoo.com",
                "Test", "Hey mama, diese e-mail wurde automatisch von izou geschickt :D ist doch geil oder?");

        List<MailOutputData> outputDataList = new ArrayList<>();
        outputDataList.add(outputData);

        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object
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

        for (MailOutputData o : outputDataList) {
            try {

                Session session = Session.getDefaultInstance(props, new Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }});

                MimeMessage message = new MimeMessage(session);

                message.setFrom(new InternetAddress(username));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(o.getToAddress()));
                message.setSubject(o.getSubject());
                message.setText(o.getContent());

                Transport.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
