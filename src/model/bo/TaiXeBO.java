package model.bo;


import java.util.ArrayList;
import java.util.List;

import model.bean.PhanCongTaiXeBEAN;
import model.bean.TaiXeBEAN;
import model.bean.XeBEAN;
import model.dao.TaiXeDAO;

public class TaiXeBO {
	static TaiXeDAO taiXeDAO = new TaiXeDAO();

	public List<TaiXeBEAN> getAllMaTX() {
		return taiXeDAO.getAllMaTX();
	}

	public List<TaiXeBEAN> getAllTenTX() {
		//return taiXedao.getAllTenTX();
		return taiXeDAO.getAllTenTX();
	}
	
	public static boolean addTaiXe(TaiXeBEAN taiXeBEAN) {
		return taiXeDAO.addTaiXe(taiXeBEAN);
	}

	public static ArrayList<TaiXeBEAN> getDanhSachTaiXe() {
		return taiXeDAO.getDanhSachTaiXe();
	}

	public boolean isTaiXeDeleted(String idTaiXe) {
		return taiXeDAO.isTaiXeDeleted(idTaiXe);
	}

	public static TaiXeBEAN getTaiXe(String idTaiXe) {
		return taiXeDAO.getTaiXe(idTaiXe);
	}

	public static boolean setSuaTaiXe(TaiXeBEAN taiXeBEAN) {
		return taiXeDAO.setSuaTaiXe(taiXeBEAN);
	}

	public static boolean addPhanCongTaiXe(PhanCongTaiXeBEAN phanCongTaiXeBEAN) {
		return taiXeDAO.addPhanCongTaiXe(phanCongTaiXeBEAN);
	}

	public static ArrayList<XeBEAN> getListXe(){
		return taiXeDAO.getListXe();
	}
	
}
