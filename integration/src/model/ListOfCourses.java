package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListOfCourses {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/edondem";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static List<Course> list() {

		Connection conn = null;
		Statement stmt = null;
		List<Course> courses = new ArrayList<Course>();

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = ((java.sql.Connection) conn).createStatement();
			String sql;
			sql = "select * from request";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("REQUEST_ID");
				// int stdid = rs.getInt("STUDENT_ID");
				int offer = rs.getInt("OFFER");
				String cour = rs.getString("COURSE_NAME");
				String category = rs.getString("CATEGORY");

				// Display values
				System.out.print("ID: " + id);
				Course course = new Course(id, offer, cour, category);
				courses.add(course);
				// request.setAttribute("course", course);

			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			((Connection) conn).close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");

		return courses;
	}

}
