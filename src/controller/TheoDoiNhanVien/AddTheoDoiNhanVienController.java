package controller.TheoDoiNhanVien;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVienBEAN;
import model.bean.TheoDoiNhanVienBEAN;
import model.bo.NhanVienBO;
import model.bo.TheoDoiNhanVienBO;

/**
 * Servlet implementation class TheoDoiNhanVienController
 */
//@WebServlet("/AddTheoDoiNhanVien")
public class AddTheoDoiNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTheoDoiNhanVienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<NhanVienBEAN> listnv = TheoDoiNhanVienBO.getInstance().getListNhanVien();
		request.setAttribute("listNV", listnv);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/VangNghi/them-vang-nghi.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAdd")!=null){
			ArrayList<NhanVienBEAN> listNV  = TheoDoiNhanVienBO.getInstance().getListNhanVien();
			
			
			String phep = request.getParameter("rdPhep");
			boolean p;
			
			if(phep.equals("Yes")){
				p= true;
			}
			else{
				p = false;
			}
			
			
			TheoDoiNhanVienBEAN vn = new TheoDoiNhanVienBEAN(request.getParameter("ngay-nghi"),p,
					request.getParameter("lydo"),
					listNV.get(Integer.parseInt(request.getParameter("idNV"))-1).getId());
			
			if(TheoDoiNhanVienBO.getInstance().themVangNghi(vn)){
				doGet(request,response);
			}
			else{
				System.out.println("Fail");
			}
	}
	}
}
