package model.bo;

import java.util.ArrayList;

import model.bean.NhanVienVangNghiBEAN;
import model.dao.NhanVienVangNghiDAO;

public class NhanVienVangNghiBO {
	private static NhanVienVangNghiBO instance = null;
	NhanVienVangNghiDAO dao =null;
	
	private NhanVienVangNghiBO(){
		dao = new NhanVienVangNghiDAO();
	}
	
	public static NhanVienVangNghiBO getInstance(){
		if(instance == null){
			instance = new NhanVienVangNghiBO();
		}
		return instance;
	}
	
	public ArrayList<NhanVienVangNghiBEAN> getList(){
		return dao.listNhanVienVangNghi();
	}
}
