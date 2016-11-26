package controller.QuanLyVangNghi;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.QuanLyVangNghiBEAN;
import model.bo.QuanLyVangNghiBO;

/**
 * Servlet implementation class ChiTietVangNghi
 */
//@WebServlet("/ChiTietVangNghi")
public class ChiTietVangNghiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietVangNghiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		///kiem tra chuc vu admin 
		if(session.getAttribute("maChucVu").toString().equals("AD")){// kiem tra chuc vu admin 
			HttpSession msg = request.getSession();
			
			int idNhanVien = 0;
			try {
				idNhanVien = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				msg.setAttribute("errors", "Vui lòng không chỉnh sửa đường dẫn.");
				response.sendRedirect(request.getContextPath() + "/danh-sach-vang-nghi");
				e.printStackTrace();
			}
			QuanLyVangNghiBEAN nhanVien = QuanLyVangNghiBO.layChiTietNV(idNhanVien);
			ArrayList<QuanLyVangNghiBEAN> list = QuanLyVangNghiBO.lietKeVangNghiMotNV(idNhanVien);
			request.setAttribute("nhanVien", nhanVien);
			request.setAttribute("list", list);
			request.setAttribute("idNV", idNhanVien);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/VangNghi/chi-tiet-vang-nghi.jsp");
			dispatcher.forward(request, response);
		//neu khong phai admin	
		}else{
			response.sendRedirect(request.getContextPath()+"/dashboard");
		}
		//----end---
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
