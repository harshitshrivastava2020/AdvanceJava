package in.co.rays.jdbcConnection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestDelete {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");

		System.out.println("connection established successfully ..." + conn.getCatalog());

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from student where id =67");

		System.out.println(i + "row afftected (deleted)");

	}
}
