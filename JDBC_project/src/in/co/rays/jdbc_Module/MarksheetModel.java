package in.co.rays.jdbc_Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksheetModel {
	public void add(MarksheetBean bean) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?)");

			pstmt.setInt(1, bean.getId());
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

	public void update(MarksheetBean bean) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");
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
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");

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

	public MarksheetBean findByPk(int id) throws Exception {
		Connection conn = null;
		MarksheetBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where id=?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new MarksheetBean();
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
	
	public MarksheetBean findByRollNo(int rollNo) throws Exception {
		Connection conn = null;
		MarksheetBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where rollNo=?");

			pstmt.setInt(1, rollNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new MarksheetBean();
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
}
