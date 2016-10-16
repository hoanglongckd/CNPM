package model.dao.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.SQLServerConnUtils;

public class DeleteNhanVienDAO {

	public boolean isDelete(String idNhanVien) {
		Connection conn = SQLServerConnUtils.getSQLServerConnection();
		
		try{
			String sql="DELETE FROM NHANVIEN where Id="+idNhanVien;
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			if(preparedStatement.executeUpdate()<1) return false;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}

}
