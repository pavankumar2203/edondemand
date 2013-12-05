package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Course1;
import business.Login;
import business.Request;
import business.Student;
import data.CourseDB;

/**
 * Servlet implementation class AddCreditServlet
 */
public class AddCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCreditServlet() {
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

		ArrayList<Course1> search = (ArrayList<Course1>) session.getAttribute("courseList");
		Course1 searchReqeust = (Course1) search.get(0);
		Student student = (Student)session.getAttribute("student");
		String credits =  request.getParameter("courseCredits");
		String url = "";
		String message = "";
		
		Request req = new Request();
		System.out.println(searchReqeust);

		if (searchReqeust == null) {
			message = "Error: Please Enter the Course Name!";
			url = "/course.jsp";
		} else {
			Boolean courseList = CourseDB.updateRequestedCourse(searchReqeust.getCourseName(), credits,student.getStudentId(),req);
			
			System.out.println(courseList);
			
				url = "/course.jsp";
				
				message = "You have added this course successfully";
			
		}
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	}


