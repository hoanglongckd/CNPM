package controller.Profiles;

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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check isLogin
		HttpSession session = request.getSession();
		String maNV = null;
		if(session.getAttribute("maNV")==null){
			response.sendRedirect(request.getContextPath()+"/login");
		}else{
			// ---kiem tra chucvu cua nhan vien---
			ChucVuBO chucVuBO = new ChucVuBO();
			maNV = (String) session.getAttribute("maNV");
			NhanVienBEAN nhanVien = nhanVienBO.getNhanVienByMaNV(maNV);
			if(nhanVien.getIdChucVu()!=1){
				response.sendRedirect(request.getContextPath()+"/dashboard");
			}else{
				//la admin
				ArrayList<NhanVienBEAN> listNhanVien = nhanVienBO.getDanhSachNhanVienNguyen();
				for(NhanVienBEAN nv :listNhanVien){
					if(nv.getIdChucVu()==1) listNhanVien.remove(nv);
					break;
				}
				request.setAttribute("listNhanVien", listNhanVien);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/QuanLyTaiKhoan/quanlytaikhoan.jsp");
				dispatcher.forward(request, response);
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
