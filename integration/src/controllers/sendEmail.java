package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class sendEmail
 */
public class sendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public sendEmail() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private class SMTPAuthenticator extends Authenticator {

		private PasswordAuthentication authentication;

		public SMTPAuthenticator(String login, String password) {
			authentication = new PasswordAuthentication(login, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String Time = request.getParameter("Time");
		String Date = request.getParameter("Date");

		String from = "bestestt@gmail.com";
		String to = "bestestt@gmail.com";
		String subject = "Course";
		String message = "Hi Student,\n I will be teaching you this course on\n";
		message += Time +"," + Date; 
		message += "\nThanks,\n Pavan"; 
		String login = "bestestt@gmail.com";
		String password = "josephites";

		try {
			Properties props = new Properties();
			props.setProperty("mail.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");

			Authenticator auth = new SMTPAuthenticator(login, password);

			Session session = Session.getInstance(props, auth);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(message);
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(msg);

		} catch (AuthenticationFailedException ex) {
			request.setAttribute("ErrorMessage", "Authentication failed");

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/err.jsp");
			dispatcher.forward(request, response);

		} catch (AddressException ex) {
			request.setAttribute("ErrorMessage", "Wrong email address");

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/err.jsp");
			dispatcher.forward(request, response);

		} catch (MessagingException ex) {
			request.setAttribute("ErrorMessage", ex.getMessage());

		}
		request.setAttribute("email", "email sent");
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/sendemail.jsp");
		dispatcher.forward(request, response);
	}

}
