/**
 * 
 * This gets a db connection
 * @author: Pavan Kumar Sunder and Susan Chun Xu
 * 
 * 
 */

package data;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionPool {

	private static ConnectionPool pool = null;
	private static DataSource dataSource = null;

	private ConnectionPool() {
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/telecom");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}

	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	public void freeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
