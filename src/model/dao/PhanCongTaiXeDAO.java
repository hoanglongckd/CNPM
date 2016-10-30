package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.bean.PhanCongTaiXeBEAN;
import utils.SQLServerConnUtils;

public class PhanCongTaiXeDAO {
	static Connection conn = SQLServerConnUtils.getSQLServerConnection();
	public static boolean themPhanCongTaiXe(PhanCongTaiXeBEAN phanCongTaiXeBEAN) {
		try {
			String sql = "INSERT INTO PHANCONGTX(idTaiXe, idCa, idThuNgay) "
					+ "VALUES(?, ?, ?)";
			//System.out.println(nhanVienBEAN.getMaNhanVien() + nhanVienBEAN.getHoTen() + nhanVienBEAN.getIdChucVu());
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, phanCongTaiXeBEAN.getIdTaiXe());
			pre.setInt(2, phanCongTaiXeBEAN.getIdCa());
			pre.setInt(3, phanCongTaiXeBEAN.getIdThuNgay());
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0)
				return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
	}
	
}
