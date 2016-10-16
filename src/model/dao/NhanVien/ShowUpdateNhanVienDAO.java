package model.dao.NhanVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.NhanVien.NhanVienBEAN;
import utils.SQLServerConnUtils;

public class ShowUpdateNhanVienDAO {
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	NhanVienBEAN nhanVien = new NhanVienBEAN();
	
	public NhanVienBEAN getNhanVien(String idNhanVien) {
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

}
