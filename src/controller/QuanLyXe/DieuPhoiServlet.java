package controller.QuanLyXe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.DieuPhoiBEAN;
import model.bo.DieuPhoiBO;

/**
 * Servlet implementation class DieuPhoiServlet
 */
//@WebServlet("/DieuPhoiServlet")
public class DieuPhoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DieuPhoiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Xe/DieuPhoi.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();
		
		//set diachi and loaixe to dieuphoi
		DieuPhoiBEAN dieuphoi = new DieuPhoiBEAN();
		dieuphoi.setDiaChi(request.getParameter("diadiem"));
		dieuphoi.setLoaiXe(Integer.parseInt(request.getParameter("loaixe")));
		
		//check if dieuphoi successful or not
		if(DieuPhoiBO.themDieuPhoi(dieuphoi)){
			response.sendRedirect(request.getContextPath() + "/chon-xe");
		} else {
			msg.setAttribute("errors", "<ul><li>Lỗi cơ sở dữ liệu khi thêm điều phối!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/dieu-phoi");
		}
	}
}
