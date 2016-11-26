package model.bo;

import model.bean.DashBoardBEAN;
import model.dao.DashboardDAO;

public class DashBoardBO {
	
	static DashboardDAO dbd = new DashboardDAO();
	
	public static DashBoardBEAN demSoLuongThanhPhanMoiChucNang() {
		return dbd.demSoLuongThanhPhanMoiChucNang();
	}
	
}
