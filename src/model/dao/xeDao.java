package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.SQLServerConnUtils;


public class xeDao {

//	Connection conn = ConnectionUtils.getConnection();
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	
	public void addXe(String bienSoXe, String model, int soChoNgoi, String hang, String tinhTrang, String ghiChu) {
		String sql ="insert into xe values(?,?,?,?,?,?)";
		try{
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, bienSoXe);
			pstm.setString(2, model);
			pstm.setInt(3, soChoNgoi);
			pstm.setString(4, hang);
			pstm.setString(5, tinhTrang);
			pstm.setString(6, ghiChu);
			pstm.executeUpdate();
		}catch(Exception e){
	//		e.printStackTrace();
		}
		
	}

	

}
