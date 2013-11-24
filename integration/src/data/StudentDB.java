package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.Student;

public class StudentDB {
	public static Student getStudent(String studentId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;

		try {
			String studentSQL = "SELECT * FROM STUDENTS "
					+ "WHERE STUDENT_ID = " + studentId + ";";
			ps = connection.prepareStatement(studentSQL);
			rs = ps.executeQuery(studentSQL);

			if (rs.next()) {
				student = new Student();
				student.setStudentId(rs.getString("STUDENT_ID"));
				student.setStudFname(rs.getString("STUD_FNAME"));
				student.setStudLname(rs.getString("STUD_LNAME"));
				student.setStudGender(rs.getString("STUD_GENDER"));
				student.setStudAge(rs.getString("STUD_AGE"));
				student.setStudEmail(rs.getString("STUD_EMAIL"));
				student.setStudScore(rs.getString("STUD_SCORE"));

				return student;
			} else {
				return null;
			}
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
