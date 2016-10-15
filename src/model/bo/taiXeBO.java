package model.bo;

import java.util.List;

import model.bean.TaiXe;
import model.dao.taiXeDAO;

public class taiXeBO {
	taiXeDAO taiXedao = new taiXeDAO();

	public List<TaiXe> getAllMaTX() {
		return taiXedao.getAllMaTX();
	}


	
}
