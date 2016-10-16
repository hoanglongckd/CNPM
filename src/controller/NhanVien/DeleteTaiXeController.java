package controller.NhanVien;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NhanVien.DeleteNhanVienBO;
import model.bo.NhanVien.DeleteTaiXeBO;

/**
 * Servlet implementation class DeleteTaiXeController
 */
@WebServlet("/DeleteTaiXeController")
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
		DeleteTaiXeBO deleteTaiXeBO = new DeleteTaiXeBO();
		
		String idTaiXe= request.getParameter("idTaiXe");
		
		if(deleteTaiXeBO.isDeleted(idTaiXe)){
			
			//Chua goi bang sevlet
			  RequestDispatcher rd = request.getRequestDispatcher("");
		      rd.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/NhanVien/Error-delete-page.jsp");
			dispatcher.forward(request, response);
		}
	}

}
