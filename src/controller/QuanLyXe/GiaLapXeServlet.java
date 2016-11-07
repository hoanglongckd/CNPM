package controller.QuanLyXe;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaoDuongXeBEAN;
import model.bean.DieuPhoiBEAN;
import model.bean.XeBEAN;
import model.bo.BaoDuongXeBO;
import model.bo.DieuPhoiBO;
import model.bo.XeBO;

/**
 * Servlet implementation class GiaLapXeServlet
 */
// @WebServlet("/GiaLapXeServlet")
public class GiaLapXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GiaLapXeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String maNV = ses.getAttribute("maNV").toString();

		ArrayList<DieuPhoiBEAN> dieuPhoiBEAN = DieuPhoiBO.getDieuPhoi();
		// for (DieuPhoiBEAN dieuphoi : dieuPhoiBEAN){
		// System.out.println(dieuphoi.getBienSoXe());
		// }

		request.setAttribute("dieuPhoiBEAN", dieuPhoiBEAN);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/Xe/GiaLapXe.jsp");
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

		DieuPhoiBEAN dieuPhoiXe = new DieuPhoiBEAN();

		dieuPhoiXe.setId(Integer.parseInt(request.getParameter("bien-so-xe")));
		dieuPhoiXe.setThoiGianBatDau(request.getParameter("date-started"));
		dieuPhoiXe.setThoiGianKetThuc(request.getParameter("date-ended"));
		dieuPhoiXe.setSoKM(Integer.parseInt(request.getParameter("kilomet")));

		if (request.getParameter("date-started").compareTo(request.getParameter("date-ended")) < 0) {
			if (DieuPhoiBO.ketThucDieuPhoi(dieuPhoiXe)) {
				if (DieuPhoiBO.tinhTien(dieuPhoiXe)) {
					msg.setAttribute("messages", "<ul><li>Kết thúc điều phối thành công!</li></ul>");
					response.sendRedirect(request.getContextPath() + "/danh-sach-dieu-phoi");
				} else {
					msg.setAttribute("errors", "<ul><li>Lỗi khi tính tiền!</li></ul>");
					response.sendRedirect(request.getContextPath() + "/gia-lap-xe");
				}
			} else {
				msg.setAttribute("errors", "<ul><li>Lỗi cơ sở dữ liệu!</li></ul>");
				response.sendRedirect(request.getContextPath() + "/gia-lap-xe");
			}
		} else {
			msg.setAttribute("errors",
					"<ul><li><b>Thời gian kết thúc</b> phải xảy ra sau <b>Thời gian bắt đầu</b>.</li></ul>");
			response.sendRedirect(request.getContextPath() + "/gia-lap-xe");
		}

	}

}
