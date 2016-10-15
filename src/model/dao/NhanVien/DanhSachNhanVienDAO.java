package model.dao.NhanVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.NhanVien.NhanVienBEAN;
import utils.SQLServerConnUtils;

public class DanhSachNhanVienDAO {
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	
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

}
