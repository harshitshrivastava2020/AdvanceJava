package in.co.rays.jdbc.preparedstatement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
//		testFindByLogin();
//		testFindByAuthenticate();
		testSearch();

	}

	public static void testAdd() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
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
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

		bean.setId(26);
		bean.setFirstName("Krishna");
		bean.setLastName("Yadav");
		bean.setLonginId("Krishna@gmail.com");
		bean.setPassword("krishna@12345");
		bean.setDob(sdf.parse("3228-07-19"));

		model.update(bean);
	}

	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		model.delete(69);

	}

	public static void testFindByPk() throws SQLException {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

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
		UserModel model = new UserModel();

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
		UserModel model = new UserModel();

		bean = model.authenticate("krishna@gmail.com", "krishna@123");

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLonginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());

	}

	public static void testSearch() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

//		bean.setFirstName("a");

		List<UserBean> list = model.search(bean, 1, 5);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLonginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println("=========================");
		}
	}
}
