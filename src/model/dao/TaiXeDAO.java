package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.PhanCongTaiXeBEAN;
import model.bean.TaiXeBEAN;
import model.bean.XeBEAN;
import utils.SQLServerConnUtils;

public class TaiXeDAO {
	static Connection conn = SQLServerConnUtils.getSQLServerConnection();
	static ResultSet rs;
	static Statement st;
	
	public List<TaiXeBEAN> getAllMaTX(){

		   List<TaiXeBEAN> listMaTX = new ArrayList<TaiXeBEAN>();
		   String sql ="select id,MaTX from TAIXE";
		   try{
			   Statement st = conn.createStatement();
			   ResultSet rs = st.executeQuery(sql);
			   while(rs.next()){
				   int id = rs.getInt(1);
				   String maTX = rs.getString(2);
				   TaiXeBEAN list = new TaiXeBEAN(id,maTX);
				   listMaTX.add(list);
			   }
			   return listMaTX;
		   }catch(Exception e){
			  return null;
		   }      
	 
	   }

	public List<TaiXeBEAN> getAllTenTX() {
		
		List<TaiXeBEAN> listTX = new ArrayList<TaiXeBEAN>();
		   String sql ="select id,Ten from TAIXE";
		   try{
			   Statement st = conn.createStatement();
			   ResultSet rs = st.executeQuery(sql);
			   while(rs.next()){
				   int id = rs.getInt(1);
				   String tenTX = rs.getString(2);
				   TaiXeBEAN list = new TaiXeBEAN(id,tenTX);
				   listTX.add(list);
			   }
			   return listTX;
		   }catch(Exception e){
			  return null;
		   }      
	}
	public boolean addTaiXe(TaiXeBEAN taiXeBEAN) {
		try {
			String sqlThemTaiXe = "INSERT INTO TAIXE(MaTX, Ten, NgaySinh) "
					+ "VALUES(?, ?, ?)";
			//System.out.println(nhanVienBEAN.getMaNhanVien() + nhanVienBEAN.getHoTen() + nhanVienBEAN.getIdChucVu());
			PreparedStatement pre = conn.prepareStatement(sqlThemTaiXe);
			pre.setString(1, taiXeBEAN.getMaTaiXe());
			pre.setNString(2, taiXeBEAN.getHoTen());
			pre.setString(3, taiXeBEAN.getNgaySinh());
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0)
				return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
	}

	public ArrayList<TaiXeBEAN> getDanhSachTaiXe() {
		ArrayList<TaiXeBEAN> listTaiXe = new ArrayList<>();
		try {
			String sql = "select * from TaiXe";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				TaiXeBEAN taiXe = new TaiXeBEAN(rs.getInt("id"),rs.getString("MaTX"), rs.getString("Ten"), rs.getString("NgaySinh"));
				listTaiXe.add(taiXe);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listTaiXe;
	}
	
	public boolean isTaiXeDeleted(String idTaiXe) {
		try{
			String sql="DELETE FROM TAIXE where Id="+idTaiXe;
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			if(preparedStatement.executeUpdate()<1) return false;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}

	public TaiXeBEAN getTaiXe(String idTaiXe) {
		TaiXeBEAN taiXe = new TaiXeBEAN();
		try {
			String sql = "select * from TAIXE where Id="+idTaiXe;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				taiXe = new TaiXeBEAN(rs.getInt("id"),rs.getString("MaTX"), rs.getString("Ten"), rs.getString("NgaySinh"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return taiXe;
	}

	public boolean setSuaTaiXe(TaiXeBEAN taiXeBEAN) {
		String sql = "UPDATE TAIXE SET "
				+ "Ten = ?, NgaySinh = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, taiXeBEAN.getHoTen());
			ps.setString(2, taiXeBEAN.getNgaySinh());
			ps.setInt(3, taiXeBEAN.getId());
				int rowEffect = ps.executeUpdate();
			if (rowEffect != 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addPhanCongTaiXe(PhanCongTaiXeBEAN phanCongTaiXeBEAN) {
		try {
			String sql = "INSERT INTO PHANCONGTX(idTaiXe, idCa, idThuNgay, idXe) "
					+ "VALUES(?, ?, ?)";
			//System.out.println(nhanVienBEAN.getMaNhanVien() + nhanVienBEAN.getHoTen() + nhanVienBEAN.getIdChucVu());
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, phanCongTaiXeBEAN.getIdTaiXe());
			pre.setInt(2, phanCongTaiXeBEAN.getIdCa());
			pre.setInt(3, phanCongTaiXeBEAN.getIdThuNgay());
			pre.setInt(4, phanCongTaiXeBEAN.getIdXe());
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public ArrayList<XeBEAN> getListXe() {
		 ArrayList<XeBEAN> listXe = new ArrayList<>();
		   String sql ="select * from XE";
		   try{
			   Statement st = conn.createStatement();
			   ResultSet rs = st.executeQuery(sql);
			   while(rs.next()){
					XeBEAN xe = new XeBEAN(rs.getInt("id"),rs.getString("BienSoXe"), rs.getString("Model"), rs.getInt("SoCho"),rs.getString("Hang"),rs.getBoolean("TinhTrangHoatDong"));
					listXe.add(xe);
			   }
		   }catch(Exception e){
			  return null;
		   }    
		   return listXe;

	}
	
}
