package model.dao.NhanVien;

import model.bean.NhanVien.NhanVienBEAN;
import utils.SQLServerConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AddNhanVienDAO {

	public static boolean addNhanVien(NhanVienBEAN nhanVienBEAN) {
		Connection conn = SQLServerConnUtils.getSQLServerConnection();
		try {
				int chucVu = nhanVienBEAN.getChucVu();
				// Them nhan vien
				if (chucVu == 1) {
					String sqlThemNhanVien = "INSERT INTO NHANVIEN(MaNV, Password, Ten, NgaySinh, idChucVu) "
							+ "VALUES(?, ?, ?, ?,?)";
					PreparedStatement pre = conn.prepareStatement(sqlThemNhanVien);
					pre.setString(1, nhanVienBEAN.getMaNhanVien());
					pre.setString(2, "123456"); // Mat khau mac dinh
					pre.setString(3, nhanVienBEAN.getHoTen());
					pre.setString(4, nhanVienBEAN.getNgaySinh());
					pre.setInt(5, nhanVienBEAN.getChucVu());
					int rowEffect = pre.executeUpdate();
					if (rowEffect != 0)
						return true;

				}
				//Them tai xe
				else {
					String sqlThemTaiXe = "INSERT INTO TAIXE(MaTX, Ten, NgaySinh) " + "VALUES(?, ?, ?)";
					PreparedStatement pre = conn.prepareStatement(sqlThemTaiXe);
					pre.setString(1, nhanVienBEAN.getMaNhanVien());
					pre.setString(2, nhanVienBEAN.getHoTen());
					pre.setString(3, nhanVienBEAN.getNgaySinh());
					int rowEffect = pre.executeUpdate();
					if (rowEffect != 0)
						return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
	}
}
