/**
 * 
 * This connects to course db and helper methods used to get the rows
 * @author: Pavan Kumar Sunder and Susan Chun Xu
 * 
 * 
 */

package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Course;
import business.Course1;
import business.Request;

public class CourseDB {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/edondem";
	// Database credentials
	private static String username = "root";
	private static String password = "root";
	private static Connection connection = null;

	public static ArrayList<Course1> searchCourse(String courseName) {

		// ConnectionPool pool = ConnectionPool.getInstance();
		// Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Course1> courses = new ArrayList<Course1>();

		try {
			Class.forName(JDBC_DRIVER);
			// STEP 3: Open a connection
			System.out.println("Connecting to database..." + courseName);
			connection = (Connection) DriverManager.getConnection(DB_URL,
					username, password);
			String courseSQL = "SELECT * " + "FROM COURSES "
					+ "WHERE COURSE_NAME LIKE '%" + courseName + "%';";

			ps = connection.prepareStatement(courseSQL);
			rs = ps.executeQuery(courseSQL);

			// boolean re = ;
			if (rs.next()) {

				Course1 course = new Course1();
				course.setCourseId(rs.getString("COURSE_ID"));
				course.setCourseName(rs.getString("COURSE_NAME"));
				course.setComments(rs.getString("COMMENTS"));
				course.setProfId(rs.getString("PROF_ID"));
				courses.add(course);

				System.out.println(course.getCourseId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// DBUtil.closeResultSet(rs);
			// DBUtil.closePreparedStatement(ps);
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courses;
	}

	public static boolean updateRequestedCourse(String courseName, String cre,
			String id, Request req) {

		// ConnectionPool pool = ConnectionPool.getInstance();
		// Connection connection = pool.getConnection();
		System.out.println(courseName);
		System.out.println(cre);
		System.out.println(id);
		System.out.println(req.getCredit());
		System.out.println(req.getCategory());

		PreparedStatement ps = null;
		boolean returnvalue = false;
		String requestSQL = "INSERT INTO request "
				+ "VALUES (REQUEST_ID, ?, ?, ?, ?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			connection = (Connection) DriverManager.getConnection(DB_URL,
					username, password);
			ps = connection.prepareStatement(requestSQL);
			// ps.setString(1, x);
			ps.setString(1, id);
			ps.setString(2, courseName);
			ps.setString(3, cre);
			ps.setString(4, "New");
			try {
				returnvalue = (ps.executeUpdate() == 1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// DBUtil.closePreparedStatement(ps);
			// pool.freeConnection(connection);
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return returnvalue;
	}

	public static ArrayList<Course> searchRequestedCourse(String courseName) {

		// ConnectionPool pool = ConnectionPool.getInstance();
		// Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Course> courses = new ArrayList<Course>();

		try {
			Class.forName(JDBC_DRIVER);
			// STEP 3: Open a connection
			System.out.println("Connecting to database..." + courseName);
			connection = (Connection) DriverManager.getConnection(DB_URL,
					username, password);
			String courseSQL = "SELECT Count(*),sum(Credit),COURSE_NAME,CATEGORY FROM request WHERE COURSE_NAME LIKE '%"
					+ courseName + "%';";

			ps = connection.prepareStatement(courseSQL);
			rs = ps.executeQuery(courseSQL);

			boolean re = rs.next();
			if (re) {

				int id = rs.getInt("Count(*)");
				// int stdid = rs.getInt("STUDENT_ID");
				int offer = rs.getInt("sum(CREDIT)");
				String cour = rs.getString("COURSE_NAME");
				String category = rs.getString("CATEGORY");

				// Display values
				System.out.print("ID: " + id);
				Course course = new Course(id, offer, cour, category);
				courses.add(course);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// DBUtil.closeResultSet(rs);
			// DBUtil.closePreparedStatement(ps);
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courses;
	}

	public static ArrayList<Course1> getCourseList() {
		// ConnectionPool pool = ConnectionPool.getInstance();
		// Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Course1> courses = new ArrayList<Course1>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 3: Open a connection
			System.out.println("Connecting to database coursedb...");
			connection = (Connection) DriverManager.getConnection(DB_URL,
					username, password);
			String courseSQL = "SELECT * FROM COURSES ";

			ps = connection.prepareStatement(courseSQL);
			rs = ps.executeQuery(courseSQL);

			while (rs.next()) {
				Course1 course = new Course1();
				course.setCourseId(rs.getString("COURSE_ID"));
				course.setCourseName(rs.getString("COURSE_NAME"));
				course.setComments(rs.getString("COMMENTS"));
				course.setProfId(rs.getString("PROF_ID"));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// DBUtil.closeResultSet(rs);
			// DBUtil.closePreparedStatement(ps);
			// pool.freeConnection(connection);
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courses;
	}
}
