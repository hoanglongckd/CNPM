package model.bo.NhanVien;

import java.util.ArrayList;
import model.bean.NhanVien.NhanVienBEAN;
import model.dao.NhanVien.DanhSachTaiXeDAO;

public class DanhSachTaiXeBO {
	static DanhSachTaiXeDAO danhSachTaiXeDAO = new DanhSachTaiXeDAO();
	
	public static ArrayList<NhanVienBEAN> listTaiXe() {
		return danhSachTaiXeDAO.getDanhSachTaiXe();
	}

}
