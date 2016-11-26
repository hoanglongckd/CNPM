package controller.QuanLyXe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.DieuPhoiBEAN;
import model.bo.DieuPhoiBO;

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
		HttpSession session = request.getSession();
		if(session.getAttribute("maChucVu").toString().equals("AD")){// kiem tra chuc vu admin 
			ArrayList<DieuPhoiBEAN> dieuPhoiBEAN = DieuPhoiBO.getDieuPhoi();
			request.setAttribute("dieuPhoiBEAN", dieuPhoiBEAN);

			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/Xe/GiaLapXe.jsp");
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/dashboard");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();

		//set dieuphoi final
		DieuPhoiBEAN dieuPhoiXe = new DieuPhoiBEAN();
		dieuPhoiXe.setId(Integer.parseInt(request.getParameter("bien-so-xe")));
		dieuPhoiXe.setThoiGianBatDau(request.getParameter("date-started"));
		dieuPhoiXe.setThoiGianKetThuc(request.getParameter("date-ended"));
		dieuPhoiXe.setSoKM(Integer.parseInt(request.getParameter("kilomet")));

		//check if dieuphoi successful or not
		if (request.getParameter("date-started").compareTo(request.getParameter("date-ended")) < 0) {
			if (DieuPhoiBO.ketThucDieuPhoi(dieuPhoiXe)) {
				if (DieuPhoiBO.tinhTien(dieuPhoiXe)) {
					if (DieuPhoiBO.updateTTFalse(dieuPhoiXe)) {
						msg.setAttribute("messages", "<ul><li>Kết thúc điều phối thành công!</li></ul>");
						response.sendRedirect(request.getContextPath() + "/danh-sach-dieu-phoi");
					} else {
						msg.setAttribute("errors", "<ul><li>Lỗi khi cập nhật trạng thái xe!</li></ul>");
						response.sendRedirect(request.getContextPath() + "/gia-lap-xe");
					}
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
