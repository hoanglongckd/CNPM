package model.bo;

import java.util.ArrayList;

import model.bean.QuanLyVangNghiBEAN;
import model.dao.QuanLyVangNghiDAO;

public class QuanLyVangNghiBO {
	static QuanLyVangNghiDAO quanLyVangNghiDAO = new QuanLyVangNghiDAO();
	
	public static ArrayList<QuanLyVangNghiBEAN> lietKeMaNV() {
		return quanLyVangNghiDAO.lietKeMaNV();
	}
	
	public static boolean themMoiVangNghi (QuanLyVangNghiBEAN item) {
		return quanLyVangNghiDAO.themMoiVangNghi(item);
	}
	
	public static ArrayList<QuanLyVangNghiBEAN> lietKeVangNghi () {
		return quanLyVangNghiDAO.lietKeVangNghi();
	}
	
	public static QuanLyVangNghiBEAN layChiTietNV (int idNhanVien) {
		return quanLyVangNghiDAO.layChiTietNV(idNhanVien);
	}
	
	public static ArrayList<QuanLyVangNghiBEAN> lietKeVangNghiMotNV(int idNhanVien) {
		return quanLyVangNghiDAO.lietKeVangNghiMotNV(idNhanVien);
	}
	
	public static QuanLyVangNghiBEAN getCapNhapVangNghi (int id) {
		return quanLyVangNghiDAO.getCapNhapVangNghi(id);
	}
	
	public static boolean setCapNhapVangNghi (QuanLyVangNghiBEAN item) {
		return quanLyVangNghiDAO.setCapNhapVangNghi(item);
	}
}
