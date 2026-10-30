package in.co.rays.bean;

public class StudentBean {
	private int id;
	private String firstName;
	private String lastName;
	private long mobile;
	private String subject;
	private int age;
	private String gender;
	private String city;

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

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getMobile() {
		return mobile;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

}
