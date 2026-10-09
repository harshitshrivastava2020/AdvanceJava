package in.co.rays.jdbc.util;

import java.util.Date;

public class UserBean {

	private int id;
	private String firstName;
	private String lastName;
	private String longinId;
	private String password;
	private Date dob;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLonginId(String longinId) {
		this.longinId = longinId;
	}

	public String getLonginId() {
		return longinId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDob() {
		return dob;
	}

}
