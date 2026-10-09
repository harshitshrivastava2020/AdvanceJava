package in.co.rays.jdbc.bundle;

import java.util.ResourceBundle;

public class TestBundle {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.jdbc.bundle.app");

		System.out.println(rb.getString("driver"));
	}
}
