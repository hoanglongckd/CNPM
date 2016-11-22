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
	
	public static long getTotalProfitByMonth (String year, String month) {
		return thongKeLoiNhuanDAO.getTotalProfitByMonth(year, month);
	}
	
	public static long getTotalFeeByMonth (String year, String month) {
		return thongKeLoiNhuanDAO.getTotalFeeByMonth(year, month);
	}
	
	public static long getTotalProfitByYear(String year) {
		return thongKeLoiNhuanDAO.getTotalProfitByYear(year);
	}
	
	public static long getTotalFeeByYear (String year) {
		return thongKeLoiNhuanDAO.getTotalFeeByYear(year);
	}
}
