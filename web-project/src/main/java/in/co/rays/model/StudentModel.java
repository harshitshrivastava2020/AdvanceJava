package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.StudentBean;
import in.co.rays.util.JDBCDataSource;

public class StudentModel {

	public int nextPk() throws SQLException {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select max(id) from student");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return pk + 1;

	}

	public void add(StudentBean bean) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPk());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setLong(4, bean.getMobile());
			pstmt.setString(5, bean.getSubject());
			pstmt.setInt(6, bean.getAge());
			pstmt.setString(7, bean.getGender());
			pstmt.setString(8, bean.getCity());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored inserted successfully: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	public void update(StudentBean bean) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update student set firstName = ?, lastName = ?, mobile = ?, subject = ?, age = ?, gender = ?, city = ? where id = ?");
			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setLong(3, bean.getMobile());
			pstmt.setString(4, bean.getSubject());
			pstmt.setInt(5, bean.getAge());
			pstmt.setString(6, bean.getGender());
			pstmt.setString(7, bean.getCity());
			pstmt.setInt(8, bean.getId());
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored update successfully: " + i + " one row affected");

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void delete(int id) throws Exception {
		Connection conn = null;
		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from student where id = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("recored delete successfully: " + i + " one row affected");

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public StudentBean findByPk(int id) throws Exception {
		Connection conn = null;
		StudentBean bean = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from student where id=?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setMobile(rs.getLong("mobile"));
				bean.setSubject(rs.getString("subject"));
				bean.setAge(rs.getInt("age"));
				bean.setGender(rs.getString("gender"));
				bean.setCity(rs.getString("city"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;
	}

	public List<StudentBean> search(StudentBean bean, int pageNo, int pageSize) throws Exception {
		List<StudentBean> list = new ArrayList<StudentBean>();
		Connection conn = null;
		StringBuffer sql = new StringBuffer("select * from student where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstName() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and lastName like '" + bean.getLastName() + "%'");
			}
			if (bean.getMobile() > 0) {
				sql.append(" and mobile like '" + bean.getMobile() + "%'");
			}
			if (bean.getSubject() != null && bean.getSubject().length() > 0) {
				sql.append(" and subject like '" + bean.getSubject() + "%'");
			}
			if (bean.getAge() > 0) {
				sql.append(" and age = " + bean.getAge());
			}
			if (bean.getGender() != null && bean.getGender().length() > 0) {
				sql.append(" and gender like '" + bean.getGender() + "%'");
			}
			if (bean.getCity() != null && bean.getCity().length() > 0) {
				sql.append(" and city like '" + bean.getCity() + "%'");
			}
		}

		if (pageSize > 0) {
			int index = (pageNo - 1) * pageSize;
			sql.append(" limit " + index + ", " + pageSize);
		}

		System.out.println("sql ===> " + sql.toString());

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setMobile(rs.getLong("mobile"));
				bean.setSubject(rs.getString("subject"));
				bean.setAge(rs.getInt("age"));
				bean.setGender(rs.getString("gender"));
				bean.setCity(rs.getString("city"));
				list.add(bean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return list;
	}

}
