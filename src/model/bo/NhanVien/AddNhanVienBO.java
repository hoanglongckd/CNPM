package model.bo.NhanVien;

import java.util.ArrayList;

import model.bean.NhanVien.NhanVienBEAN;
import model.dao.NhanVien.AddNhanVienDAO;;

public class AddNhanVienBO {
	
	static AddNhanVienDAO addNhanVienDAO = new AddNhanVienDAO();
	
	public static boolean addNhanVien(NhanVienBEAN nhanVienBEAN) {
		return AddNhanVienDAO.addNhanVien(nhanVienBEAN);
	}
	
}
