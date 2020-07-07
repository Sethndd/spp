//TODO
//Método para enviar mail diferentes

package utilities;

import utilities.datastructure.EmailCredentials;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static utilities.ExceptionLogger.writeException;

public class MailSender {
    private static EmailCredentials email;
    private static String sender;
    private static String password;
    private static String receiver;

    private static Session prepareEMail(){
        email = AccessCredentialsController.readEmailCredentials();
        Properties smtpPropierties = new Properties();
        
        smtpPropierties.setProperty("mail.smtp.host", "smtp.gmail.com");
        smtpPropierties.setProperty("mail.smtp.starttls.enable", "true");
        smtpPropierties.setProperty("mail.smtp.port", "587");
        smtpPropierties.setProperty("mail.smtep.auth", "true");
        
        sender = email.getUser();
        password = email.getPassword();
        receiver = "seth261099@gmail.com";
        
        Session eMailSession = Session.getDefaultInstance(smtpPropierties);
        
        return eMailSession;
    }
    
    public static void sendEMail(String eMailTitle, String eMailBody){
        Session eMailSession = prepareEMail();
        
        String title = eMailTitle;
        String message = eMailBody;
        
        MimeMessage mail = new MimeMessage(eMailSession);
        try {
            mail.setFrom(new InternetAddress(sender));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            mail.setSubject(title);
            mail.setText(message);
            
            Transport transporter = eMailSession.getTransport("smtp");
            transporter.connect(sender,password);
            transporter.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transporter.close();          
            
        } catch (AddressException ex) {
            writeException(ex, "utilities.ExceptionLogger");
        } catch (MessagingException ex) {
            writeException(ex, "utilities.ExceptionLogger");
        }
    }
}
