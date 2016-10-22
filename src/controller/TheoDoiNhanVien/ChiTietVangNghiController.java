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
 * Servlet implementation class ChiTietVangNghiController
 */
@WebServlet("/chi-tiet-vang-nghi")
public class ChiTietVangNghiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietVangNghiController() {
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
			ArrayList<TheoDoiNhanVienBEAN> list= TheoDoiNhanVienBO.getInstance().getListVangNghiById(id);
			
			request.setAttribute("listVN", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/VangNghi/chi-tiet-vang-nghi.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("delete")!=null){
			
			String s = request.getParameter("delete");
			String[] arr = s.split(",");
			
			int idDelete = Integer.parseInt(arr[0]);
			int idNhanVien = Integer.parseInt(arr[1]);
			
			TheoDoiNhanVienBO.getInstance().deleteVangNghiById(idDelete);
			
			ArrayList<TheoDoiNhanVienBEAN> list= TheoDoiNhanVienBO.getInstance().getListVangNghiById(idNhanVien);
			
			request.setAttribute("listVN", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/VangNghi/chi-tiet-vang-nghi.jsp");
			rd.forward(request, response);
		}
	}
}
