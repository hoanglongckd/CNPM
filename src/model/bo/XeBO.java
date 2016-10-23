package model.bo;

import java.util.ArrayList;

import model.bean.TaiXeBEAN;
import model.bean.XeBEAN;
import model.dao.XeDAO;

public class XeBO {

	static XeDAO xeDAO = new XeDAO();
	
	
	public static ArrayList<XeBEAN> lietKeListXe() {
		
		return xeDAO.lietKeListXe();
	}


	public static boolean xoaXe(int id) {
		return xeDAO.xoaXe(id);
	}


	public static XeBEAN getCapNhatXe(int id) {
		return xeDAO.getCapNhatXe(id);
	}


	public static boolean setCapNhatXe(XeBEAN xe) {
		return xeDAO.setCapNhatXe(xe);
	}


	public static boolean setCapNhatPhanCongTX(TaiXeBEAN taixe, XeBEAN xe) {
		
		return xeDAO.setCapNhatPhanCongTX(taixe, xe);
	}


	public static boolean themXe(XeBEAN xe) {
		return xeDAO.themXe(xe);
	}


	public static boolean themPhanCongTX(TaiXeBEAN taixe, XeBEAN xe) {
		
		return xeDAO.themPhanCongTX(taixe, xe);
	}

	public static int getMaxXeId() {
		return xeDAO.getMaxXeId();
	}
	




}
