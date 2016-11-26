package controller.TaiXe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NhanVienBO;
import model.bo.TaiXeBO;
import model.bean.NhanVienBEAN;
import model.bean.TaiXeBEAN;

/**
 * Servlet implementation class AddBaoDuongXeController
 */

public class ShowDanhSachTaiXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowDanhSachTaiXeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TaiXeBO taiXeBO = new TaiXeBO();

		ArrayList<TaiXeBEAN> listTaiXe = taiXeBO.getDanhSachTaiXe();
		request.setAttribute("listTaiXe", listTaiXe);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/TaiXe/danh-sach-tai-xe.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
