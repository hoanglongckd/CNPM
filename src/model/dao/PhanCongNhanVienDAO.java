package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.bean.PhanCongNhanVienBEAN;
import utils.SQLServerConnUtils;

public class PhanCongNhanVienDAO {
	static Connection conn = SQLServerConnUtils.getSQLServerConnection();
	public static boolean themPhanCongNhanVien(PhanCongNhanVienBEAN phanCongNhanVienBEAN) {
		try {
			String sql = "INSERT INTO PHANCONGNV(idNhanVien, idCa, idThuNgay) "
					+ "VALUES(?, ?, ?)";
			//System.out.println(nhanVienBEAN.getMaNhanVien() + nhanVienBEAN.getHoTen() + nhanVienBEAN.getIdChucVu());
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, phanCongNhanVienBEAN.getIdNhanVien());
			pre.setInt(2, phanCongNhanVienBEAN.getIdCa());
			pre.setInt(3, phanCongNhanVienBEAN.getIdThuNgay());
			int rowEffect = pre.executeUpdate();
			if (rowEffect != 0)
				return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
	}

}
