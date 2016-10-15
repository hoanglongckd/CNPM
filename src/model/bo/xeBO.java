package model.bo;

import model.dao.xeDao;

public class xeBO {

	xeDao xeDao = new xeDao();
	
	public void addXe(String bienSoXe, String model, int soChoNgoi, String hang, String tinhTrang, String ghiChu) {
		xeDao.addXe(bienSoXe, model, soChoNgoi, hang, tinhTrang, ghiChu);
		
	}

}
