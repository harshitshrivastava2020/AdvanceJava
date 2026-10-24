package in.co.rays.util;

import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {
// 1. Single class will provide connection with database.
// 2. Provide Reliable Connection with database.

	private static JDBCDataSource jdbc = null;
	private ComboPooledDataSource cdps = null;

	private JDBCDataSource() {
		// combopoolData source constructor call kiya h
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");

		cdps = new ComboPooledDataSource();
		try {
			cdps.setDriverClass("driver");
			cdps.setJdbcUrl("url");
//			cdps.setJdbcUrl("ModuleUrl");
			cdps.setUser("username");
			cdps.setPassword("password");
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
