package controller.NhanVien;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NhanVienBO;

/**
 * Servlet implementation class DeleteNhanVienController
 */
//@WebServlet("/DeleteNhanVienController")
public class DeleteNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNhanVienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NhanVienBO nhanVienBO = new NhanVienBO();
		
		String idNhanVien= request.getParameter("idNhanVien");
		
		if(nhanVienBO.isNhanVienDeleted(idNhanVien)){
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		}
		else{
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/NhanVien/Error-delete-page.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
