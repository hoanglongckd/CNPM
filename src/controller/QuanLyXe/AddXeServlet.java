package controller.QuanLyXe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.TaiXeBEAN;
import model.bean.XeBEAN;
import model.bo.XeBO;

/**
 * Servlet implementation class AddXeServlet
 */
// @WebServlet("/AddXeServlet")
public class AddXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddXeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/Xe/QuanLyXe.jsp");
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

		XeBEAN xe = new XeBEAN();
		TaiXeBEAN taixe = new TaiXeBEAN();
		taixe.setId(Integer.parseInt(request.getParameter("tentx")));
		xe.setBienSoXe(request.getParameter("biensoxe"));
		xe.setModel(request.getParameter("model"));
		xe.setSoCho(Integer.parseInt(request.getParameter("sochongoi")));
		xe.setHang(request.getParameter("hang"));
		xe.setGhiChu(request.getParameter("ghichu"));
		xe.setTinhTrangHoatDong(false);

		boolean check = XeBO.themXe(xe);

		xe.setId(XeBO.getMaxXeId());
		boolean check2 = XeBO.themPhanCongTX(taixe, xe);

		if (check) {
			if (check2)
				msg.setAttribute("messages", "<ul><li>Thêm xe thành công!</li></ul>");
				response.sendRedirect(request.getContextPath() + "/list-xe");
		} else {
			msg.setAttribute("errors", "<ul><li>Lỗi cơ sở dữ liệu!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/them-xe");
		}

		// }catch(Exception e){
		// response.sendRedirect(request.getContextPath() + "/listXe");
		// }
	}

}
