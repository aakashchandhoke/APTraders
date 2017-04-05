/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.util.Properties;
import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage; 

/**
 *
 * @author Aakash
 */
public class Mailer
{
    public static void send(String email,String name,String msg)
    {  
        final String user="aakash.chandhoke24@gmail.com";//change accordingly  
        final String pass="@@@Meena1";  
  
        //1st step) Get the session object    
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");  
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");  
        props.put("mail.smtp.starttls.enable", "true");
  
        Session session = Session.getDefaultInstance(props,  
        new javax.mail.Authenticator() {  
        protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication(user,pass);  
    }  
    });  
    //2nd step)compose message  
    try 
    {  
        MimeMessage message = new MimeMessage(session);  
        message.setFrom(new InternetAddress(email));  
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(user));  
        message.setSubject("Hey this is "+name);  
        message.setText(name+"\n\n"+email+"\n\n"+msg);  
   
         //3rd step)send message  
        Transport.send(message);  
   
  
    } 
    catch (MessagingException e) 
    {  
        throw new RuntimeException(e);  
    }  
      
}  
}
