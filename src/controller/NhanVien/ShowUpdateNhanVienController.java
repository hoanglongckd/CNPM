package controller.NhanVien;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien.NhanVienBEAN;
import model.bo.NhanVien.ShowUpdateNhanVienBO;

/**
 * Servlet implementation class ShowUpdateNhanVienController
 */
@WebServlet("/ShowUpdateNhanVienController")
public class ShowUpdateNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpdateNhanVienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ShowUpdateNhanVienBO showUpdateNhanVienBO=new ShowUpdateNhanVienBO();
		
		String idNhanVien=request.getParameter("idNhanVien");
		//System.out.println(idNhanVien);
		NhanVienBEAN nhanVien=showUpdateNhanVienBO.getNhanVien(idNhanVien);
		request.setAttribute("nhanVien", nhanVien);
		//System.out.println(nhanVien.getNgaySinh());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NhanVien/chinh-sua-tai-xe.jsp");
		rd.forward(request, response);
	}

}
