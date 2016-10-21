package model.bo;

import java.util.ArrayList;

import model.bean.TaiXe;
import model.bean.XeBEAN;
import model.dao.xeDao;

public class xeBO {

	static xeDao xeDao = new xeDao();
	
	
	public static ArrayList<XeBEAN> lietKeListXe() {
		
		return xeDao.lietKeListXe();
	}


	public static boolean xoaXe(int id) {
		return xeDao.xoaXe(id);
	}


	public static XeBEAN getCapNhatXe(int id) {
		return xeDao.getCapNhatXe(id);
	}


	public static boolean setCapNhatXe(XeBEAN xe) {
		return xeDao.setCapNhatXe(xe);
	}


	public static boolean setCapNhatPhanCongTX(TaiXe taixe, XeBEAN xe) {
		
		return xeDao.setCapNhatPhanCongTX(taixe, xe);
	}


	public static boolean themXe(XeBEAN xe) {
		return xeDao.themXe(xe);
	}


	public static boolean themPhanCongTX(TaiXe taixe, XeBEAN xe) {
		
		return xeDao.themPhanCongTX(taixe, xe);
	}

	public static int getMaxXeId() {
		return xeDao.getMaxXeId();
	}
	




}
