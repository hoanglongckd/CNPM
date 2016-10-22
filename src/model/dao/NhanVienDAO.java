package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.BaoDuongXeBEAN;
import model.bean.NhanVienBEAN;
import utils.SQLServerConnUtils;

public class NhanVienDAO {
	static Connection conn = SQLServerConnUtils.getSQLServerConnection();
	static ResultSet rs;
	static Statement st;
	
	public static boolean addNhanVien(NhanVienBEAN nhanVienBEAN) {
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

	public ArrayList<NhanVienBEAN> getDanhSachNhanVien() {
		ArrayList<NhanVienBEAN> listNhanVien = new ArrayList<>();
		try {
			String sql = "select * from NHANVIEN";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				NhanVienBEAN nhanVien = new NhanVienBEAN(rs.getInt("id"),rs.getString("MaNV"), rs.getString("Ten"), rs.getString("NgaySinh"),1,1);
				listNhanVien.add(nhanVien);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listNhanVien;
	}

	public ArrayList<NhanVienBEAN> getDanhSachTaiXe() {
		ArrayList<NhanVienBEAN> listTaiXe = new ArrayList<>();
		try {
			String sql = "select * from TaiXe";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				NhanVienBEAN taiXe = new NhanVienBEAN(rs.getInt("id"),rs.getString("MaTX"), rs.getString("Ten"), rs.getString("NgaySinh"),2,1);
				listTaiXe.add(taiXe);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listTaiXe;
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
	
	public boolean isTaiXeDeleted(String idTaiXe) {
		try{
			String sql="DELETE FROM TaiXe where Id="+idTaiXe;
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
				 nhanVien = new NhanVienBEAN(rs.getInt("id"),rs.getString("MaNV"), rs.getString("Ten"), rs.getString("NgaySinh"),1,1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	public NhanVienBEAN getTaiXe(String idTaiXe) {
		
		return null;
	}
}
