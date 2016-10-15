package model.bo.NhanVien;

import java.util.ArrayList;

import model.bean.NhanVien.NhanVienBEAN;
import model.dao.NhanVien.ThemNhanVienDAO;;

public class ThemNhanVienBO {
	
	static ThemNhanVienDAO themNhanVienDAO = new ThemNhanVienDAO();
	
	public static boolean themNhanVien(NhanVienBEAN nhanVienBEAN) {
		return ThemNhanVienDAO.themNhanVien(nhanVienBEAN);
	}
	
}
