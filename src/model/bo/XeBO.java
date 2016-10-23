package model.bo;

import java.util.ArrayList;

import model.bean.TaiXeBEAN;
import model.bean.XeBEAN;
import model.dao.XeDao;

public class XeBO {

	static XeDao XeDao = new XeDao();
	
	
	public static ArrayList<XeBEAN> lietKeListXe() {
		
		return XeDao.lietKeListXe();
	}


	public static boolean xoaXe(int id) {
		return XeDao.xoaXe(id);
	}


	public static XeBEAN getCapNhatXe(int id) {
		return XeDao.getCapNhatXe(id);
	}


	public static boolean setCapNhatXe(XeBEAN xe) {
		return XeDao.setCapNhatXe(xe);
	}


	public static boolean setCapNhatPhanCongTX(TaiXeBEAN taixe, XeBEAN xe) {
		
		return XeDao.setCapNhatPhanCongTX(taixe, xe);
	}


	public static boolean themXe(XeBEAN xe) {
		return XeDao.themXe(xe);
	}


	public static boolean themPhanCongTX(TaiXeBEAN taixe, XeBEAN xe) {
		
		return XeDao.themPhanCongTX(taixe, xe);
	}

	public static int getMaxXeId() {
		return XeDao.getMaxXeId();
	}
	




}
