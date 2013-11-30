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

import business.Course1;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		String searchReqeust = request.getParameter("searchReqeust");
		String url = "";
		String message = "";
		
		System.out.println(searchReqeust);

		if (searchReqeust.length() == 0) {
			message = "Error: Please Enter the Course Name!";
			url = "/request.jsp";
		} else {
			ArrayList<Course1> courseList = CourseDB.searchCourse(searchReqeust);
			
			System.out.println(courseList.size());
			if (courseList.size() == 0) {
				message = "Revelant Course does not exist!";
				url = "/request.jsp";
			} else {
				session.setAttribute("courseList", courseList);
				url = "/course.jsp";
			}
		}
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
