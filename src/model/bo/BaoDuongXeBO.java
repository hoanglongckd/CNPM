package model.bo;

import model.bean.BaoDuongXeBEAN;
import model.dao.BaoDuongXeDAO;

public class BaoDuongXeBO {
	
	static BaoDuongXeDAO baoDuongXeDAO = new BaoDuongXeDAO();
	
	public static boolean themXeBaoDuong(BaoDuongXeBEAN baoDuongXeBEAN) {
		return baoDuongXeDAO.themXeBaoDuong(baoDuongXeBEAN);
	}
	
}
