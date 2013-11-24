package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Authenticator;
import model.Course;
import model.ListOfCourses;
import model.User;
import sun.text.normalizer.ICUBinary.Authenticate;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;

		Authenticator authenticator = new Authenticator();
		String result = authenticator.authenticate(username, password);
		if (result.equals("success")) {
			
			User user = new User(username, password);
			request.setAttribute("user", user);
			List<Course> courselist = ListOfCourses.list();
		    request.setAttribute("course", courselist); // Will be available as ${products} in JSP
		    rd = request.getRequestDispatcher("/success.jsp");
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

}