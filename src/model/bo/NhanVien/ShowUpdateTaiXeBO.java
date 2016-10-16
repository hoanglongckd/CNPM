package model.bo.NhanVien;

import model.bean.NhanVien.NhanVienBEAN;
import model.dao.NhanVien.ShowUpdateTaiXeDAO;

public class ShowUpdateTaiXeBO {
	static ShowUpdateTaiXeDAO showUpdateTaiXeDAO = new ShowUpdateTaiXeDAO();
	
	public NhanVienBEAN getTaiXe(String idTaiXe) {
		return showUpdateTaiXeDAO.getTaiXe(idTaiXe);
	}

}
