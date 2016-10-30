package model.bo;

import model.bean.PhanCongTaiXeBEAN;
import model.dao.PhanCongTaiXeDAO;

public class PhanCongTaiXeBO {
	static PhanCongTaiXeDAO phanCongTaiXeDAO = new PhanCongTaiXeDAO();
	public static boolean themPhanCongTaiXe(PhanCongTaiXeBEAN phanCongTaiXeBEAN) {
		return phanCongTaiXeDAO.themPhanCongTaiXe(phanCongTaiXeBEAN);
	}

}
