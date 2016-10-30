package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.CaLamViecBEAN;
import utils.SQLServerConnUtils;

public class CaLamViecDAO {
	static Connection conn = SQLServerConnUtils.getSQLServerConnection();
	static ResultSet rs;
	static Statement st;
	public ArrayList<CaLamViecBEAN> getDanhSachCaLamViec() {
		ArrayList<CaLamViecBEAN> listCaLamViec = new ArrayList<>();
		try {
			String sql = "select * from CALAMVIEC";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				CaLamViecBEAN caLamViec = new CaLamViecBEAN(rs.getInt("id"),rs.getString("TenCa"));
				listCaLamViec.add(caLamViec);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listCaLamViec;
	}

}
