package model.bo.NhanVien;

import java.util.ArrayList;
import model.bean.NhanVien.NhanVienBEAN;
import model.dao.NhanVien.ShowDanhSachNhanVienDAO;

public class ShowDanhSachNhanVienBO {

	static ShowDanhSachNhanVienDAO showDanhSachNhanVienDAO = new ShowDanhSachNhanVienDAO();
	
	public static ArrayList<NhanVienBEAN> getDanhSachNhanVien(){
		return showDanhSachNhanVienDAO.getDanhSachNhanVien();
	}
}
