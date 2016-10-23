package controller.QuanLyXe;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TaiXeBEAN;
import model.bean.XeBEAN;
import model.bo.TaiXeBO;
import model.bo.XeBO;

/**
 * Servlet implementation class UpdateXeServlet
 */
//@WebServlet("/UpdateXeServlet")
public class UpdateXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateXeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("id");
//		System.out.println(param);
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		XeBEAN xebean = XeBO.getCapNhatXe(id);
		request.setAttribute("xeduocchon", xebean);

		TaiXeBO taiXebo = new TaiXeBO();
		List<TaiXeBEAN> listTX = null;
		listTX = taiXebo.getAllTenTX();
		request.setAttribute("listTX", listTX);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Xe/CapNhatXe.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String param = request.getParameter("id");
		
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		XeBEAN xe = new XeBEAN();
		TaiXeBEAN taixe = new TaiXeBEAN();
		taixe.setId(Integer.parseInt(request.getParameter("tentx")));
		
		xe.setId(id);
//		xe.setTaiXe(request.getParameter("tentx"));
		xe.setModel(request.getParameter("model"));
		xe.setSoCho(Integer.parseInt(request.getParameter("sochongoi")));
		xe.setHang(request.getParameter("hang"));
		xe.setGhiChu(request.getParameter("ghichu"));
		
//		System.out.println(id);
//		System.out.println(request.getParameter("tentx"));
		
		boolean check = XeBO.setCapNhatXe(xe);
		boolean check2 = XeBO.setCapNhatPhanCongTX(taixe, xe);
		
		if (check) {
			if (check2)
			response.sendRedirect(request.getContextPath() + "/list-xe");
		} else {
			System.out.println("Fail");
		}
	}

}
