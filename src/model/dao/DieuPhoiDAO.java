package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.DieuPhoiBEAN;
import model.bean.XeBEAN;
import utils.SQLServerConnUtils;

public class DieuPhoiDAO {
	
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	
	public boolean themDieuPhoi(DieuPhoiBEAN dieuphoi) {
		String sql = "insert into dieuphoi(DiaChiNhanKhach,LoaiXe) values(?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setNString(1, dieuphoi.getDiaChi());
			pstm.setInt(2, dieuphoi.getLoaiXe());
			
			int rowEffect = pstm.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getLoaiXe(int id) {
		String sql ="select LoaiXe from DIEUPHOI where id = " + id;
		   try{
			   Statement st = conn.createStatement();
			   ResultSet rs = st.executeQuery(sql);
			   int soCho = 0;
			   while(rs.next()){
				   soCho = rs.getInt("LoaiXe");
			   }
			   return soCho;
			   
		   }catch(Exception e){
			   return 0;
		   }
	}

	public int getMaxIDDieuPhoi() {
		String sql ="select max(id) from DIEUPHOI";
		   try{
			   Statement st = conn.createStatement();
			   ResultSet rs = st.executeQuery(sql);
			   int max= 0;
			   while(rs.next()){
				   max = rs.getInt(1);
			   }
			   return max;
			   
		   }catch(Exception e){
			   return 0;
		   }
	}

	public ArrayList<XeBEAN> lietKeListXeDieuPhoi(int loaiXe) {
		ArrayList<XeBEAN> listXe = new ArrayList<>();
		try {
			String sql = "select xe.id, TAIXE.Ten, xe.BienSoXe, xe.SoCho " + "From PHANCONGTX "
					+ "Join XE" + " On xe.id = PHANCONGTX.idXe" + " Join TAIXE " + "On TAIXE.id = PHANCONGTX.idTaiXe "
					+ "Where xe.SoCho = " + loaiXe;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				XeBEAN xe = new XeBEAN(rs.getInt("id"), rs.getString("Ten"), rs.getString("BienSoXe"), rs.getInt("SoCho"));
				listXe.add(xe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listXe;
	}

	public int getIDPhanCong(int id) {
		String sql ="select PHANCONGTX.id from PHANCONGTX where PHANCONGTX.idXe = " + id;
		   try{
			   Statement st = conn.createStatement();
			   ResultSet rs = st.executeQuery(sql);
			   int max= 0;
			   while(rs.next()){
				   max = rs.getInt(1);
			   }
			   return max;
			   
		   }catch(Exception e){
			   return 0;
		   }
	}

	public boolean updateIDPhanCong(DieuPhoiBEAN dieuphoi) {
		String sql = "UPDATE DIEUPHOI SET idPhanCong = ?, ThoiGianBatDau = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, dieuphoi.getIdPhanCong());
			ps.setString(2, dieuphoi.getThoiGianBatDau());
			ps.setInt(3, dieuphoi.getId());
			int rowEffect = ps.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<XeBEAN> getListDieuPhoi() {
		ArrayList<XeBEAN> listXe = new ArrayList<>();
		try {
			String sql = "SELECT TAIXE.Ten, XE.BienSoXe, DIEUPHOI.DiaChiNhanKhach, DIEUPHOI.ThoiGianBatDau FROM PHANCONGTX "
					+ "JOIN TAIXE ON PHANCONGTX.idTaiXe = TAIXE.id " 
					+ "JOIN XE ON PHANCONGTX.idXe = XE.id "
					+ "JOIN DIEUPHOI ON PHANCONGTX.id = DIEUPHOI.idPhanCong";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				XeBEAN xe = new XeBEAN(rs.getString("Ten"), rs.getString("BienSoXe"), rs.getString("DiaChiNhanKhach"), rs.getString("ThoiGianBatDau"));
				listXe.add(xe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listXe;
	}
	

}
