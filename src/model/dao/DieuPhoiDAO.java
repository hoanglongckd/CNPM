package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.DieuPhoiBEAN;
import model.bean.DonGiaBEAN;
import model.bean.XeBEAN;
import utils.SQLServerConnUtils;

public class DieuPhoiDAO {
	
	//connect database
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;

	//insert diachi and loaixe to dieuphoi table in database
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

	//get loaixe phu hop
	public int getLoaiXe(int id) {
		String sql = "select LoaiXe from DIEUPHOI where id = " + id;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int soCho = 0;
			while (rs.next()) {
				soCho = rs.getInt("LoaiXe");
			}
			return soCho;

		} catch (Exception e) {
			return 0;
		}
	}

	//get max id from dieuphoi table
	public int getMaxIDDieuPhoi() {
		String sql = "select max(id) from DIEUPHOI";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int max = 0;
			while (rs.next()) {
				max = rs.getInt(1);
			}
			return max;

		} catch (Exception e) {
			return 0;
		}
	}

	//get list xe to display at chonxe page
	public ArrayList<XeBEAN> lietKeListXeDieuPhoi(int loaiXe) {
		ArrayList<XeBEAN> listXe = new ArrayList<>();
		try {
			String sql = "select xe.id, TAIXE.Ten, xe.BienSoXe, xe.SoCho " + "From PHANCONGTX " + "Join XE"
					+ " On xe.id = PHANCONGTX.idXe" + " Join TAIXE " + "On TAIXE.id = PHANCONGTX.idTaiXe "
					+ "Where xe.SoCho = " + loaiXe + " And xe.TinhTrangHoatDong = 'False'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				XeBEAN xe = new XeBEAN(rs.getInt("id"), rs.getString("Ten"), rs.getString("BienSoXe"),
						rs.getInt("SoCho"));
				listXe.add(xe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listXe;
	}

	//get id at phancong table
	public int getIDPhanCong(int id) {
		String sql = "select PHANCONGTX.id from PHANCONGTX where PHANCONGTX.idXe = " + id;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int max = 0;
			while (rs.next()) {
				max = rs.getInt(1);
			}
			return max;
		} catch (Exception e) {
			return 0;
		}
	}

	//update dieuphoi table
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
	
	//update trangthai xe after dieuphoi
	public boolean updateTrangThai(DieuPhoiBEAN dieuphoi) {
		String sql = "UPDATE XE SET TinhTrangHoatDong = 'True' "
				+ "WHERE id = (SELECT XE.id FROM PHANCONGTX "
				+ "JOIN DIEUPHOI ON DIEUPHOI.idPhanCong=PHANCONGTX.id "
				+ "JOIN XE ON XE.id = PHANCONGTX.idXe WHERE DIEUPHOI.id=?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, dieuphoi.getId());
			int rowEffect = ps.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//update trangthai xe after gialap
	public boolean updateTTFalse(DieuPhoiBEAN dieuPhoiXe) {
		String sql = "UPDATE XE SET TinhTrangHoatDong = 'False' "
				+ "WHERE id = (SELECT XE.id FROM PHANCONGTX "
				+ "JOIN DIEUPHOI ON DIEUPHOI.idPhanCong=PHANCONGTX.id "
				+ "JOIN XE ON XE.id = PHANCONGTX.idXe WHERE DIEUPHOI.id=?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, dieuPhoiXe.getId());
			int rowEffect = ps.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//get list dieuphoi to display
	public ArrayList<XeBEAN> getListDieuPhoi() {
		ArrayList<XeBEAN> listXe = new ArrayList<>();
		try {
			String sql = "SELECT TAIXE.Ten, XE.BienSoXe, DIEUPHOI.DiaChiNhanKhach, DIEUPHOI.ThoiGianBatDau FROM PHANCONGTX "
					+ "JOIN TAIXE ON PHANCONGTX.idTaiXe = TAIXE.id " + "JOIN XE ON PHANCONGTX.idXe = XE.id "
					+ "JOIN DIEUPHOI ON PHANCONGTX.id = DIEUPHOI.idPhanCong";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				XeBEAN xe = new XeBEAN(rs.getString("Ten"), rs.getString("BienSoXe"), rs.getString("DiaChiNhanKhach"),
						rs.getString("ThoiGianBatDau"));
				listXe.add(xe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listXe;
	}

	//get biensoxe to gialap
	public ArrayList<DieuPhoiBEAN> getDieuPhoi() {
		ArrayList<DieuPhoiBEAN> listXe = new ArrayList<>();
		try {
			String sql = "SELECT DIEUPHOI.id, XE.BienSoXe FROM DIEUPHOI "
					+ "JOIN PHANCONGTX ON DIEUPHOI.idPhanCong = PHANCONGTX.id " + "JOIN XE ON PHANCONGTX.idXe = XE.id "
					+ "WHERE DIEUPHOI.ThoiGianKetThuc IS NULL;";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				DieuPhoiBEAN xe = new DieuPhoiBEAN(rs.getInt("Id"), rs.getString("BienSoXe"));
				listXe.add(xe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listXe;
	}

	//update dieuphoi after gialap
	public boolean ketThucDieuPhoi(DieuPhoiBEAN dieuPhoiXe) {
		String sql = "UPDATE DIEUPHOI SET ThoiGianBatDau = ?, ThoiGianKetThuc = ? WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dieuPhoiXe.getThoiGianBatDau());
			ps.setString(2, dieuPhoiXe.getThoiGianKetThuc());
			ps.setInt(3, dieuPhoiXe.getId());
			int rowEffect = ps.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//get dongia to tinhtien
	public ArrayList<DonGiaBEAN> getDonGia(int soCho, int soKM) {
		ArrayList<DonGiaBEAN> giaTien = new ArrayList<DonGiaBEAN>();
		String sql = "SELECT DONGIA.id, DONGIA.SoTien FROM DONGIA" + " WHERE SoCho = " + soCho + " AND DinhMucKmToiThieu <= " + soKM
				+ " AND DinhMucKmToiDa >= " + soKM;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				DonGiaBEAN dongia = new DonGiaBEAN(rs.getInt("id"), rs.getInt("SoTien"));
				giaTien.add(dongia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return giaTien;
	}

	//tinhtien
	public boolean tinhTien(DieuPhoiBEAN dieuPhoiXe) {
		// Tinh tien
		ArrayList<DonGiaBEAN> donGiaBEAN = getDonGia(getLoaiXe(dieuPhoiXe.getId()), dieuPhoiXe.getSoKM());
		int donGia = 0;
		int idDonGia = 0;
		for (DonGiaBEAN dg : donGiaBEAN) {
			idDonGia = dg.getId();
			donGia = dg.getGiaTien();
		}
		int thanhTien = donGia * dieuPhoiXe.getSoKM();
		dieuPhoiXe.setThanhTien(thanhTien);

		String sql = "INSERT INTO GIATIEN(ThanhTien,SoKM,idDieuPhoi,idDonGia) VALUES(?,?,?,?)";

		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, dieuPhoiXe.getThanhTien());
			pstm.setInt(2, dieuPhoiXe.getSoKM());
			pstm.setInt(3, dieuPhoiXe.getId());
			pstm.setInt(4, idDonGia);

			int rowEffect = pstm.executeUpdate();
			if (rowEffect != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
