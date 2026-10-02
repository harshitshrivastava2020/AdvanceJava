package in.co.rays.Module_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HotelModule {
public static void main(String[] args) throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");
	
	Statement stmt = conn.createStatement();
		
	 String actionType = "FETCH";
	
	
	 
	 switch (actionType.toUpperCase()) {
	    case "FETCH":
	        ResultSet rs = stmt.executeQuery("select * from hotel");
	    	while(rs.next()) {
	    		System.out.println(rs.getInt("hotelId"));
	    		System.out.println(rs.getString("hotelName"));
	    		System.out.println(rs.getString("location"));
	    		System.out.println(rs.getDouble("rating"));
	    		System.out.println(rs.getString("contactNo"));
	        break;}

	    case "INSERT":
	    	int a = stmt.executeUpdate(
	    			"insert into student values(67,'Pooja','Shrivastava','2378465016','Maths','18',' female','pooja@gmail.com','Bhopal','98')");
	    	System.out.println(a + " one row affected");
	        break;

	    case "DELETE":
	    	int b = stmt.executeUpdate("delete from student where id =67");

	    	System.out.println(b + "row afftected (deleted)");
	        break;

	    default:
	        System.out.println("No matching query found.");
	}
}
}
