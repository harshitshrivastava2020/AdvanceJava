package in.co.rays.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsertion {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");

		System.out.println("connection establish successfuly ... " + conn.getCatalog());

		Statement stmt = conn.createStatement();

 		int i = stmt.executeUpdate(
				"insert into student values(67,'Pooja','Shrivastava','2378465016','Maths','18',' female','pooja@gmail.com','Bhopal','98')");
		System.out.println(i + " one row affected");
	}
}
