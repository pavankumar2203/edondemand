package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Course1;

public class CourseDB {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/edondem";
	// Database credentials
	private static String username = "root";
	private static String password = "root";
	private static Connection connection = null;
	
	public static ArrayList<Course1> searchCourse(String courseName) {
		
		//ConnectionPool pool = ConnectionPool.getInstance();
		//Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Course1> courses = new ArrayList<Course1>();

		try {
			Class.forName(JDBC_DRIVER);
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
			String courseSQL = "SELECT * "
					+ "FROM COURSES "
					+ "WHERE COURSE_NAME LIKE '%" + courseName + "%';";

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
			//DBUtil.closeResultSet(rs);
			//DBUtil.closePreparedStatement(ps);
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
		//ConnectionPool pool = ConnectionPool.getInstance();
		//Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Course1> courses = new ArrayList<Course1>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 3: Open a connection
			System.out.println("Connecting to database coursedb...");
			connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
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
			//DBUtil.closeResultSet(rs);
			//DBUtil.closePreparedStatement(ps);
			//pool.freeConnection(connection);
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
