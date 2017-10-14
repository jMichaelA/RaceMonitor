import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Email implements IObserver{
    private ArrayList<String> clientEmail;
    private String hostEmail;
    private String host;

    public Email(){

    }

    public Email(ArrayList<String> clientEmail, String hostEmail) {
        this.clientEmail = clientEmail;
        this.hostEmail = hostEmail;
        host = "localhost";
    }

    public Email(ArrayList<String> clientEmail, String hostEmail, String host) {
        this.clientEmail = clientEmail;
        this.hostEmail = hostEmail;
        this.host = host;
    }

    @Override
    public void update(Athlete athlete) {
        // right here create a thread that every so many minutes sends an email
    }

    @Override
    public void update(HashMap<Integer, Athlete> athlete) {

    }

    public void sendEmail(String message, String subject){
        //https://www.tutorialspoint.com/java/java_sending_email.htm
        Properties prop = System.getProperties();
        prop.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(prop);

        try {
            MimeMessage email = new MimeMessage(session);

            email.setFrom(new InternetAddress(hostEmail));
            for (String i : clientEmail){
                email.addRecipient(Message.RecipientType.TO, new InternetAddress(i));
            }

            email.setSubject(subject);
            email.setText(message);

            // Send message
            Transport.send(email);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public ArrayList<String> getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(ArrayList<String> clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getHostEmail() {
        return hostEmail;
    }

    public void setHostEmail(String hostEmail) {
        this.hostEmail = hostEmail;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

}
