package model.bo;

import java.util.ArrayList;

import model.bean.ThuNgayBEAN;
import model.dao.ThuNgayDAO;

public class ThuNgayBO {
	static ThuNgayDAO thuNgayDAO = new ThuNgayDAO();
	public static ArrayList<ThuNgayBEAN> getDanhSachThuNgay() {
		return thuNgayDAO.getDanhSachThuNgay();
	}

}
