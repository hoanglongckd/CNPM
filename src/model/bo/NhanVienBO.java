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

	public ArrayList<NhanVienBEAN> getDanhSachTaiXe() {
		return nhanVienDAO.getDanhSachTaiXe();
	}

	public boolean isNhanVienDeleted(String idNhanVien) {
		return nhanVienDAO.isNhanVienDeleted(idNhanVien);
	}

	public boolean isTaiXeDeleted(String idTaiXe) {
		return nhanVienDAO.isTaiXeDeleted(idTaiXe);
	}

	public static NhanVienBEAN getNhanVien(String idNhanVien) {
		return nhanVienDAO.getNhanVien(idNhanVien);
	}

	public NhanVienBEAN getTaiXe(String idTaiXe) {
		return nhanVienDAO.getTaiXe(idTaiXe);
	}
	public boolean editNhanVien(NhanVienBEAN nhanVien){
		return nhanVienDAO.suaNhanVien(nhanVien);
	}

	public NhanVienBEAN getNhanVienByMaNV(String maNV) {
		// TODO Auto-generated method stub
		return nhanVienDAO.getNhanVienByMaNV(maNV);
	}
}
