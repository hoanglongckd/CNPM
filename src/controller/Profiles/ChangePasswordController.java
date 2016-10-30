package controller.Profiles;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVienBEAN;
import model.bo.ChucVuBO;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class LogoutController
 */
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordController() {
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
			String msg =  "";
			if(request.getParameter("msg")!=null){
				msg = (request.getParameter("msg"));
			}
			
			if(request.getParameter("id")!=null){
				maNV = request.getParameter("id");
			}else{
			maNV = (String) session.getAttribute("maNV");
			}
			
			NhanVienBEAN nhanVien = nhanVienBO.getNhanVienByMaNV(maNV);
			if(msg!="") request.setAttribute("msg", msg);
			request.setAttribute("nhanVien", nhanVien);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/QuanLyTaiKhoan/changepassword.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("maNV")==null)response.sendRedirect(request.getContextPath()+"/login");
		//
		if(request.getParameter("submit")!=null){
			String maNhanVien =(request.getParameter("maNhanVien"));
			String newPassword = request.getParameter("new-password");
			String idUser = "";
			if(session.getAttribute("maNV")==null){
				response.sendRedirect(request.getContextPath()+"/login");
			}else{
				idUser = (session.getAttribute("maNV").toString());
			}
			//
			if(maNhanVien.equals(idUser)){
				NhanVienBEAN nhanVien = new NhanVienBEAN(0,maNhanVien,"","",0,newPassword);
				if(nhanVienBO.updatePassword(nhanVien))
					response.sendRedirect(request.getContextPath()+"/doi-mat-khau?msg=1");
				else response.sendRedirect(request.getContextPath()+"/doi-mat-khau?msg=2");
			}else{
				NhanVienBEAN nhanVien = new NhanVienBEAN(0,idUser,"","",0,newPassword);
				if(nhanVienBO.updatePassword(nhanVien))
					response.sendRedirect(request.getContextPath()+"/doi-mat-khau?msg=1");
				else response.sendRedirect(request.getContextPath()+"/doi-mat-khau?msg=2");
			}
		}
	}

}
