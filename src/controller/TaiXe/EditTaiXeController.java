package controller.TaiXe;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.TaiXeBEAN;
import model.bo.TaiXeBO;

/**
 * Servlet implementation class SuaXeBaoDuongController
 */

public class EditTaiXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditTaiXeController() {
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
			String idTaiXe = request.getParameter("idTaiXe");

			TaiXeBEAN taiXeBEAN = TaiXeBO.getTaiXe(idTaiXe);
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date1 = simpleDateFormat1.parse(taiXeBEAN.getNgaySinh());
				SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
				taiXeBEAN.setNgaySinh(simpleDateFormat2.format(date1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("taiXe", taiXeBEAN);
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/TaiXe/chinh-sua-tai-xe.jsp");
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
		String param = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String hoTen = request.getParameter("hovaten");
		String ngaySinh = request.getParameter("ngay-sinh");

		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date date1 = simpleDateFormat1.parse(ngaySinh);
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			ngaySinh = simpleDateFormat2.format(date1);
			Date date11 = simpleDateFormat2.parse(ngaySinh);

			TaiXeBEAN taiXeBEAN = new TaiXeBEAN();
			taiXeBEAN.setId(id);
			taiXeBEAN.setNgaySinh(ngaySinh);
			taiXeBEAN.setHoTen(hoTen);
			if (TaiXeBO.setSuaTaiXe(taiXeBEAN)) {
				msg.setAttribute("messages", "<ul><li>Chỉnh sửa tài xế thành công! </li></ul>");
				response.sendRedirect(request.getContextPath() + "/danh-sach-tai-xe");
			} else {
				msg.setAttribute("errors", "<ul><li>Chỉnh sửa tài xế không thành công!</li></ul>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
