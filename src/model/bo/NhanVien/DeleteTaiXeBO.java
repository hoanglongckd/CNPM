package model.bo.NhanVien;

import model.dao.NhanVien.DeleteTaiXeDAO;

public class DeleteTaiXeBO {

	public boolean isDeleted(String idTaiXe) {
		DeleteTaiXeDAO deleteTaiXeDAO = new DeleteTaiXeDAO();
		return deleteTaiXeDAO.isDeleted(idTaiXe);
	}
	
}
