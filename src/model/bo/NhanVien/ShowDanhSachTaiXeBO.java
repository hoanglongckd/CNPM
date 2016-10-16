package model.bo.NhanVien;

import java.util.ArrayList;
import model.bean.NhanVien.NhanVienBEAN;
import model.dao.NhanVien.ShowDanhSachTaiXeDAO;

public class ShowDanhSachTaiXeBO {
	static ShowDanhSachTaiXeDAO showDanhSachTaiXeDAO = new ShowDanhSachTaiXeDAO();
	
	public static ArrayList<NhanVienBEAN> listTaiXe() {
		return showDanhSachTaiXeDAO.getDanhSachTaiXe();
	}

}
