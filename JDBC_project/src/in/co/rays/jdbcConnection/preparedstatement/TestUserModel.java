package in.co.rays.jdbcConnection.preparedstatement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
//		testFindByLogin();
		testFindByAuthenticate();
	}

	public static void testAdd() throws Exception {
		UserBean bean = new UserBean();
		UserModal model = new UserModal();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

		bean.setId(26);
		bean.setFirstName("Krishna");
		bean.setLastName("Yadav");
		bean.setLonginId("Krishna@gmail.com");
		bean.setPassword("krishna@123");
		bean.setDob(sdf.parse("3228-07-19"));

		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		UserModal model = new UserModal();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

		bean.setId(69);
		bean.setFirstName("Krishna");
		bean.setLastName("Yadav");
		bean.setLonginId("Krishna@gmail.com");
		bean.setPassword("krishna@12345");
		bean.setDob(sdf.parse("3228-07-19"));

		model.update(bean);
	}

	public static void testDelete() throws Exception {
		UserModal model = new UserModal();
		model.delete(69);

	}
	public static void testFindByPk() throws SQLException {
		UserBean bean = new UserBean();
		UserModal model = new UserModal();
		
		bean = model.findByPk(26);
		
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLonginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		
	}
	public static void testFindByLogin() throws SQLException {
		UserBean bean = new UserBean();
		UserModal model = new UserModal();
		
		bean = model.findByLogin("clee@gmail.com");
		
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLonginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		
	}
	
	public static void testFindByAuthenticate() throws SQLException {
		UserBean bean = new UserBean();
		UserModal model = new UserModal();
		
		bean = model.authenticate("krishna@gmail.com", "krishna@123");
		
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLonginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		
	}
}
