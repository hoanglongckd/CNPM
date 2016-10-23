package model.bo;

import java.util.ArrayList;
import model.bean.NhanVienBEAN;
import model.dao.NhanVienDAO;

public class NhanVienBO {
	static NhanVienDAO nhanVienDAO = new NhanVienDAO();

	public static boolean addNhanVien(NhanVienBEAN nhanVienBEAN) {
		// TODO Auto-generated method stub
		return nhanVienDAO.addNhanVien(nhanVienBEAN);
	}

	public static ArrayList<NhanVienBEAN> getDanhSachNhanVien() {
		return nhanVienDAO.getDanhSachNhanVien();
	}

	public boolean isNhanVienDeleted(String idNhanVien) {
		return nhanVienDAO.isNhanVienDeleted(idNhanVien);
	}

	public static NhanVienBEAN getNhanVien(String idNhanVien) {
		return nhanVienDAO.getNhanVien(idNhanVien);
	}

	public static boolean setSuaNhanVien(NhanVienBEAN nhanVienBEAN) {
		return nhanVienDAO.setSuaNhanVien(nhanVienBEAN);
	}

}
