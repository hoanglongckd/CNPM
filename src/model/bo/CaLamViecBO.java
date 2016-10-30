package model.bo;

import java.util.ArrayList;

import model.bean.CaLamViecBEAN;
import model.dao.CaLamViecDAO;

public class CaLamViecBO {
	static CaLamViecDAO caLamViecDAO = new CaLamViecDAO(); 
	public static ArrayList<CaLamViecBEAN> getDanhSachCaLamViec() {
		return caLamViecDAO.getDanhSachCaLamViec();
	}

}
