package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ThuNgayBEAN;
import utils.SQLServerConnUtils;

public class ThuNgayDAO {
	static Connection conn = SQLServerConnUtils.getSQLServerConnection();
	static ResultSet rs;
	static Statement st;
	public ArrayList<ThuNgayBEAN> getDanhSachThuNgay() {
		ArrayList<ThuNgayBEAN> listThuNgay = new ArrayList<>();
		try {
			String sql = "select * from THUNGAY";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				ThuNgayBEAN thuNgay = new ThuNgayBEAN(rs.getInt("id"),rs.getString("TenThuNgay"));
				listThuNgay.add(thuNgay);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listThuNgay;
	}

}
