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
}
