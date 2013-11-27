package controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			/* Create string of connection url within specified format with machine name,
                port number and database name. Here machine name id localhost and
                database name is usermaster. */
			
			System.out.println("**********inside do post");
			String connectionURL = "jdbc:mysql://localhost:3306/edondem";
			PrintWriter pw = response.getWriter();

			// declare a connection by using Connection interface
			Connection connection = null;

			// Load JDBC driver "com.mysql.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("**********before connection");
			/* Create a connection by using getConnection() method that takes parameters of
                string type connection url, user name and password to connect to database. */
			connection = DriverManager.getConnection(connectionURL, "root",
					"root");
			System.out.println("**********after connection");
			// check weather connection is established or not by isClosed() method
			if (!connection.isClosed())
			{
				String Name = request.getParameter("name"); 
				String Email = request.getParameter("email");
				String Phone = request.getParameter("phone");  

				String Skill = request.getParameter("skills");
				String Certificate = request.getParameter("certi");
				String Profession = request.getParameter("profession");



				PreparedStatement pst = connection.prepareStatement("insert into PROFESSOR (PROF_NAME,EMAIL,PHONE,SKILL,CERTIFICATE,PROFESSION)"
						+ " values(?,?,?,?,?,?)");
				pst.setString(1,Name);  
				pst.setString(2,Email); 
				pst.setString(3,Phone);        
				pst.setString(4,Skill);  
				pst.setString(5,Certificate); 
				pst.setString(6,Profession); 

				int i = pst.executeUpdate(); 
				if(i!=0){  
					pw.println("<br>Record has been inserted");  
					System.out.println("**********inserted");
				}
			}


			connection.close();
		} 
		catch (Exception ex) {

		}

	}

}
