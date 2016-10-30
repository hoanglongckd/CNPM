package model.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.bean.PhanCongNhanVienBEAN;
import model.dao.PhanCongNhanVienDAO;
import utils.SQLServerConnUtils;

public class PhanCongNhanVienBO {
	static PhanCongNhanVienDAO phanCongNhanVienDAO = new PhanCongNhanVienDAO();
	public static boolean themPhanCongNhanVien(PhanCongNhanVienBEAN phanCongNhanVienBEAN) {
		return phanCongNhanVienDAO.themPhanCongNhanVien(phanCongNhanVienBEAN);
	}
}
