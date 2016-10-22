package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.TaiXe;
import utils.SQLServerConnUtils;

public class taiXeDAO {
//	Connection conn = ConnectionUtils.getConnection();
	Connection conn = SQLServerConnUtils.getSQLServerConnection();
	
	public List<TaiXe> getAllMaTX(){

		   List<TaiXe> listMaTX = new ArrayList<TaiXe>();
		   String sql ="select id,MaTX from TAIXE";
		   try{
			   Statement st = conn.createStatement();
			   ResultSet rs = st.executeQuery(sql);
			   while(rs.next()){
				   int id = rs.getInt(1);
				   String maTX = rs.getString(2);
				   TaiXe list = new TaiXe(id,maTX);
				   listMaTX.add(list);
			   }
			   return listMaTX;
		   }catch(Exception e){
			  return null;
		   }      
	 
	   }

	public List<TaiXe> getAllTenTX() {
		
		List<TaiXe> listTX = new ArrayList<TaiXe>();
		   String sql ="select id,Ten from TAIXE";
		   try{
			   Statement st = conn.createStatement();
			   ResultSet rs = st.executeQuery(sql);
			   while(rs.next()){
				   int id = rs.getInt(1);
				   String tenTX = rs.getString(2);
				   TaiXe list = new TaiXe(id,tenTX);
				   listTX.add(list);
			   }
			   return listTX;
		   }catch(Exception e){
			  return null;
		   }      
	} 
}
