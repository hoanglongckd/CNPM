package model.dao.NhanVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.NhanVien.NhanVienBEAN;
import utils.SQLServerConnUtils;

public class ShowUpdateTaiXeDAO {
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	NhanVienBEAN taiXe = new NhanVienBEAN();
	
	public NhanVienBEAN getTaiXe(String idTaiXe) {
		try {
			String sql = "select * from TAIXE where Id="+idTaiXe;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				 taiXe = new NhanVienBEAN(rs.getInt("id"),rs.getString("MaTX"), rs.getString("Ten"), rs.getString("NgaySinh"),2,1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return taiXe;
	}

}
