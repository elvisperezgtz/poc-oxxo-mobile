package starter.utils.mail;


import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.io.IOException;
import java.util.Properties;

public class GmailReader {

    public static String getVerificationCode(String host, String storeType, String username, String password) {

        String verificationCode = null;
        try {

            // create properties
            Properties properties = new Properties();

            properties.put("mail.smtp.port", host);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.socketFactory.port", "465");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            Session emailSession = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });


            // create the imap store object and connect to the imap server
            Store store = emailSession.getStore("imaps");

            store.connect(host, username, password);

            // create the inbox object and open it
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
            System.out.println("messages.length---" + messages.length);

//            for (int i = 0, n = messages.length; i < n; i++) {
//                Message message = messages[i];
//                message.setFlag(Flags.Flag.SEEN, true);
//                System.out.println("---------------------------------");
//                System.out.println("Email Number " + (i + 1));
//                System.out.println("Subject: " + message.getSubject());
//                System.out.println("From: " + message.getFrom()[0]);
//                System.out.println("Text: " + getTextFromMimeMultipart((MimeMultipart) message.getContent()));
//
//            }

            Message message = messages[messages.length - 1];
            message.setFlag(Flags.Flag.SEEN, true);
            verificationCode = getTextFromMimeMultipart((MimeMultipart) message.getContent());
            inbox.close(false);
            store.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return verificationCode;
    }

    public static String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }

    public static String getVerificationCode() throws InterruptedException {

//Todo Llamar esto desde un property
        String host = "smtp.gmail.com";
        String mailStoreType = "smtp";
        String username = "dummymobileautomation@gmail.com";
        String password = "uxlbikfmjqguyqty";
        String message = getVerificationCode(host, mailStoreType, username, password);
        String verificationCode = null;
        verificationCode = extractCodeFromMessage(message);
        return verificationCode;
    }

    public static String extractCodeFromMessage(String message) {
        String[] code;
        if (message != null) {
            code = message.split(" es ");
            code = (code[code.length - 1].replace(".", "").split(" "));
            return code[0];
        } else {
            System.out.println("<----No se encontraron nuevos mensajes---->");
            return null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("verification code: " + getVerificationCode());
    }
}
