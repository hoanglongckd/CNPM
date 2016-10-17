package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.BaoDuongXeBEAN;
import model.bean.XeBEAN;
import utils.SQLServerConnUtils;

public class BaoDuongXeDAO {
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	
	
	public boolean themXeBaoDuong(BaoDuongXeBEAN baoDuongXeBEAN) {
		try {
			String sql = "INSERT INTO BAODUONGXE(SoTien, NgayBaoDuong, NgayBaoDuongTiepTheo, ChiTiet, idXe) "
					+ "VALUES (?, ?, ?, ?, ?)";
			System.out.println(baoDuongXeBEAN.getChiTiet());
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setLong(1, baoDuongXeBEAN.getSoTien());
			pre.setString(2, baoDuongXeBEAN.getNgayBaoDuong());
			pre.setString(3, baoDuongXeBEAN.getNgayBaoDuongTiepTheo());
			pre.setNString(4, baoDuongXeBEAN.getChiTiet());
			pre.setInt(5, baoDuongXeBEAN.getIdXe());
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0) return true; 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<XeBEAN> lietKeXe() {
		ArrayList<XeBEAN> listXe = new ArrayList<>();
		try {
			String sql = "select * from Xe";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				XeBEAN xe = new XeBEAN(rs.getInt("id"),rs.getString("BienSoXe"), rs.getString("Model"),
						rs.getInt("SoCho"), rs.getString("Hang"), rs.getBoolean("TinhTrangHoatDong"));
				listXe.add(xe);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listXe;
	}
	
	public ArrayList<BaoDuongXeBEAN> lietKeDanhSachBaoDuong() {
		ArrayList<BaoDuongXeBEAN> baoDuongXeBEANs = new ArrayList<>();
		try {
			String sql = "SELECT XE.BienSoXe, XE.Model, BAODUONGXE.id, "
					+ "BAODUONGXE.NgayBaoDuong, BAODUONGXE.NgayBaoDuongTiepTheo, BAODUONGXE.SoTien "
					+ "FROM XE, BAODUONGXE "
					+ "WHERE BAODUONGXE.idXe = XE.id;";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BaoDuongXeBEAN baoDuongXeBEAN = new BaoDuongXeBEAN(
						rs.getInt("id"), 
						rs.getLong("soTien"), 
						rs.getString("ngayBaoDuong"), 
						rs.getString("ngayBaoDuongTiepTheo"), 
						rs.getString("bienSoXe"), 
						rs.getString("model"));
				baoDuongXeBEANs.add(baoDuongXeBEAN);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return baoDuongXeBEANs;
	}
	
	public BaoDuongXeBEAN chiTietXeBaoDuong(int id) {
		BaoDuongXeBEAN baoDuongXeBEAN = null;
		try {
			String sql = "SELECT XE.BienSoXe, XE.Model, XE.SoCho, "
					+ "BAODUONGXE.id, BAODUONGXE.SoTien, BAODUONGXE.ChiTiet "
					+ "FROM BAODUONGXE JOIN XE "
					+ "ON BAODUONGXE.idXe = XE.id "
					+ "WHERE BAODUONGXE.id = " + id;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				baoDuongXeBEAN = new BaoDuongXeBEAN(
						rs.getInt("id"),
						rs.getString("chiTiet"), 
						rs.getLong("soTien"), 
						rs.getInt("soCho"), 
						rs.getString("bienSoXe"), 
						rs.getString("model"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baoDuongXeBEAN;
	}
	
	public boolean xoaXeBaoDuong(int id) {
		try {
			String sql = "DELETE FROM BAODUONGXE WHERE id = " + id;
			st = conn.createStatement();
			int rowEffect = st.executeUpdate(sql);
			if (rowEffect != 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public BaoDuongXeBEAN getSuaXe(int id) {
		BaoDuongXeBEAN baoDuongXeBEAN = null;
		try {
			String sql = "SELECT BAODUONGXE.id, XE.BienSoXe, BAODUONGXE.NgayBaoDuong, "
					+ "BAODUONGXE.NgayBaoDuongTiepTheo, BAODUONGXE.SoTien, BAODUONGXE.ChiTiet "
					+ "FROM BAODUONGXE "
					+ "JOIN XE "
					+ "ON BAODUONGXE.idXe = XE.id "
					+ "WHERE BAODUONGXE.id = " + id;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				baoDuongXeBEAN = new BaoDuongXeBEAN(
						rs.getInt("id"), 
						rs.getString("ChiTiet"), 
						rs.getLong("SoTien"), 
						rs.getString("NgayBaoDuong"), 
						rs.getString("NgayBaoDuongTiepTheo"), 
						rs.getString("BienSoXe"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("baoDuongXeBEAN in DAO");
//		System.out.println(baoDuongXeBEAN.getBienSoXe());
		return baoDuongXeBEAN;
	}
}
