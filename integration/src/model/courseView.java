package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class courseView {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/edondem";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static Course list(String id) {

		Connection conn = null;
		Statement stmt = null;
		Course course = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement..." + id);
			stmt = ((java.sql.Connection) conn).createStatement();
			String sql;
			sql = "select Count(*),sum(credit),COURSE_NAME,CATEGORY from request where Course_Name ='"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int rid = rs.getInt("Count(*)");
				// int stdid = rs.getInt("STUDENT_ID");
				int offer = rs.getInt("SUM(CREDIT)");
				String cour = rs.getString("COURSE_NAME");
				String category = rs.getString("CATEGORY");

				// Display values
				System.out.print("ID: " + id);
				course = new Course(rid, offer, cour, category);
				
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

		return course;
	}

}