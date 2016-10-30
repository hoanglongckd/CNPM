package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ThongKeLoiNhuanBEAN;
import utils.SQLServerConnUtils;

public class ThongKeLoiNhuanDAO {
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	
	public ArrayList<ThongKeLoiNhuanBEAN> thongKeTheoThang(String year, String month) {
		ArrayList<ThongKeLoiNhuanBEAN> lists = new ArrayList<>();
		try {
			String sql = "SELECT XE.BienSoXe, SUM(GIATIEN.ThanhTien) as Cost, SUM(BAODUONGXE.SoTien) as Spending "
					+ "FROM GIATIEN "
					+ "FULL JOIN DIEUPHOI ON GIATIEN.idDieuPhoi = DIEUPHOI.id "
					+ "FULL JOIN PHANCONGTX ON DIEUPHOI.idPhanCong = PHANCONGTX.id "
					+ "FULL JOIN XE ON XE.id = PHANCONGTX.idXe "
					+ "FULL JOIN BAODUONGXE ON XE.id = BAODUONGXE.idXe "
					+ "WHERE (YEAR(DIEUPHOI.ThoiGianBatDau) = ? AND MONTH(DIEUPHOI.ThoiGianBatDau) = ?) "
					+ "OR (YEAR(BAODUONGXE.NgayBaoDuong) = ? AND MONTH(BAODUONGXE.NgayBaoDuong) = ?) "
					+ "GROUP BY XE.BienSoXe";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, year);
			ps.setString(2, month);
			ps.setString(3, year);
			ps.setString(4, month);
			rs = ps.executeQuery();
			while(rs.next()) {
				ThongKeLoiNhuanBEAN list = new ThongKeLoiNhuanBEAN(
						rs.getString("BienSoXe"), 
						rs.getLong("Cost"), 
						rs.getLong("Spending"));
				lists.add(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}
}
