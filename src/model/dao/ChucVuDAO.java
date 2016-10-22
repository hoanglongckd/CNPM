package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ChucVuBEAN;
import utils.SQLServerConnUtils;

public class ChucVuDAO {

	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	
	
	public boolean themChucVu(ChucVuBEAN chucvu) {
		try {
			String sql = "INSERT INTO ChucVu(MaChucVu, TenChucVu) "
					+ "VALUES (?, ?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, chucvu.getMaChucVu());
			pre.setString(2, chucvu.getTenChucVu());
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0) return true; 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean suaChucVu(ChucVuBEAN chucVu) {
		try {
			String sql = "Update ChucVu Set MaChucVu='?', TenChucVu= '?'"
					+ "where id =? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, chucVu.getMaChucVu());
			pre.setString(2, chucVu.getTenChucVu());
			pre.setInt(3, chucVu.getId());
			
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0) return true; 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean xoaChucVu(int idChucVu) {
		try {
			String sql = "Delete from ChucVu where id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, idChucVu);
			
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0) return true; 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<ChucVuBEAN> listChucVu() {
		ArrayList<ChucVuBEAN> listChucVu = new ArrayList<>();
		try {
			String sql = "select * from ChucVu";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				ChucVuBEAN item = new ChucVuBEAN(rs.getInt("id"),rs.getString("MaChucVu"), rs.getString("TenChucVu"));
				listChucVu.add(item);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listChucVu;
	}
	
	public ChucVuBEAN getChucVu(ChucVuBEAN chucVu) {
		ChucVuBEAN item =null;
		try {
			String sql = "select * from ChucVu where 1>0 ";
			
			System.out.println(sql);
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				item = new ChucVuBEAN(rs.getInt("id"),rs.getString("MaChucVu"), rs.getString("TenChucVu"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return item	;
	}
	
	
}
