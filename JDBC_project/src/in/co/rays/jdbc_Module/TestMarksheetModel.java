package in.co.rays.jdbc_Module;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
		testFindByPk();
//		testfindByRollNo();

	}

	public static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean.setId(17);
		bean.setRollNo(116);
		bean.setName("Krishna");
		bean.setPhysics(100);
		bean.setChemistry(100);
		bean.setMaths(100);

		model.add(bean);

	}

	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean.setRollNo(116);
		bean.setName("Krishna");
		bean.setPhysics(100);
		bean.setChemistry(100);
		bean.setMaths(100);
		bean.setId(16);

		model.update(bean);

	}

	public static void testDelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.delete(17);
	}

	public static void testFindByPk() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean = model.findByPk(15);

		System.out.println(bean.getId());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getName());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());

	}

	public static void testfindByRollNo() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean = model.findByRollNo(110);

		System.out.println(bean.getId());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getName());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());

	}
}
