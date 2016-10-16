package model.bo.NhanVien;

import model.bean.NhanVien.NhanVienBEAN;
import model.dao.NhanVien.ShowUpdateNhanVienDAO;

public class ShowUpdateNhanVienBO {
	static ShowUpdateNhanVienDAO showUpdateNhanVienDAO = new ShowUpdateNhanVienDAO();
	
	public NhanVienBEAN getNhanVien(String idNhanVien) {
		return showUpdateNhanVienDAO.getNhanVien(idNhanVien);
	}

}
