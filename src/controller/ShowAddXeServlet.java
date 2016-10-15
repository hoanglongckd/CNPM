package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TaiXe;
import model.bo.taiXeBO;

/**
 * Servlet implementation class ShowAddXeServlet
 */
@WebServlet("/ShowAddXe")
public class ShowAddXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAddXeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		try {

			// get List Name Of Class present
			taiXeBO taiXebo = new taiXeBO();
			List<TaiXe> listMaTX = null;
			listMaTX = taiXebo.getAllMaTX();
			request.setAttribute("listMaTX", listMaTX);
			System.out.println(listMaTX.get(0));
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/QuanLyXe.jsp");
			dispatcher.forward(request, response);

//		} catch (Exception e) {
//			response.sendRedirect(request.getContextPath() + "/listXe");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
