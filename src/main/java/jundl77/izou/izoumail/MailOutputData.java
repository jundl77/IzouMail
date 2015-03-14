package jundl77.izou.izoumail;

/**
 * MailOutputData contains the content of the email to be sent
 */
public class MailOutputData {
    private String toAddress;
    private String subject;
    private String content;

    /**
     * Creates a new MailOutputData with a content of {@code content} that will be sent to the address of
     * {@code toAddress}
     *
     * @param toAddress the e-mail address that the e-mail should be sent to
     * @param subject the subject of the email
     * @param content the content of the mail -- what will be sent as an e-mail
     */
    public MailOutputData(String toAddress, String subject, String content) {
        this.toAddress = toAddress;
        this.subject = subject;
        this.content = content;
    }

    /**
     * Gets the e-mail address that the e-mail should be sent to
     *
     * @return the e-mail address that the e-mail should be sent to
     */
    public String getToAddress() {
        return toAddress;
    }

    /**
     * Gets the subject of the e-mail
     *
     * @return the subject of the e-mail
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Gets the content of the e-mail
     *
     * @return the content of the e-mail
     */
    public String getContent() {
        return content;
    }
}
