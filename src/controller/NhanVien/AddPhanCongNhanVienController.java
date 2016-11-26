package controller.NhanVien;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVienBEAN;
import model.bean.PhanCongNhanVienBEAN;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class AddBaoDuongXeController
 */
// @WebServlet("/them-nhan-vien")
public class AddPhanCongNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPhanCongNhanVienController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		///kiem tra chuc vu admin 
		if(session.getAttribute("maChucVu").toString().equals("AD")){// kiem tra chuc vu admin 
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/NhanVien/them-phan-cong-nhan-vien.jsp");
			dispatcher.forward(request, response);
		//neu khong phai admin	
		}else{
			response.sendRedirect(request.getContextPath()+"/dashboard");
		}
		//----end---
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();

		int idNhanVien = Integer.parseInt(request.getParameter("idNhanVien"));
		int idCa = Integer.parseInt(request.getParameter("idCaLamViec"));
		int idThuNgay = Integer.parseInt(request.getParameter("idThuNgay"));
		PhanCongNhanVienBEAN phanCongNhanVienBEAN = new PhanCongNhanVienBEAN();

		phanCongNhanVienBEAN.setIdNhanVien(idNhanVien);
		phanCongNhanVienBEAN.setIdCa(idCa);
		phanCongNhanVienBEAN.setIdThuNgay(idThuNgay);

		if (NhanVienBO.addPhanCongNhanVien(phanCongNhanVienBEAN)) {
			msg.setAttribute("messages", "<ul><li>Thêm phân công cho nhân viên thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		} else {
			msg.setAttribute("errors", "<ul><li>Thêm phân công cho nhân viên không thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		}

	}

}
