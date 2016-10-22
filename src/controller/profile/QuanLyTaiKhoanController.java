package controller.profile;

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
import model.bo.ChucVuBO;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class QuanLyNhanVienController
 */
@WebServlet("/QuanLyNhanVienController")
public class QuanLyTaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyTaiKhoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    NhanVienBO nhanVienBO = new NhanVienBO();
    ChucVuBO chucVuBO = new ChucVuBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String maNV = null;
		if(session.getAttribute("maNV")==null){
			response.sendRedirect(request.getContextPath()+"/login");
		}else {
			maNV = (String) session.getAttribute("maNV");
			NhanVienBEAN nhanVien = nhanVienBO.getNhanVien(maNV);
			if(nhanVien==null)System.out.println("null");
			// ---kiem tra chucvu cua nhan vien---
			if(nhanVien.getId()==1){
				ArrayList<NhanVienBEAN> listNhanVien = nhanVienBO.getDanhSachNhanVien();
				request.setAttribute("listNhanVien", listNhanVien);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/QuanLyTaiKhoan/quanlytaikhoan.jsp");
				dispatcher.forward(request, response);
			}else{
				//khong phai admin
				response.sendRedirect(request.getContextPath()+"/dashboard");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
