package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.BaoDuongXeBEAN;
import model.bean.NhanVienBEAN;
import model.bean.PhanCongNhanVienBEAN;
import utils.SQLServerConnUtils;

public class NhanVienDAO {
	static Connection conn = SQLServerConnUtils.getSQLServerConnection();
	static ResultSet rs;
	static Statement st;
	
	public boolean addNhanVien(NhanVienBEAN nhanVienBEAN) {
		try {
					String sqlThemNhanVien = "INSERT INTO NHANVIEN(MaNV, Password, Ten, NgaySinh, idChucVu) "
							+ "VALUES(?, ?, ?, ?,?)";
					//System.out.println(nhanVienBEAN.getMaNhanVien() + nhanVienBEAN.getHoTen() + nhanVienBEAN.getIdChucVu());
					PreparedStatement pre = conn.prepareStatement(sqlThemNhanVien);
					pre.setString(1, nhanVienBEAN.getMaNhanVien());
					pre.setString(2, nhanVienBEAN.getPassword());
					pre.setString(3, nhanVienBEAN.getHoTen());
					pre.setString(4, nhanVienBEAN.getNgaySinh());
					pre.setInt(5, nhanVienBEAN.getIdChucVu());
					int rowEffect = pre.executeUpdate();
					if (rowEffect != 0)
						return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
	}

	public ArrayList<NhanVienBEAN> getDanhSachNhanVien() {
		ArrayList<NhanVienBEAN> listNhanVien = new ArrayList<>();
		try {
			String sql = "select * from NHANVIEN";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				NhanVienBEAN nhanVien = new NhanVienBEAN(rs.getInt("id"),rs.getString("MaNV"), rs.getString("Ten"), rs.getString("NgaySinh"),rs.getInt("IdChucVu"),rs.getString("Password"));
				listNhanVien.add(nhanVien);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listNhanVien;
	}

	
	public boolean isNhanVienDeleted(String idNhanVien) {
		try{
			String sql="DELETE FROM NHANVIEN where Id="+idNhanVien;
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			if(preparedStatement.executeUpdate()<1) return false;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}


	public NhanVienBEAN getNhanVien(String idNhanVien) {
		NhanVienBEAN nhanVien = new NhanVienBEAN();
		try {
			String sql = "select * from NHANVIEN where Id="+idNhanVien;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				nhanVien = new NhanVienBEAN(rs.getInt("id"),rs.getString("MaNV"), rs.getString("Ten"), rs.getString("NgaySinh"),1,rs.getString("Password"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	public boolean setSuaNhanVien(NhanVienBEAN nhanVienBEAN) {
		String sql = "UPDATE NHANVIEN SET "
				+ "Ten = ?, NgaySinh = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nhanVienBEAN.getHoTen());
			ps.setString(2, nhanVienBEAN.getNgaySinh());
			ps.setInt(3, nhanVienBEAN.getId());
				int rowEffect = ps.executeUpdate();
			if (rowEffect != 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	public boolean addPhanCongNhanVien(PhanCongNhanVienBEAN phanCongNhanVienBEAN) {
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
	
	//Nguyen
	
	public NhanVienBEAN getNhanVienByMaNV(String maNV) {
		NhanVienBEAN nhanVien = null;
		try {
			String sql = "select * from NHANVIEN where MaNV='"+maNV+"'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				 nhanVien = new NhanVienBEAN(rs.getInt("id"),rs.getString("MaNV"), rs.getString("Ten"),
							rs.getString("NgaySinh"), rs.getInt("idChucVu") ,rs.getString("Password"));
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
		return nhanVien;
	}
	
	public boolean updatePassword(NhanVienBEAN nhanVienBEAN) {
		String sql = "UPDATE NHANVIEN SET "
				+ "Password = ? WHERE MaNV = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nhanVienBEAN.getPassword());
			ps.setString(2, nhanVienBEAN.getMaNhanVien());
				int rowEffect = ps.executeUpdate();
			if (rowEffect != 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
