package controller.NhanVien;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession msg = request.getSession();
		
		NhanVienBO nhanVienBO = new NhanVienBO();
		
		String idNhanVien= request.getParameter("idNhanVien");
		
		if(nhanVienBO.isNhanVienDeleted(idNhanVien)){
			msg.setAttribute("messages", "<ul><li>X�a nh�n vi�n th�nh c�ng!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		}
		else{
			msg.setAttribute("errors", "<ul><li>X�a nh�n vi�n kh�ng th�nh c�ng</li></ul>");	
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		}
		
	}

}
