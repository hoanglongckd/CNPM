package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.TaiXeBEAN;
import model.bean.XeBEAN;
import utils.SQLServerConnUtils;

public class XeDAO {

	// Connect database
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;

	//insert xe to xe table in databse
	public boolean themXe(XeBEAN xe) {
		String sql = "insert into xe values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, xe.getBienSoXe());
			pstm.setNString(2, xe.getModel());
			pstm.setInt(3, xe.getSoCho());
			pstm.setNString(4, xe.getHang());
			pstm.setString(5, String.valueOf(xe.isTinhTrangHoatDong()));
			pstm.setNString(6, xe.getGhiChu());
			int rowEffect = pstm.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//insert to phancongtx table
	public boolean themPhanCongTX(TaiXeBEAN taixe, XeBEAN xe) {
		String sql = "insert into phancongtx(idTaiXe, idXe) values(?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, taixe.getId());
			pstm.setInt(2, xe.getId());
			int rowEffect = pstm.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//get max idxe
	public int getMaxXeId() {
		String sql = "select max(id) from XE";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int max = 0;
			while (rs.next()) {
				max = rs.getInt(1);
			}
			return max;
		} catch (Exception e) {
			return 0;
		}
	}

	//get list xe
	public ArrayList<XeBEAN> lietKeListXe() {
		ArrayList<XeBEAN> listXe = new ArrayList<>();
		try {
			String sql = "select xe.id, xe.BienSoXe, xe.Model, xe.SoCho, xe.Hang From XE";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				XeBEAN xe = new XeBEAN(rs.getInt("id"), rs.getString("BienSoXe"), rs.getString("Model"),
						rs.getInt("SoCho"), rs.getString("Hang"));
				listXe.add(xe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listXe;
	}

	//delete xe
	public boolean xoaXe(int id) {
		try {
			String sql = "DELETE FROM XE WHERE id = " + id;
			String sql2 = "DELETE FROM PHANCONGTX WHERE idXe = " + id;
			st = conn.createStatement();
			st.executeUpdate(sql2);
			int rowEffect = st.executeUpdate(sql);
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//get xe to display to update form
	public XeBEAN getCapNhatXe(int id) {
		XeBEAN xebean = null;
		try {
			String sql = "SELECT XE.id, XE.BienSoXe, XE.Model, XE.SoCho, XE.hang, XE.GhiChu" + " FROM XE WHERE XE.id = "
					+ id;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				xebean = new XeBEAN(rs.getInt("id"), rs.getString("BienSoXe"), rs.getString("Model"),
						rs.getInt("SoCho"), rs.getString("Hang"), rs.getString("GhiChu"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xebean;
	}

	//update xe
	public boolean setCapNhatXe(XeBEAN xe) {
		String sql = "UPDATE XE SET " + "Model = ?, SoCho = ?" + ", Hang = ?, GhiChu = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setNString(1, xe.getModel());
			ps.setInt(2, xe.getSoCho());
			ps.setNString(3, xe.getHang());
			ps.setNString(4, xe.getGhiChu());
			ps.setInt(5, xe.getId());

			int rowEffect = ps.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//update phancongtx
	public boolean setCapNhatPhanCongTX(TaiXeBEAN taixe, XeBEAN xe) {
		String sql = "UPDATE PHANCONGTX SET idTaiXe = ? WHERE idXe = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, taixe.getId());
			ps.setInt(2, xe.getId());
			int rowEffect = ps.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
