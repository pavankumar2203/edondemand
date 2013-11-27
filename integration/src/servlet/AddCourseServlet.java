package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.CourseDB;
import data.RequestDB;
import business.Course;
import business.Request;
import business.Student;

public class AddCourseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		String courseName = request.getParameter("courseName");
		String credits = request.getParameter("credits");
		String category = request.getParameter("category");
		String url = "";
		String message = "";
		boolean bool = true;
		
		Request requestCourse = new Request();

		if ((courseName.length() == 0) || (credits.length() == 0)){
			message = "Error: Please Enter the Course Name and credits!";
			url = "/request.jsp";
		} else {
			ArrayList<Course> courseList = CourseDB.getCourseList();
			for(int i = 0; i < courseList.size(); i++){
	        	Course temp = courseList.get(i);
	        	if (courseName.equalsIgnoreCase(temp.getCourseName())){        		
	                bool = false;
	                break;
	        	}
	         }

			if (bool == true) {
				requestCourse.setStudentId(student.getStudentId());
				requestCourse.setCourseName(courseName);
				requestCourse.setCredit(credits);
				requestCourse.setCategory(category);
				
				System.out.println(RequestDB.addRequest(requestCourse));
				session.setAttribute("requestCourse", requestCourse);
				message = "You have added a course successfully!";
				url = "/request.jsp";
			} else {
				message = "Error: This course already exists! Please search to find it";
			}
			
		}
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
