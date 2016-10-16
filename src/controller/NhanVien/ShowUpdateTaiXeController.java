package controller.NhanVien;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien.NhanVienBEAN;
import model.bo.NhanVien.ShowUpdateTaiXeBO;

/**
 * Servlet implementation class ShowUpdateTaiXeController
 */
@WebServlet("/ShowUpdateTaiXeController")
public class ShowUpdateTaiXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpdateTaiXeController() {
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
		ShowUpdateTaiXeBO showUpdateTaiXeBO=new ShowUpdateTaiXeBO();
		
		String idTaiXe=request.getParameter("idTaiXe");
		//System.out.println(idTaiXe);
		NhanVienBEAN taiXe=showUpdateTaiXeBO.getTaiXe(idTaiXe);
		request.setAttribute("taiXe", taiXe);
		//System.out.println(taiXe.getNgaySinh());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NhanVien/chinh-sua-tai-xe.jsp");
		rd.forward(request, response);
	}

}
