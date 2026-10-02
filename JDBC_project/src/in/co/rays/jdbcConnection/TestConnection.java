package in.co.rays.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {
	public static void main(String[] args) throws Exception {

		// step 1. Load Driver Class into the class loader //driver is a class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 2. Make Connection to the database//connection is a interface that why
		// use driverManager.getconnection method()
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");

		System.out.println("connection established succrssfully ..... " + conn.getCatalog());

		// step 3. create Statement and get ResultSet or insert, update and delete
		// records //statement is a interface that why use connection.createStatement ()
		Statement stmt = conn.createStatement();

		// step 4 get records
		ResultSet rs = stmt.executeQuery("select * from student");

		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("first_name"));
			System.out.println(rs.getString("last_name"));
			System.out.println(rs.getString("mobile"));
			System.out.println(rs.getString("subject"));
			System.out.println(rs.getInt("age"));
			System.out.println(rs.getString("gender"));
			System.out.println(rs.getString("email"));

		}
	}
}
