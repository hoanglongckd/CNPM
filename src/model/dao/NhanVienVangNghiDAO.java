package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.NhanVienVangNghiBEAN;


import utils.SQLServerConnUtils;

public class NhanVienVangNghiDAO {

	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	ResultSet rs;
	Statement st;
	
	public ArrayList<NhanVienVangNghiBEAN> listNhanVienVangNghi() {
		ArrayList<NhanVienVangNghiBEAN> listTheoDoiNV = new ArrayList<>();
		int i = 0;
		try {
			String sql = "select NHANVIEN.Ten ,THEODOINHANVIEN.idNhanVien, count(idNhanVien) AS 'Soluong' from NHANVIEN ,THEODOINHANVIEN where NHANVIEN.id = idNhanVien group by idNhanVien, Ten" ;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				System.out.println("-- " + rs.getString(1));
				NhanVienVangNghiBEAN item = new NhanVienVangNghiBEAN(
						rs.getString(2),rs.getString(1),Integer.parseInt(rs.getString(3)));
				listTheoDoiNV.add(item);
				i++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("--TAO DANG  " + i);
		return listTheoDoiNV;
	}

}
