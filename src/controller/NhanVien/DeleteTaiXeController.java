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
 * Servlet implementation class DeleteTaiXeController
 */
//@WebServlet("/DeleteTaiXeController")
public class DeleteTaiXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTaiXeController() {
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
		
		String idTaiXe= request.getParameter("idTaiXe");
		
		if(nhanVienBO.isTaiXeDeleted(idTaiXe)){
			if(nhanVienBO.isNhanVienDeleted(idTaiXe)){
				response.sendRedirect(request.getContextPath() + "/danh-sach-tai-xe");
			}
			else{
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/NhanVien/Error-delete-page.jsp");
				dispatcher.forward(request, response);
			}
		}		
	}

}
