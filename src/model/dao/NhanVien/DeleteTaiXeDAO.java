package model.dao.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.SQLServerConnUtils;

public class DeleteTaiXeDAO {

	public boolean isDeleted(String idTaiXe) {
Connection conn = SQLServerConnUtils.getSQLServerConnection();
		
		try{
			String sql="DELETE FROM TAIXE where Id="+idTaiXe;
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			if(preparedStatement.executeUpdate()<1) return false;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}

}
