package controller.QuanLyVangNghi;

import java.io.IOException;
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

import model.bean.QuanLyVangNghiBEAN;
import model.bo.QuanLyVangNghiBO;

/**
 * Servlet implementation class ThemMoiVangNghi
 */
//@WebServlet("/ThemMoiVangNghi")
public class ThemMoiVangNghiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemMoiVangNghiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<QuanLyVangNghiBEAN> list = QuanLyVangNghiBO.lietKeMaNV();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/VangNghi/them-vang-nghi.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();
		
		int idNhanVien = Integer.parseInt(request.getParameter("id-nhan-vien"));
		String lyDo = request.getParameter("lyDo");
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
		
		QuanLyVangNghiBEAN item = new QuanLyVangNghiBEAN(idNhanVien, ngayNghi, lyDo, coPhep);
		if (QuanLyVangNghiBO.themMoiVangNghi(item)) {
			msg.setAttribute("messages", "Thêm mới nhân viên vắng nghỉ thành công!");
			response.sendRedirect(request.getContextPath() + "/danh-sach-vang-nghi");
		} else {
			msg.setAttribute("errors", "Có lỗi xảy ra. Vui lòng liên hệ với nhà cung cấp dịch vụ!");
			response.sendRedirect(request.getContextPath() + "/danh-sach-vang-nghi");
		}
		
	}

}
