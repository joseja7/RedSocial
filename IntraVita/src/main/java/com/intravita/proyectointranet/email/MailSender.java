package com.intravita.proyectointranet.email;

import java.sql.SQLException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailSender {
	private static String userName = "customer.service.intravita@gmail.com";
	private static String password = "customerserviceintravita1234";
	

	private static Session getSession() throws SQLException{
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		return session;
	}
	public void sendMailRecoverPwd(String usuario, String pwd) throws Exception{
		try {

			Message message = new MimeMessage(getSession());
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(usuario));
			message.setSubject("Servicio de atencion al cliente de IntraVita - Contraseña temporal");
			message.setText("Saludos, su nueva contraseña para acceder a su cuenta es: "+pwd+
							"\nPor favor, para una mayor seguridad, cambie esta contraseña por una nueva dentro de la configuracion de su perfil.");
			Transport.send(message);


		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}





