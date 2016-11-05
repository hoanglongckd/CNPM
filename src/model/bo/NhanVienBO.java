package model.bo;

import java.util.ArrayList;

import model.bean.ChucVuBEAN;
import model.bean.NhanVienBEAN;
import model.bean.PhanCongNhanVienBEAN;
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

	public static boolean addPhanCongNhanVien(PhanCongNhanVienBEAN phanCongNhanVienBEAN) {
		return nhanVienDAO.addPhanCongNhanVien(phanCongNhanVienBEAN);
	}
	/////
	public NhanVienBEAN getNhanVienByMaNV(String maNV) {
		// TODO Auto-generated method stub
		return nhanVienDAO.getNhanVienByMaNV(maNV);
	}
	public boolean updatePassword (NhanVienBEAN nv){
		return nhanVienDAO.updatePassword(nv);
	}

	public static ChucVuBEAN getChucVu() {
		// TODO Auto-generated method stub
		return nhanVienDAO.getChucVu();
	}
}
