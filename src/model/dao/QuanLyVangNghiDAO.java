package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.QuanLyVangNghiBEAN;
import utils.SQLServerConnUtils;

public class QuanLyVangNghiDAO {
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	
	public ArrayList<QuanLyVangNghiBEAN> lietKeMaNV() {
		ArrayList<QuanLyVangNghiBEAN> list = new ArrayList<>();
		try {
			String sql = "SELECT NHANVIEN.id, NHANVIEN.MaNV "
					+ "FROM NHANVIEN "
					+ "WHERE NHANVIEN.idChucVu = (SELECT CHUCVU.id FROM CHUCVU WHERE CHUCVU.MaChucVu != 'AD') "
					+ "ORDER BY NHANVIEN.MaNV";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				QuanLyVangNghiBEAN item = new QuanLyVangNghiBEAN(rs.getInt("id"), rs.getString("MaNV"));
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean themMoiVangNghi (QuanLyVangNghiBEAN item) {
		try {
			String sql = "INSERT INTO THEODOINHANVIEN (Ngay, CoPhep, LyDo, idNhanVien) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item.getNgayNghi());
			ps.setBoolean(2, item.isCoPhep());
			ps.setNString(3, item.getLyDo());
			ps.setInt(4, item.getIdNhanVien());
			int valid = ps.executeUpdate();
			if (valid != 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<QuanLyVangNghiBEAN> lietKeVangNghi () {
		ArrayList<QuanLyVangNghiBEAN> list = new ArrayList<>();
		try {
			String sql = "SELECT NHANVIEN.id, NHANVIEN.MaNV, NHANVIEN.Ten, COUNT(THEODOINHANVIEN.id) AS TongNgayNghi "
					+ "FROM NHANVIEN, THEODOINHANVIEN "
					+ "WHERE NHANVIEN.id = THEODOINHANVIEN.idNhanVien "
					+ "GROUP BY NHANVIEN.id, NHANVIEN.MaNV, NHANVIEN.Ten";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				QuanLyVangNghiBEAN item = new QuanLyVangNghiBEAN(
						rs.getInt("id"), 
						rs.getInt("TongNgayNghi"), 
						rs.getString("MaNV"), 
						rs.getString("Ten"));
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public QuanLyVangNghiBEAN layChiTietNV (int idNhanVien) {
		QuanLyVangNghiBEAN item = new QuanLyVangNghiBEAN();
		try {
			String sql = "SELECT NHANVIEN.MaNV, NHANVIEN.Ten FROM NHANVIEN WHERE NHANVIEN.id = " + idNhanVien;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				item.setMaNV(rs.getString("MaNV"));
				item.setTenNV(rs.getString("Ten"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public ArrayList<QuanLyVangNghiBEAN> lietKeVangNghiMotNV(int idNhanVien) {
		ArrayList<QuanLyVangNghiBEAN> list = new ArrayList<>();
		try {
			String sql = "SELECT THEODOINHANVIEN.id, THEODOINHANVIEN.Ngay, "
					+ "THEODOINHANVIEN.CoPhep, THEODOINHANVIEN.LyDo "
					+ "FROM THEODOINHANVIEN "
					+ "WHERE THEODOINHANVIEN.idNhanVien = ? ORDER BY THEODOINHANVIEN.Ngay DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idNhanVien);
			rs = ps.executeQuery();
			while (rs.next()) {
				QuanLyVangNghiBEAN item = new QuanLyVangNghiBEAN(
						rs.getString("Ngay"), 
						rs.getString("LyDo"), 
						rs.getBoolean("CoPhep"), 
						rs.getInt("id"));
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public QuanLyVangNghiBEAN getCapNhapVangNghi (int id) {
		QuanLyVangNghiBEAN item = null;
		try {
			String sql = "SELECT NHANVIEN.MaNV, THEODOINHANVIEN.id, THEODOINHANVIEN.Ngay, "
					+ "THEODOINHANVIEN.CoPhep, THEODOINHANVIEN.LyDo, THEODOINHANVIEN.idNhanVien "
					+ "FROM THEODOINHANVIEN JOIN NHANVIEN "
					+ "ON THEODOINHANVIEN.idNhanVien = NHANVIEN.id "
					+ "WHERE THEODOINHANVIEN.id = " + id;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				item = new QuanLyVangNghiBEAN(
						rs.getString("MaNV"), 
						rs.getInt("id"), 
						rs.getString("Ngay"), 
						rs.getString("LyDo"), 
						rs.getBoolean("CoPhep"),
						rs.getInt("idNhanVien"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public boolean setCapNhapVangNghi (QuanLyVangNghiBEAN item) {
		try {
			String sql = "UPDATE THEODOINHANVIEN SET Ngay = ?, CoPhep = ?, LyDo = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item.getNgayNghi());
			ps.setBoolean(2, item.isCoPhep());
			ps.setNString(3, item.getLyDo());
			ps.setInt(4, item.getId());
			int valid = ps.executeUpdate();
			if (valid != 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean xoaVangNghi (int id) {
		try {
			String sql = "DELETE THEODOINHANVIEN WHERE id = " + id;
			st = conn.createStatement();
			int valid = st.executeUpdate(sql);
			if (valid != 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
