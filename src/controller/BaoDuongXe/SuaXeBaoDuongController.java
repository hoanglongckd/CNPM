package controller.BaoDuongXe;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaoDuongXeBEAN;
import model.bo.BaoDuongXeBO;

/**
 * Servlet implementation class SuaXeBaoDuongController
 */
//@WebServlet("/SuaXeBaoDuongController")
public class SuaXeBaoDuongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaXeBaoDuongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaoDuongXeBEAN baoDuongXeBEAN = BaoDuongXeBO.getSuaXe(id);
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = simpleDateFormat1.parse(baoDuongXeBEAN.getNgayBaoDuong());
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
			baoDuongXeBEAN.setNgayBaoDuong(simpleDateFormat2.format(date1));
			System.out.println(baoDuongXeBEAN.getNgayBaoDuong());
			
			Date date2 = simpleDateFormat1.parse(baoDuongXeBEAN.getNgayBaoDuongTiepTheo());
			baoDuongXeBEAN.setNgayBaoDuongTiepTheo(simpleDateFormat2.format(date2));
			System.out.println(baoDuongXeBEAN.getNgayBaoDuongTiepTheo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("xeDaBaoDuong", baoDuongXeBEAN);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/BaoDuongXe/sua-xe-bao-duong.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String param = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ngayBaoDuongHienTai = request.getParameter("current-date");
		String ngayBaoDuongTiepTheo = request.getParameter("next-date");
		long chiPhiBaoDuong = 0;
		try {
			chiPhiBaoDuong = Long.parseLong(request.getParameter("cost"));
		} catch (Exception e) {
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
		
			BaoDuongXeBEAN baoDuongXeBEAN = new BaoDuongXeBEAN();
			baoDuongXeBEAN.setId(id);
			baoDuongXeBEAN.setNgayBaoDuong(ngayBaoDuongHienTai);
			baoDuongXeBEAN.setNgayBaoDuongTiepTheo(ngayBaoDuongTiepTheo);
			baoDuongXeBEAN.setSoTien(chiPhiBaoDuong);
			baoDuongXeBEAN.setChiTiet(chiTiet);
			if (BaoDuongXeBO.setSuaXe(baoDuongXeBEAN)) {
				response.sendRedirect(request.getContextPath() + "/bao-cao-xe-bao-duong");
			} 
			else {
				System.out.println("Fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
