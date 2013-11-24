package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Course;

public class CourseDB {
	public static ArrayList<Course> searchCourse(String courseName) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Course> courses = new ArrayList<Course>();

		try {
			String courseSQL = "SELECT * "
					+ "FROM COURSES "
					+ "WHERE COURSE_NAME LIKE '%" + courseName + "%';";

			ps = connection.prepareStatement(courseSQL);
			rs = ps.executeQuery(courseSQL);

			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getString("COURSE_ID"));
				course.setCourseName(rs.getString("COURSE_NAME"));
				course.setComments(rs.getString("COMMENTS"));
				course.setProfId(rs.getString("PROF_ID"));
				courses.add(course);
			}
			return courses;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
	
	public static ArrayList<Course> getCourseList() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Course> courses = new ArrayList<Course>();

		try {
			String courseSQL = "SELECT * FROM COURSES ";

			ps = connection.prepareStatement(courseSQL);
			rs = ps.executeQuery(courseSQL);

			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getString("COURSE_ID"));
				course.setCourseName(rs.getString("COURSE_NAME"));
				course.setComments(rs.getString("COMMENTS"));
				course.setProfId(rs.getString("PROF_ID"));
				courses.add(course);
			}
			return courses;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

}
