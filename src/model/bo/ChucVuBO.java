package model.bo;

import java.util.ArrayList;

import model.bean.ChucVuBEAN;
import model.dao.ChucVuDAO;

public class ChucVuBO {
	ChucVuDAO chucVuDAO = new ChucVuDAO();
	
	public ArrayList<ChucVuBEAN> listChucVu() {
		return chucVuDAO.listChucVu();
		
	}
	public boolean themChucVu(ChucVuBEAN cv){
		return chucVuDAO.themChucVu(cv);
	}
	public boolean suaChucVu(ChucVuBEAN chucVu){
		return chucVuDAO.suaChucVu(chucVu);
	}
	public boolean xoaChucVu(int idChucVu){
		return chucVuDAO.xoaChucVu(idChucVu);
	}
}
