package controller.TheoDoiNhanVien;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TheoDoiNhanVienBEAN;
import model.bo.TheoDoiNhanVienBO;

/**
 * Servlet implementation class UpdateVangNghiController
 */
@WebServlet("/update-vang-nghi")
public class UpdateVangNghiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVangNghiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("id")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
			TheoDoiNhanVienBEAN nv = TheoDoiNhanVienBO.getInstance().getVangNghiById(id);
			
			request.setAttribute("NV", nv);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/VangNghi/update-vang-nghi.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnUpdate")!=null || request.getParameter("btnCancel")!=null){
			int  idNhanVien =0;
		
		if(request.getParameter("btnUpdate")!=null ){
			idNhanVien = Integer.parseInt(request.getParameter("btnUpdate"));
			String phep = request.getParameter("rdPhep");
			boolean p;
			
			if(phep.equals("Yes")){
				p= true;
			}
			else{
				p = false;
			}
			
			TheoDoiNhanVienBEAN vn = new TheoDoiNhanVienBEAN(Integer.parseInt(request.getParameter("action")),request.getParameter("ngay-nghi"),p,
					request.getParameter("lydo"),
					Integer.parseInt(request.getParameter("ma-nhan-vien"))
					);
			
			if(TheoDoiNhanVienBO.getInstance().suaTheoDoiNhanVien(vn)){
				doGet(request,response);
			}
		}
		
		if(request.getParameter("btnCancel")!=null){
			idNhanVien = Integer.parseInt(request.getParameter("btnCancel"));
		}
		
		request.setAttribute("id", idNhanVien);
		
		ArrayList<TheoDoiNhanVienBEAN> list= TheoDoiNhanVienBO.getInstance().getListVangNghiById(idNhanVien);
		
		request.setAttribute("listVN", list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/VangNghi/chi-tiet-vang-nghi.jsp");
		rd.forward(request, response);
		}
	}
}
