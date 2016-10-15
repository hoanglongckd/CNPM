package model.dao.NhanVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.NhanVien.NhanVienBEAN;
import utils.SQLServerConnUtils;

public class DanhSachTaiXeDAO {
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	public ArrayList<NhanVienBEAN> getDanhSachTaiXe() {
		ArrayList<NhanVienBEAN> listTaiXe = new ArrayList<>();
		try {
			String sql = "select * from TAIXE";
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

}
