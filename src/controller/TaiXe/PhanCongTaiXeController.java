package controller.TaiXe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.TaiXeBEAN;
import model.bean.PhanCongTaiXeBEAN;
import model.bo.TaiXeBO;
import model.bo.PhanCongTaiXeBO;
import model.bean.CaLamViecBEAN;
import model.bo.CaLamViecBO;
import model.bean.ThuNgayBEAN;
import model.bean.XeBEAN;
import model.bo.ThuNgayBO;
import model.bo.XeBO;

/**
 * Servlet implementation class PhanCongNhanVienController
 */

public class PhanCongTaiXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhanCongTaiXeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<TaiXeBEAN> listTaiXe = TaiXeBO.getDanhSachTaiXe();
		request.setAttribute("listTaiXe", listTaiXe);
		
		ArrayList<XeBEAN> listXe = TaiXeBO.getListXe();
		request.setAttribute("listXe", listXe);
		
		ArrayList<CaLamViecBEAN> listCaLamViec = CaLamViecBO.getDanhSachCaLamViec();
		request.setAttribute("listCaLamViec", listCaLamViec);
		ArrayList<ThuNgayBEAN> listThuNgay = ThuNgayBO.getDanhSachThuNgay();
		request.setAttribute("listThuNgay", listThuNgay);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/TaiXe/them-phan-cong-tai-xe.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession msg = request.getSession();

		int idTaiXe = Integer.parseInt(request.getParameter("idTaiXe"));
		int idXe = Integer.parseInt(request.getParameter("idXe"));
		int idCa = Integer.parseInt(request.getParameter("idCaLamViec"));
		int idThuNgay = Integer.parseInt(request.getParameter("idThuNgay"));
		System.out.println(idTaiXe+"|"+idCa+"|"+ idThuNgay);
		
		PhanCongTaiXeBEAN phanCongTaiXeBEAN = new PhanCongTaiXeBEAN();
		phanCongTaiXeBEAN.setIdCa(idCa);
		phanCongTaiXeBEAN.setIdTaiXe(idTaiXe);
		phanCongTaiXeBEAN.setIdXe(idXe);
		phanCongTaiXeBEAN.setIdThuNgay(idThuNgay);
		if (PhanCongTaiXeBO.themPhanCongTaiXe(phanCongTaiXeBEAN)) {
			msg.setAttribute("messages", "<ul><li>ThĂªm phĂ¢n cĂ´ng cho tài xế thĂ nh cĂ´ng!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-tai-xe");
		} else {
			msg.setAttribute("errors", "<ul><li>ThĂªm phĂ¢n cĂ´ng cho tài xế tháº¥t báº¡i!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-tai-xe");
		}

	}

}
