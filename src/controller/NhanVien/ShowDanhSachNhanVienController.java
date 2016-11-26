package controller.NhanVien;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVienBEAN;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class ShowDanhSachNhanVienController
 */
// @WebServlet("/ShowDanhSachNhanVienController")
public class ShowDanhSachNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowDanhSachNhanVienController() {
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
			NhanVienBO nhanVienBO = new NhanVienBO();

			ArrayList<NhanVienBEAN> listNhanVien = nhanVienBO.getDanhSachNhanVien();
			request.setAttribute("listNhanVien", listNhanVien);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NhanVien/danh-sach-nhan-vien.jsp");
			rd.forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
