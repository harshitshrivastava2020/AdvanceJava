package in.co.rays.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {
	public static void main(String[] args) throws Exception {

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");
			conn.setAutoCommit(false);
			System.out.println("connection established successfully: " + conn.getCatalog());
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(
					"insert into student values(68, 'krishna', 'Prajapati','2937017395','physics',22,'male', 'krishna@gmail.com', 'Mathura', '100')");
			conn.commit();
			System.out.println("record inserted " + i + " row affected");
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
}
