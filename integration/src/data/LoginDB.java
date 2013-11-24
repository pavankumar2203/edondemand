package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.Login;

public class LoginDB {

	public static Login getLogin(String userId, String pwd) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		Login login = null;

		try {
			String loginSQL = "SELECT * "
					+ "FROM LOGIN "
					+ "WHERE USER_ID = '" + userId + "' AND PWD = '"
					+ pwd + "';";

			ps = connection.prepareStatement(loginSQL);
			rs = ps.executeQuery(loginSQL);

			if (rs.next()) {
				login = new Login();
				login.setStudentId(rs.getString("STUDENT_ID"));
				login.setUserId(rs.getString("USER_ID"));
				login.setPwd(rs.getString("PWD"));
				
				return login;
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
