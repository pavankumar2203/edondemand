package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.Request;

public class RequestDB {

	public static boolean addRequest(Request request) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;

		String requestSQL = "INSERT INTO COURSE_ID (STUDENT_ID, COURSE_NAME, OFFER, CATEGORY) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(requestSQL);
			ps.setString(1, request.getStudentId());
			ps.setString(2, request.getCourseName());
			ps.setString(3, request.getOffer());
			ps.setString(4, request.getCategory());

			return ps.executeUpdate() == 1; 
											
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
}
