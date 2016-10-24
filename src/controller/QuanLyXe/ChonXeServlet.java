package controller.QuanLyXe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DieuPhoiBEAN;
import model.bean.XeBEAN;
import model.bo.DieuPhoiBO;


/**
 * Servlet implementation class ChonXeServlet
 */
// @WebServlet("/ChonXeServlet")
public class ChonXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChonXeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = DieuPhoiBO.getMaxIDDieuPhoi();
		
		int loaiXe = DieuPhoiBO.getLoaiXe(id);
		
		ArrayList<XeBEAN> listXe = DieuPhoiBO.lietKeListXeDieuPhoi(loaiXe);
		request.setAttribute("danhSachXe", listXe);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Xe/ChonXe.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("accept");
//		System.out.println(param);
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DieuPhoiBEAN dieuphoi = new DieuPhoiBEAN();
		dieuphoi.setIdPhanCong(DieuPhoiBO.getIDPhanCong(id));
		dieuphoi.setId(DieuPhoiBO.getMaxIDDieuPhoi());
		
		boolean check = DieuPhoiBO.updateIDPhanCong(dieuphoi);
		if (check) {
			response.sendRedirect(request.getContextPath() + "/list-xe");
		} else {
			System.out.println("Fail");
		}
	}

}
