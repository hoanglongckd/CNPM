package model.bo;

import java.util.ArrayList;

import model.bean.BaoDuongXeBEAN;
import model.bean.XeBEAN;
import model.dao.BaoDuongXeDAO;

public class BaoDuongXeBO {
	
	static BaoDuongXeDAO baoDuongXeDAO = new BaoDuongXeDAO();
	
	public static boolean themXeBaoDuong(BaoDuongXeBEAN baoDuongXeBEAN) {
		return baoDuongXeDAO.themXeBaoDuong(baoDuongXeBEAN);
	}
	
	public static ArrayList<XeBEAN> lietKeXe(){
		return baoDuongXeDAO.lietKeXe();
	}
	
}
