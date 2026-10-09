package in.co.rays.jdbc.util;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {
// 1. Single class will provide connection with database.
// 2. Provide Reliable Connection with database.

	private static JDBCDataSource jdbc = null;
	private ComboPooledDataSource cdps = null;

	private JDBCDataSource() {
		cdps = new ComboPooledDataSource();
		try {
			cdps.setDriverClass("com.mysql.cj.jdbc.Driver");
			cdps.setJdbcUrl("jdbc:mysql://localhost:3306/testing");
			cdps.setUser("root");
			cdps.setPassword("root");
			cdps.setMaxPoolSize(30);
			cdps.setMinPoolSize(10);
			cdps.setInitialPoolSize(10);
			cdps.setAcquireIncrement(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static JDBCDataSource getInstance() {
		if (jdbc == null) {
			jdbc = new JDBCDataSource();
			return jdbc;
		}
		return jdbc;

	}

	public static Connection getConnection() {
		try {
			return getInstance().cdps.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void trnRollBack(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
