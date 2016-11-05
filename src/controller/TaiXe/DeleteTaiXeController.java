package controller.TaiXe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NhanVienBO;
import model.bo.TaiXeBO;

/**
 * Servlet implementation class DeleteTaiXeController
 */

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
		HttpSession msg = request.getSession();
		TaiXeBO taiXeBO = new TaiXeBO();
		
		String idTaiXe= request.getParameter("idTaiXe");
		
		if(taiXeBO.isTaiXeDeleted(idTaiXe)){
			msg.setAttribute("messages", "<ul><li>Xóa tài xế thành công!</li></ul>");			
			response.sendRedirect(request.getContextPath() + "/danh-sach-tai-xe");
		}
		else{
			msg.setAttribute("errors", "<ul><li>Xóa tài xế không thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-tai-xe");
		}
	}

}
