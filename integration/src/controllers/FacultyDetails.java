/**
 * 
 * This gets the professor information
 * @author: Latha and Ishant
 * 
 * 
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

/**
 * Servlet implementation class FacultyDetails
 */

public class FacultyDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacultyDetails() {
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
		Login prof = (Login) session.getAttribute("login");

		try {
			// declare a connection by using Connection interface
			Connection connection = null;

			// Load JDBC driver "com.mysql.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/edondem", "root", "root");

			PreparedStatement statement = null;

			statement = connection
					.prepareStatement("Select * FROM PROFESSOR where PROF_ID="
							+ prof.getProfId());
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				request.setAttribute("profName", result.getString(2));
				request.setAttribute("Email", result.getString(3));
				request.setAttribute("Phone", result.getString(4));
				request.setAttribute("Skill", result.getString(6));
				request.setAttribute("Certi", result.getString(7));
				request.setAttribute("Profession", result.getString(8));

			} else {
				request.setAttribute("profName", "");
				request.setAttribute("Email", "");
				request.setAttribute("Skill", "");
				request.setAttribute("Phone", "");
				request.setAttribute("Certi", "");
				request.setAttribute("Profession", "");
				System.out.println("Could not read a record");
			}

			RequestDispatcher view = request
					.getRequestDispatcher("Stud_Prof.jsp");
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

			HttpSession session = request.getSession();
			Login prof = (Login) session.getAttribute("login");

			// Load JDBC driver "com.mysql.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/edondem", "root", "root");

			// check weather connection is established or not by isClosed()
			// method

			String Name = request.getParameter("name");
			String Email = request.getParameter("email");
			String Phone = request.getParameter("phone");

			String Skill = request.getParameter("skills");
			String Certificate = request.getParameter("certi");
			String Profession = request.getParameter("profession");

			int i = 0;
			PreparedStatement statement = null;

			statement = connection
					.prepareStatement("Select * FROM PROFESSOR where PROF_ID=1");
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				PreparedStatement pst = connection
						.prepareStatement("update PROFESSOR SET PROF_NAME=?,EMAIL=?,PHONE=?,SKILL=?,CERTIFICATE=?,PROFESSION=? WHERE PROF_ID="
								+ prof.getProfId());

				pst.setString(1, Name);
				pst.setString(2, Email);
				pst.setString(3, Phone);
				pst.setString(4, Skill);
				pst.setString(5, Certificate);
				pst.setString(6, Profession);

				i = pst.executeUpdate();
			} else {

				PreparedStatement pst = connection
						.prepareStatement("insert into PROFESSOR (PROF_NAME,EMAIL,PHONE,SKILL,CERTIFICATE,PROFESSION)"
								+ " values(?,?,?,?,?,?)");
				pst.setString(1, Name);
				pst.setString(2, Email);
				pst.setString(3, Phone);
				pst.setString(4, Skill);
				pst.setString(5, Certificate);
				pst.setString(6, Profession);

				i = pst.executeUpdate();
			}
			if (i != 0) {
				RequestDispatcher view = request
						.getRequestDispatcher("success.jsp");
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
