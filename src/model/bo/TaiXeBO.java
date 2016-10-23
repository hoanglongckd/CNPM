package model.bo;

import java.util.List;

import model.bean.TaiXe;
import model.dao.TaiXeDAO;

public class TaiXeBO {
	TaiXeDAO taiXedao = new TaiXeDAO();

	public List<TaiXe> getAllMaTX() {
		return taiXedao.getAllMaTX();
	}

	public List<TaiXe> getAllTenTX() {
		
		return taiXedao.getAllTenTX();
	}


	
}
