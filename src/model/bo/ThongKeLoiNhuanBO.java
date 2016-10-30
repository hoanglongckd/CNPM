package model.bo;

import java.util.ArrayList;

import model.bean.ThongKeLoiNhuanBEAN;
import model.dao.ThongKeLoiNhuanDAO;

public class ThongKeLoiNhuanBO {
	
	static ThongKeLoiNhuanDAO thongKeLoiNhuanDAO = new ThongKeLoiNhuanDAO();
	
	public static ArrayList<ThongKeLoiNhuanBEAN> thongKeTheoThang(String year, String month) {
		return thongKeLoiNhuanDAO.thongKeTheoThang(year, month);
	}
	
	public static ArrayList<ThongKeLoiNhuanBEAN> thongKeTheoNam (String year) {
		return thongKeLoiNhuanDAO.thongKeTheoNam(year);
	}
}
