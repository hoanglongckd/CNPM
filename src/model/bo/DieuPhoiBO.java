package model.bo;

import java.util.ArrayList;

import model.bean.DieuPhoiBEAN;
import model.bean.XeBEAN;
import model.dao.DieuPhoiDAO;

public class DieuPhoiBO {
	static DieuPhoiDAO dieuPhoiDAO = new DieuPhoiDAO();

	public static boolean themDieuPhoi(DieuPhoiBEAN dieuphoi) {

		return dieuPhoiDAO.themDieuPhoi(dieuphoi);
	}

	public static int getLoaiXe(int id) {

		return dieuPhoiDAO.getLoaiXe(id);
	}

	public static int getMaxIDDieuPhoi() {
		return dieuPhoiDAO.getMaxIDDieuPhoi();

	}

	public static ArrayList<XeBEAN> lietKeListXeDieuPhoi(int loaiXe) {

		return dieuPhoiDAO.lietKeListXeDieuPhoi(loaiXe);
	}

	public static int getIDPhanCong(int id) {
		
		return dieuPhoiDAO.getIDPhanCong(id);
	}

	public static boolean updateIDPhanCong(DieuPhoiBEAN dieuphoi) {
		return dieuPhoiDAO.updateIDPhanCong(dieuphoi);
	}

	public static ArrayList<XeBEAN> getListDieuPhoi() {
		return dieuPhoiDAO.getListDieuPhoi();
	}

	public static ArrayList<DieuPhoiBEAN> getDieuPhoi() {
		return dieuPhoiDAO.getDieuPhoi();
	}

	public static boolean ketThucDieuPhoi(DieuPhoiBEAN dieuPhoiXe) {
		return dieuPhoiDAO.ketThucDieuPhoi(dieuPhoiXe);
	}

	public static boolean tinhTien(DieuPhoiBEAN dieuPhoiXe) {
		return dieuPhoiDAO.tinhTien(dieuPhoiXe);
		
	}

	public static boolean updateTrangThai(DieuPhoiBEAN dieuphoi) {
		return dieuPhoiDAO.updateTrangThai(dieuphoi);
	}

	public static boolean updateTTFalse(DieuPhoiBEAN dieuPhoiXe) {
		return dieuPhoiDAO.updateTTFalse(dieuPhoiXe);
	}

}
