package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.bean.BaoDuongXeBEAN;
import utils.SQLServerConnUtils;

public class BaoDuongXeDAO {
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	
	public boolean themXeBaoDuong(BaoDuongXeBEAN baoDuongXeBEAN) {
		try {
			String sql = "INSERT INTO BAODUONGXE(SoTien, NgayBaoDuong, NgayBaoDuongTiepTheo, ChiTiet, idXe) "
					+ "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setLong(1, baoDuongXeBEAN.getSoTien());
			pre.setString(2, baoDuongXeBEAN.getNgayBaoDuong());
			pre.setString(3, baoDuongXeBEAN.getNgayBaoDuongTiepTheo());
			pre.setString(4, baoDuongXeBEAN.getChiTiet());
			pre.setInt(5, baoDuongXeBEAN.getIdXe());
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0) return true; 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
