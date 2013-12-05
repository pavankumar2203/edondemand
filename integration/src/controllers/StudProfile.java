/**
 * 
 * This gets the profile of the student
 * @author: Pavan Kumar Sunder and Susan Chun Xu
 * 
 * 
 */


package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Login;
import business.Student;
import data.StudentDB;

/**
 * Servlet implementation class StudProfile
 */

public class StudProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Login std = (Login) session.getAttribute("login");
		try {
			// declare a connection by using Connection interface
			Connection connection = null;

			// Load JDBC driver "com.mysql.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/edondem", "root", "root");

			PreparedStatement statement = null;

			statement = connection
					.prepareStatement("Select * FROM STUDENTS where STUDENT_ID=" + std.getStudentId());
			ResultSet result = statement.executeQuery();
			boolean re = result.next();
			System.out.println(re + result.getString(2) + "pavns");
			System.out.println("how can i not go in");
			if(re) {
				System.out.println(re + "pavns1");
				request.setAttribute("Stud_Fname", result.getString(2));
				request.setAttribute("Stud_Lname", result.getString(3));
				request.setAttribute("Gender", result.getString(4));
				request.setAttribute("Age", result.getString(5));
				request.setAttribute("Email", result.getString(6));
				request.setAttribute("Credits", result.getString(7));
				
				System.out.println(result.getString(2));

			} else {
				request.setAttribute("Stud_Fname", "");
				request.setAttribute("Stud_Lname", "");
				request.setAttribute("Gender", "");
				request.setAttribute("Age", "");
				request.setAttribute("Email", "");
				request.setAttribute("Credits", "");
				System.out.println("Could not read a record i am here");
				
				
			}

			RequestDispatcher view = request
					.getRequestDispatcher("StudentProfileEdit.jsp");
			view.forward(request, response);
			connection.close();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(AddReadCourse.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (Exception ex) {
			Logger.getLogger(AddReadCourse.class.getName()).log(Level.SEVERE,
					null, ex);
			RequestDispatcher view = request.getRequestDispatcher("error.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			/*
			 * Create string of connection url within specified format with
			 * machine name, port number and database name. Here machine name id
			 * localhost and database name is usermaster.
			 */

			// declare a connection by using Connection interface
			Connection connection = null;

			// Load JDBC driver "com.mysql.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/edondem", "root", "root");

			// check weather connection is established or not by isClosed()
			// method

			String F_Name = request.getParameter("fname");
			String L_Name = request.getParameter("lname");
			String Gender = request.getParameter("gender");

			String Age = request.getParameter("age");
			String Email = request.getParameter("email");
			String Credits = request.getParameter("credits");

			int i = 0;
			PreparedStatement statement = null;

			statement = connection
					.prepareStatement("Select * FROM STUDENTS where STUDENT_ID=1");
			ResultSet result = statement.executeQuery();
			

			HttpSession session = request.getSession();
			Login std = (Login) session.getAttribute("login");
			
			if (result.next()) {
				PreparedStatement pst = connection
						.prepareStatement("update STUDENTS SET STUD_FNAME=?,STUD_LNAME=?,STUD_GENDER=?,STUD_AGE=?,STUD_EMAIL=?,STUD_SCORE=? WHERE STUDENT_ID="+ std.getStudentId());

				pst.setString(1, F_Name);
				pst.setString(2, L_Name);
				pst.setString(3, Gender);
				pst.setString(4, Age);
				pst.setString(5, Email);
				pst.setString(6, Credits);

				i = pst.executeUpdate();
			} else {

				PreparedStatement pst = connection
						.prepareStatement("insert into STUDENTS (STUD_FNAME,STUD_LNAME,STUD_GENDER,STUD_AGE,STUD_EMAIL,STUD_SCORE)"
								+ " values(?,?,?,?,?,?)");
				pst.setString(1, F_Name);
				pst.setString(2, L_Name);
				pst.setString(3, Gender);
				pst.setString(4, Age);
				pst.setString(5, Email);
				pst.setString(6, Credits);

				i = pst.executeUpdate();
			}
			Student student = StudentDB
					.getStudent(std.getStudentId());
			request.setAttribute("student", student);
			if (i != 0) {
				RequestDispatcher view = request
						.getRequestDispatcher("student.jsp");
				view.forward(request, response);
			} else {
				RequestDispatcher view = request
						.getRequestDispatcher("error.jsp");
				view.forward(request, response);
			}
			connection.close();
		} catch (Exception ex) {

		}
	}
}
