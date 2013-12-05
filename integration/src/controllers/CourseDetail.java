/**
 * 
 * This returns the details of a course
 * @author: Pavan Kumar Sunder and Susan Chun Xu
 * 
 * 
 */

package controllers;

import java.io.IOException;
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
import model.courseView;

/**
 * Servlet implementation class CourseDetail
 */
public class CourseDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CourseDetail() {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String course = request.getParameter("checkmeout");
		Course cv = courseView.list(course);
		System.out.println(course);
		if (course == null)
			request.setAttribute("course", "you have not chosen a course");
		else
			request.setAttribute("course", course);

		request.setAttribute("coursedetails", cv);
		RequestDispatcher rd = null;

		rd = request.getRequestDispatcher("/coursedetail.jsp");

		rd.forward(request, response);
	}

}
