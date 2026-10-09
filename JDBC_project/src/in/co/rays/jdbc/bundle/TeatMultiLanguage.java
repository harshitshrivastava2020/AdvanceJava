package in.co.rays.jdbc.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TeatMultiLanguage {
public static void main(String[] args) {
	
 	ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.jdbc.bundle.app", new Locale("hi")); //pick app_hi file
	String greeting = rb.getString("greeting");
	System.out.println(greeting);
	
//	ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.jdbc.bundle.app", new Locale("sp")); //pick app_sp file
//	String greeting = rb.getString("greeting");
//	System.out.println(greeting);
	
//	ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.jdbc.bundle.app", new Locale("mthi")); //pick app_mthi file
//	String greeting = rb.getString("greeting");
//	System.out.println(greeting);
	
	
}
}
