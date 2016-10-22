package model.bo;

import java.util.ArrayList;

import model.bean.TheoDoiNhanVienBEAN;
import model.dao.TheoDoiNhanVienDAO;

public class TheoDoiNhanVienBO {
	private static TheoDoiNhanVienBO bo = null;
	TheoDoiNhanVienDAO dao = null;
	
	private TheoDoiNhanVienBO(){
		dao = new TheoDoiNhanVienDAO();
	}
	
	public static TheoDoiNhanVienBO getInstance(){
		if(bo == null){
			bo = new TheoDoiNhanVienBO();
		}
		return bo;
	}
	
	public boolean themVangNghi(TheoDoiNhanVienBEAN nv){
		return dao.themVangNghi(nv);
	}
	
	public boolean suaVangNghi(TheoDoiNhanVienBEAN vn){
		return dao.suaTheoDoiNhanVien(vn);
	}
	
	public boolean xoaVangNghi(int id){
		return dao.xoaTheoDoiNhanVien(id);
	}
	
	public ArrayList<TheoDoiNhanVienBEAN> getListVangNghi(){
		return dao.listTheoDoiNhanVien();
	}
	
	public ArrayList<TheoDoiNhanVienBEAN> getListVangNghiById(int id){
		return dao.getListVangNghiById(id);
	}
	
	public void deleteVangNghiById(int id){
		dao.deleteVangNghiById(id);
	}
	
	public TheoDoiNhanVienBEAN getVangNghiById(int id){
		return dao.getVangNghiById(id);
	}
	
	public boolean suaTheoDoiNhanVien(TheoDoiNhanVienBEAN nv){
		return dao.suaTheoDoiNhanVien(nv);
	}
}
