package controller.QuanLyXe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.XeBEAN;
import model.bo.XeBO;

/**
 * Servlet implementation class UpdateXeServlet
 */
// @WebServlet("/UpdateXeServlet")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String param = request.getParameter("id");
		
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		XeBEAN xebean = XeBO.getCapNhatXe(id);
		request.setAttribute("xeduocchon", xebean);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Xe/CapNhatXe.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();

		String param = request.getParameter("id");

		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		XeBEAN xe = new XeBEAN();

		xe.setId(id);
		xe.setModel(request.getParameter("model"));
		xe.setSoCho(Integer.parseInt(request.getParameter("sochongoi")));
		xe.setHang(request.getParameter("hang"));
		xe.setGhiChu(request.getParameter("ghichu"));

		if (XeBO.setCapNhatXe(xe)) {
				msg.setAttribute("messages", "<ul><li>Cập nhật xe thành công!</li></ul>");
				response.sendRedirect(request.getContextPath() + "/list-xe");
		} else {
			msg.setAttribute("errors", "<ul><li>Lỗi cơ sở dữ liệu!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/cap-nhat-xe");
		}
	}

}
