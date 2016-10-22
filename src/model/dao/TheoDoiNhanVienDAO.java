package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.TheoDoiNhanVienBEAN;

import utils.SQLServerConnUtils;

public class TheoDoiNhanVienDAO {

	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	
	public boolean themVangNghi(TheoDoiNhanVienBEAN vn) {
		try {
			String sql = "INSERT INTO THEODOINHANVIEN(Ngay, CoPhep, LyDo, idNhanVien) "
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, vn.getNgaynghi());
			pre.setInt(2, vn.getCoPhep());
			pre.setString(3,vn.getLydo());
			pre.setInt(4, vn.getIdNhanVien());
			
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0) return true; 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean suaTheoDoiNhanVien(TheoDoiNhanVienBEAN nv) {
		try {
			String sql = "Update THEODOINHANVIEN Set Ngay=?, CoPhep=?, LyDo=?, idNhanVien=?"
					+ "where id =? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, nv.getNgaynghi());
			pre.setInt(2, nv.getCoPhep());
			pre.setString(3,nv.getLydo());
			pre.setInt(4, nv.getIdNhanVien());
			pre.setInt(5, nv.getId());
			
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0) return true; 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean xoaTheoDoiNhanVien(int id) {
		try {
			String sql = "Delete from THEODOINHANVIEN where id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0) return true; 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<TheoDoiNhanVienBEAN> listTheoDoiNhanVien() {
		ArrayList<TheoDoiNhanVienBEAN> listTheoDoiNV = new ArrayList<>();
		try {
			String sql = "select * from THEODOINHANVIEN";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				TheoDoiNhanVienBEAN item = new TheoDoiNhanVienBEAN(rs.getInt("id"),rs.getString("Ngay"), rs.getBoolean("CoPhep"),
						rs.getString("LyDo"), rs.getInt("idNhanVien"));
				listTheoDoiNV.add(item);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listTheoDoiNV;
	}
	
	public ArrayList<TheoDoiNhanVienBEAN> getListVangNghiById(int maNV) {
		ArrayList<TheoDoiNhanVienBEAN> listTheoDoiNV = new ArrayList<>();
		try {
			String sql = "select THEODOINHANVIEN.id,Ngay,CoPhep,LyDo,idNhanVien, Ten from THEODOINHANVIEN, NHANVIEN " +
					"where idNhanVien= '"+ maNV+ "' AND idNhanVien = NHANVIEN.id;";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				TheoDoiNhanVienBEAN item = new TheoDoiNhanVienBEAN(rs.getInt("id"),rs.getString("Ngay"), rs.getBoolean("CoPhep"),
						rs.getString("LyDo"), rs.getInt("idNhanVien"),rs.getString("Ten"));
				listTheoDoiNV.add(item);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listTheoDoiNV;
	}
	
	public TheoDoiNhanVienBEAN getVangNghiById(int id){
		TheoDoiNhanVienBEAN td=  null;
		try {
			String sql = "select * from THEODOINHANVIEN " +
					"where id= '"+ id+ "';";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				td = new TheoDoiNhanVienBEAN(rs.getInt("id"),rs.getString("Ngay"), rs.getBoolean("CoPhep"),
						rs.getString("LyDo"), rs.getInt("idNhanVien"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return td;
	}
	
	public void deleteVangNghiById(int id){
		String sql = "DELETE FROM THEODOINHANVIEN WHERE id= '"+ id + "'";
		
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
