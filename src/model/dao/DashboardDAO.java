package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.bean.DashBoardBEAN;
import utils.SQLServerConnUtils;

public class DashboardDAO {

	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	
	
	public DashBoardBEAN demSoLuongThanhPhanMoiChucNang() {
		DashBoardBEAN dbb = new DashBoardBEAN();
		try {
			String sql1 = "SELECT COUNT(NHANVIEN.id) AS SoNhanVien FROM NHANVIEN WHERE NHANVIEN.idChucVu = (SELECT CHUCVU.id FROM CHUCVU WHERE CHUCVU.MaChucVu != 'AD')";
			String sql2 = "SELECT COUNT(TAIXE.id) AS SoTaiXe FROM TAIXE";
			String sql3 = "SELECT COUNT(DIEUPHOI.id) AS SoDieuPhoi FROM DIEUPHOI";
			String sql4 = "SELECT COUNT(XE.id) AS SoXe FROM XE";
			String sql5 = "SELECT COUNT(THEODOINHANVIEN.id) AS SoVangNghi FROM THEODOINHANVIEN";
			String sql6 = "SELECT COUNT(BAODUONGXE.id) AS SoBaoDuong FROM BAODUONGXE";
			st = conn.createStatement();
			rs = st.executeQuery(sql1);
			while (rs.next()) {
				dbb.setSoNhanVien(rs.getInt("SoNhanVien"));
			}
			rs = st.executeQuery(sql2);
			while (rs.next()) {
				dbb.setSoTaiXe(rs.getInt("SoTaiXe"));
			}
			rs = st.executeQuery(sql3);
			while (rs.next()) {
				dbb.setSoDieuPhoi(rs.getInt("SoDieuPhoi"));
			}
			rs = st.executeQuery(sql4);
			while (rs.next()) {
				dbb.setSoXe(rs.getInt("SoXe"));
			}
			rs = st.executeQuery(sql5);
			while (rs.next()) {
				dbb.setSoVangNghi(rs.getInt("SoVangNghi"));
			}
			rs = st.executeQuery(sql6);
			while (rs.next()) {
				dbb.setSoXeBaoDuong(rs.getInt("SoBaoDuong"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbb;
	}
}
