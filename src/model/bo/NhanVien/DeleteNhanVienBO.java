package model.bo.NhanVien;

import model.dao.NhanVien.DeleteNhanVienDAO;

public class DeleteNhanVienBO {

	public boolean isDeleted(String idNhanVien) {
		DeleteNhanVienDAO deleteNhanVienDAO = new DeleteNhanVienDAO();
		
		return deleteNhanVienDAO.isDelete(idNhanVien);
	}
}
