package controller.TheoDoiNhanVien;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVienVangNghiBEAN;
import model.bo.NhanVienVangNghiBO;

/**
 * Servlet implementation class DanhSachVangNghiController
 */
//@WebServlet("/DanhSachVangNghiController")
public class DanhSachVangNghiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachVangNghiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<NhanVienVangNghiBEAN> list = NhanVienVangNghiBO.getInstance().getList();
		request.setAttribute("listVN", list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/VangNghi/danh-sach-vang-nghi.jsp");
		rd.forward(request, response);
	}
}
