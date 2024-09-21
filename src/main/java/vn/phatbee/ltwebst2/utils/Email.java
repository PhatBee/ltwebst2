package vn.phatbee.ltwebst2.utils;

import vn.phatbee.ltwebst2.models.UserModel;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class Email {
    // Hàm mã code ngẫu nhiên
    public String getRandom(){
        Random rand = new Random();
        int number = rand.nextInt(999999);
        return String.format("%06d",number);
    }

    public boolean sendMail(UserModel user){
        boolean result = false;

        String toEmail = user.getEmail();
        String fromEmail = "22110394@student.hcmute.edu.vn";
        String password = "Phatbee30092004";

        try {
            // Your host email smtp server
            Properties pr = configEmail(new Properties());
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            // set email message detail
            Message msg = new MimeMessage(session);
            msg.setHeader("Content-Type", "text/plain, charset=UTF-8");
            // set from email address
            msg.setFrom(new InternetAddress(fromEmail));
            // set to email address or destination email address
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // set email subject
            msg.setSubject("Confirm code");

            // set message text
            msg.setText("Your code is " + user.getCode());
            // sent the message
            Transport.send(msg);

            result = true;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Properties configEmail(Properties pr){
        // Your host mail smtp server detail
        pr.setProperty("mail.smtp.host", "smtp.gmail.com");
        pr.setProperty("mail.smtp.auth", "true");
        pr.setProperty("mail.smtp.port", "587");
        pr.setProperty("mail.smtp.starttls.enable", "true");
        pr.put("mail.smtp.socketFactory.port", "587");
        pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        return pr;
    }
}
