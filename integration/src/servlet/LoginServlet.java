package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.LoginDB;
import data.StudentDB;

import business.Login;
import business.Student;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String loginas = request.getParameter("loginas");
		String url = "";
		String message = "";
		Login login = null;

		if ((userId.length() == 0) || (pwd.length() == 0)) {
			message = "Error: Please fill out all these two text boxes!";
			url = "/index.jsp";
		} else {
			login = LoginDB.getLogin(userId, pwd);
			if (login == null) {
				message = "Error: User name or Password is not correct!";
				url = "/index.jsp";
			} else {
				session.setAttribute("login", login);
				if(loginas.equalsIgnoreCase("Student")){
					Student student = StudentDB.getStudent(login.getStudentId());
					session.setAttribute("student", student);
					url = "/student.jsp";
				}
				if(loginas.equalsIgnoreCase("Professor")){
					//Professor professor = StudentDB.getStudent(login.getStudentId());
					//session.setAttribute("student", student);
					//url = "/request.jsp";
				}
			}
		}
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
