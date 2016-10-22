package controller.BaoDuongXe;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaoDuongXeBEAN;
import model.bean.XeBEAN;
import model.bo.BaoDuongXeBO;

/**
 * Servlet implementation class AddBaoDuongXeController
 */
//@WebServlet("/them-xe-bao-duong")
public class ThemXeBaoDuongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemXeBaoDuongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<XeBEAN> listXe =  BaoDuongXeBO.lietKeXe();
		request.setAttribute("listXe", listXe);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/BaoDuongXe/them-xe-bao-duong.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession msg = request.getSession();
		
		int idXe = Integer.parseInt(request.getParameter("idCar"));
		String ngayBaoDuongHienTai = request.getParameter("current-date");
		String ngayBaoDuongTiepTheo = request.getParameter("next-date");
		long chiPhiBaoDuong = 0;
		try {
			chiPhiBaoDuong = Long.parseLong(request.getParameter("cost"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		String chiTiet = request.getParameter("detail");
		
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date date1 = simpleDateFormat1.parse(ngayBaoDuongHienTai);
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			ngayBaoDuongHienTai = simpleDateFormat2.format(date1);
			Date date11 = simpleDateFormat2.parse(ngayBaoDuongHienTai);
			
			Date date2 = simpleDateFormat1.parse(ngayBaoDuongTiepTheo);
			ngayBaoDuongTiepTheo = simpleDateFormat2.format(date2);
			Date date22 = simpleDateFormat2.parse(ngayBaoDuongTiepTheo);
			
			if (date22.after(date11)) {
				BaoDuongXeBEAN baoDuongXeBEAN = new BaoDuongXeBEAN();
				baoDuongXeBEAN.setIdXe(idXe);
				baoDuongXeBEAN.setNgayBaoDuong(ngayBaoDuongHienTai);
				baoDuongXeBEAN.setNgayBaoDuongTiepTheo(ngayBaoDuongTiepTheo);
				baoDuongXeBEAN.setSoTien(chiPhiBaoDuong);
				baoDuongXeBEAN.setChiTiet(chiTiet);
				if (BaoDuongXeBO.themXeBaoDuong(baoDuongXeBEAN)) {
					msg.setAttribute("messages", "<ul><li>Thêm xe bảo dưỡng thành công!</li></ul>");
					response.sendRedirect(request.getContextPath() + "/bao-cao-xe-bao-duong");
				}
				else {
					msg.setAttribute("errors", "<ul><li>Có lỗi xảy ra! Vui lòng liên hệ với nhà cung cấp dịch vụ!</li></ul>");
					response.sendRedirect(request.getContextPath() + "/them-xe-bao-duong");
				}
			} else {
				msg.setAttribute("errors", "<ul><li><b>Ngày bảo dưỡng tiếp theo</b> phải xảy ra sau <b>Ngày bảo dưỡng hiện tại</b>.</li></ul>");
				response.sendRedirect(request.getContextPath() + "/them-xe-bao-duong");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
