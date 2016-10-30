package controller.DangNhap;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVienBEAN;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class Login
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("maNV")!=null){
			response.sendRedirect(request.getContextPath()+"/dashboard");
		}else {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/login/login.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//get
		String maNV = request.getParameter("maNV");
		String password = request.getParameter("password");
		NhanVienBO nhanVienBO = new NhanVienBO();
		//kiem tra MaNV
		NhanVienBEAN nhanVien = nhanVienBO.getNhanVienByMaNV(maNV);
		if(nhanVien!=null){	
			//kiem tra password
			if(nhanVien.getPassword().equals(password)){
				//tao session
				session.setAttribute("maNV", maNV);
				//chuyen sang trang dashboardController
				response.sendRedirect(request.getContextPath()+"/dashboard");
				//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/_content.jsp");
			}else{
				request.setAttribute("maNV", maNV);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp?loi=2");
				rd.forward(request, response);
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp?loi=1");
			rd.forward(request, response);
		}
	}
}
