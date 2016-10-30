package controller.ThongKeLoiNhuan;

import java.io.IOException;
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

import model.bean.ThongKeLoiNhuanBEAN;
import model.bo.ThongKeLoiNhuanBO;

/**
 * Servlet implementation class TheoNamController
 */
//@WebServlet("/TheoNamController")
public class TheoNamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheoNamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ThongKeLoiNhuan/thong-ke-theo-nam.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession msg = request.getSession();
		String year = request.getParameter("year");
		ArrayList<ThongKeLoiNhuanBEAN> list = ThongKeLoiNhuanBO.thongKeTheoNam(year);
		request.setAttribute("year", year);
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ThongKeLoiNhuan/thong-ke-theo-nam.jsp");
		dispatcher.forward(request, response);
//		String filter = request.getParameter("year");
//		System.out.println(filter);
//		if (filter == null) {
//			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ThongKeLoiNhuan/thong-ke-theo-nam.jsp");
//			dispatcher.forward(request, response);
//		}
//		else {
//			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM/yyyy");
//			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy");
//			SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MM");
//			String year = "";
//			String month = "";
//			try {
//				Date date = simpleDateFormat1.parse(filter);
//				year = simpleDateFormat2.format(date);
//				month = simpleDateFormat3.format(date);
//				System.out.println("date: " + date + ", year: " + year + ", month: " + month);
//				ArrayList<ThongKeLoiNhuanBEAN> thongKeLoiNhuanBEANs = ThongKeLoiNhuanBO.thongKeTheoThang(year, month);
//				request.setAttribute("list", thongKeLoiNhuanBEANs);
//				request.setAttribute("month", month);
//				request.setAttribute("year", year);
//				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ThongKeLoiNhuan/thong-ke-theo-nam.jsp");
//				dispatcher.forward(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//				msg.setAttribute("errors", "Sai định dạng ngày tháng. Vui lòng nhập theo định dạng <b>MM/YYYY</b>");
//				response.sendRedirect(request.getContextPath() + "/thong-ke-theo-thang");
//			}
//			
//		}
	}

}
