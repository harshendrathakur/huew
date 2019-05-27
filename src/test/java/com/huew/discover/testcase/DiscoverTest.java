package com.huew.discover.testcase;

import org.testng.annotations.Test;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import com.huew.homepage.*;
import com.huew.base.Base;
import com.huew.guestprofile.*;
import com.huew.loggedprofile.*;

import testNGReport.realTimeReport.RealGuru99TimeReport;

import com.hue.discover.*;


@Listeners(reporter.Listener.class)
public class DiscoverTest extends Base{
  public DiscoverTest() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
  
  Homepage homepage;
  GuestProfile guestprofile;
  LoggedProfile loggedprofile;
  Discover discover;
@Test
  public void f() throws Throwable {
	
	Assert.assertTrue(true);
	discover.uploadImage();
	Thread.sleep(2000);
	discover.saveUpload();
	Thread.sleep(2000);
	//discover.navigateAway();

}
  @BeforeMethod
  public void beforeMethod() throws Throwable {
	  initialization();
	  homepage = new Homepage();
	  guestprofile = new GuestProfile();
	  loggedprofile = new LoggedProfile();
	  discover = new Discover();
	  guestprofile=homepage.clickonloginlink();
	  guestprofile.clickOnGoogleLoginButton();
	  loggedprofile=guestprofile.googleLogin();
	  discover=loggedprofile.clickDiscover();
  }

  @AfterMethod
  public void afterMethod() {
	 
	  sendPDFReportByGMail("seleniumbase@gmail.com", "selesele", "harshendra.thakur@gmail.com", "PDF Report", "");

  }
/**

* Send email using java

* @param from

* @param pass

* @param to

* @param subject

* @param body

*/

private static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {

Properties props = System.getProperties();

final String host = "smtp.gmail.com";

props.put("mail.smtp.starttls.enable", "true");

props.put("mail.smtp.host", host);

props.put("mail.smtp.user", from);

props.put("mail.smtp.password", pass);

props.put("mail.smtp.port", "587");

props.put("mail.smtp.auth", "true");

final String uname=from;
final String pword=pass;
Authenticator authenticator = new Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(uname, pword);
    }
};

Session session = Session.getDefaultInstance(props,authenticator);

MimeMessage message = new MimeMessage(session);

try {

//Set from address

message.setFrom(new InternetAddress(from));

message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

//Set subject

message.setSubject(subject);

message.setText(body);

BodyPart objMessageBodyPart = new MimeBodyPart();

objMessageBodyPart.setText("Please Find The Attached Report File!");

Multipart multipart = new MimeMultipart();

multipart.addBodyPart(objMessageBodyPart);

objMessageBodyPart = new MimeBodyPart();

//Set path to the pdf report file

String filename = System.getProperty("user.dir")+"\\"+thepdffile;//wDefault test"+(new Random().nextInt())+".pdf";

//Create data source to attach the file in mail

DataSource source = new FileDataSource(filename);

objMessageBodyPart.setDataHandler(new DataHandler(source));

objMessageBodyPart.setFileName(filename);

multipart.addBodyPart(objMessageBodyPart);

message.setContent(multipart);

Transport transport = session.getTransport("smtp");

transport.connect(host, from, pass);

transport.sendMessage(message, message.getAllRecipients());

transport.close();

}

catch (AddressException ae) {

ae.printStackTrace();

}

catch (MessagingException me) {

me.printStackTrace();

}


	    
	 driver.quit();
  }

}
