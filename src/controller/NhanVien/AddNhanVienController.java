package controller.NhanVien;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaoDuongXeBEAN;
import model.bean.ChucVuBEAN;
import model.bean.NhanVienBEAN;
import model.bo.BaoDuongXeBO;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class AddBaoDuongXeController
 */
// @WebServlet("/them-nhan-vien")
public class AddNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNhanVienController() {
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
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/NhanVien/them-nhan-vien.jsp");
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
		// Lay ma chuc vu nhan vien
		ChucVuBEAN chucVuBEAN = NhanVienBO.getChucVu();
		// Lay thong tin nhan vien tu form add
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();
		String maNV = request.getParameter("manhanvien");
		String hoTen = request.getParameter("hovaten");
		int idChucVu = chucVuBEAN.getId();
		String ngaySinh = request.getParameter("ngay-sinh");
		String password = "123456"; // Mat khau mac dinh la 123456

		NhanVienBEAN nhanVienBEAN = new NhanVienBEAN();

		nhanVienBEAN.setMaNhanVien(maNV);
		nhanVienBEAN.setHoTen(hoTen);
		nhanVienBEAN.setNgaySinh(ngaySinh);
		nhanVienBEAN.setPassword(password);
		nhanVienBEAN.setIdChucVu(idChucVu);
		if (NhanVienBO.addNhanVien(nhanVienBEAN)) {
			msg.setAttribute("messages", "<ul><li>Thêm nhân viên thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		} else {
			msg.setAttribute("errors", "<ul><li>Thêm nhân viên không thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		}

	}

}
