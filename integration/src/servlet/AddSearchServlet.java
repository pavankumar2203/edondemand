package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Course1;
import business.Request;
import business.Student;
import data.RequestDB;

/**
 * Servlet implementation class AddSearch
 */
public class AddSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Course1 course = (Course1)session.getAttribute("course");
		Student student = (Student)session.getAttribute("student");
		String credits = request.getParameter("credits");
		String url = "";
		String message = "";
		
		Request requestCourse = new Request();

		requestCourse.setStudentId(student.getStudentId());
		requestCourse.setCourseName(course.getCourseName());
		requestCourse.setCredit(credits);
		requestCourse.setCategory(null);
				
		boolean insert = RequestDB.addRequest(requestCourse);
		if (insert == true){
			session.setAttribute("requestCourse", requestCourse);
			message = "You have added a course successfully!";
			url = "/student.jsp";
		}
		else {
			message = "Failing to add a course!";
			url = "/request.jsp";
		} 
	
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
