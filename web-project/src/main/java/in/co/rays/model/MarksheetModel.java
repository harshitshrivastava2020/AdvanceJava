package in.co.rays.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.MarkSheetBean;
import in.co.rays.util.JDBCDataSource;

public class MarkSheetModel {
	
	public int nextPk() throws SQLException {
		
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_marksheet");

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
	
	public void add(MarkSheetBean bean) throws Exception {
		Connection conn = null;
		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?)");

			pstmt.setInt(1, nextPk());
			pstmt.setInt(2, bean.getRollNo());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhysics());
			pstmt.setInt(5, bean.getChemistry());
			pstmt.setInt(6, bean.getMaths());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored inserted successfully: " + i + " one row affected");

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void update(MarkSheetBean bean) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_marksheet set rollNo = ?, name = ?, phy = ?, chm = ?, maths = ? where id = ?");
			pstmt.setInt(1, bean.getRollNo());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPhysics());
			pstmt.setInt(4, bean.getChemistry());
			pstmt.setInt(5, bean.getMaths());
			pstmt.setInt(6, bean.getId());

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

			PreparedStatement pstmt = conn.prepareStatement("delete from st_marksheet where id = ?");

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

	public MarkSheetBean findByPk(int id) throws Exception {
		Connection conn = null;
		MarkSheetBean bean = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where id=?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new MarkSheetBean();
				bean.setId(rs.getInt("id"));
				bean.setRollNo(rs.getInt("rollNo"));
				bean.setName(rs.getString("name"));
				bean.setPhysics(rs.getInt("phy"));
				bean.setChemistry(rs.getInt("chm"));
				bean.setMaths(rs.getInt("maths"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;
	}
	
	public MarkSheetBean findByRollNo(int rollNo) throws Exception {
		Connection conn = null;
		MarkSheetBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where rollNo=?");

			pstmt.setInt(1, rollNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new MarkSheetBean();
				bean.setId(rs.getInt("id"));
				bean.setRollNo(rs.getInt("rollNo"));
				bean.setName(rs.getString("name"));
				bean.setPhysics(rs.getInt("phy"));
				bean.setChemistry(rs.getInt("chm"));
				bean.setMaths(rs.getInt("maths"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;
	} 
	
	
	public List<MarkSheetBean> search(MarkSheetBean bean, int pageNo, int pageSize) throws Exception {
		List<MarkSheetBean> list = new ArrayList<MarkSheetBean>();
		Connection conn = null;
		StringBuffer sql = new StringBuffer("select * from st_marksheet where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getRollNo() > 0) {
				sql.append(" and rollNo = " + bean.getRollNo());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getPhysics() > 0) {
				sql.append(" and physics = " + bean.getPhysics());
			}
			if (bean.getChemistry() > 0) {
				sql.append(" and chemistry = " + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sql.append(" and maths = " + bean.getMaths());
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
				bean = new MarkSheetBean();
				bean.setId(rs.getInt("id"));
				bean.setRollNo(rs.getInt("rollNo"));
				bean.setName(rs.getString("name"));
				bean.setPhysics(rs.getInt("physics"));
				bean.setChemistry(rs.getInt("chemistry"));
				bean.setMaths(rs.getInt("maths"));
				
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


