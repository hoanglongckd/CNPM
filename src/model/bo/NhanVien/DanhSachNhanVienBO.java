package model.bo.NhanVien;

import java.util.ArrayList;
import model.bean.NhanVien.NhanVienBEAN;
import model.dao.NhanVien.DanhSachNhanVienDAO;

public class DanhSachNhanVienBO {

	static DanhSachNhanVienDAO danhSachNhanVienDAO = new DanhSachNhanVienDAO();
	
	public static ArrayList<NhanVienBEAN> getDanhSachNhanVien(){
		return danhSachNhanVienDAO.getDanhSachNhanVien();
	}
}
