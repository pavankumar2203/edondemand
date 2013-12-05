/**
 * 
 * This helps the professor search for a particular course
 * @author: Pavan Kumar Sunder and Susan Chun Xu
 * 
 * 
 */

package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Course;
import model.ListOfCourses;
import data.CourseDB;
import business.Course1;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchProfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchProfServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String searchReqeust = request.getParameter("searchrequest");
		String url = "";
		String message = "";

		System.out.println(searchReqeust);

		if (searchReqeust.length() == 0) {
			message = "Error: Please Enter the Course Name!";
			url = "/request.jsp";
		} else {
			ArrayList<Course> courselist = CourseDB
					.searchRequestedCourse(searchReqeust);

			// System.out.println(courselist.size());
			if (courselist == null) {
				message = "Revelant Course does not exist!";
				url = "/success.jsp";
			} else {
				// session.setAttribute("course", courseList);
				// url = "/course.jsp";

				System.out.println("you seached for " + searchReqeust);
				// List<Course> courselist = ListOfCourses.list();
				request.setAttribute("course", courselist); // Will be available
															// as ${products} in
															// JSP
				url = "/success.jsp";

			}
		}
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
