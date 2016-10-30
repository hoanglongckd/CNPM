package controller.QuanLyVangNghi;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.QuanLyVangNghiBEAN;
import model.bo.QuanLyVangNghiBO;

/**
 * Servlet implementation class CapNhatVangNghiController
 */
//@WebServlet("/CapNhatVangNghiController")
public class CapNhatVangNghiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatVangNghiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		QuanLyVangNghiBEAN item = QuanLyVangNghiBO.getCapNhapVangNghi(id);
		try {
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = simpleDateFormat1.parse(item.getNgayNghi());
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
			item.setNgayNghi(simpleDateFormat2.format(date1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("item", item);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/VangNghi/update-vang-nghi.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int idNhanVien = Integer.parseInt(request.getParameter("idNhanVien"));
		String lyDo = request.getParameter("lydo");
		String ngayNghi = request.getParameter("ngay-nghi");
		boolean coPhep = false;
		Date date1;
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
		
		if (request.getParameter("phep").equals("Yes")) coPhep = true;
		try {
			date1 = simpleDateFormat1.parse(ngayNghi);
			ngayNghi = simpleDateFormat2.format(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		QuanLyVangNghiBEAN item = new QuanLyVangNghiBEAN(ngayNghi, lyDo, coPhep, id);
		if (QuanLyVangNghiBO.setCapNhapVangNghi(item)) {
			msg.setAttribute("messages", "Cập nhật nhân viên vắng nghỉ thành công!");
			response.sendRedirect(request.getContextPath() + "/chi-tiet-vang-nghi?id=" + idNhanVien);
		} else {
			msg.setAttribute("errors", "Có lỗi xảy ra. Vui lòng liên hệ với nhà cung cấp dịch vụ!");
			response.sendRedirect(request.getContextPath() + "/chi-tiet-vang-nghi?id=" + idNhanVien);
		}
	}

}
