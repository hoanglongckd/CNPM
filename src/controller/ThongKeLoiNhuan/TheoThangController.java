package controller.ThongKeLoiNhuan;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ThongKeLoiNhuanBEAN;
import model.bo.ThongKeLoiNhuanBO;

/**
 * Servlet implementation class ThongKeLoiNhuanTheoThang
 */
//@WebServlet("/TheoThangController")
public class TheoThangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheoThangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		///kiem tra chuc vu admin 
		if(session.getAttribute("maChucVu").toString().equals("AD")){// kiem tra chuc vu admin 
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ThongKeLoiNhuan/thong-ke-theo-thang.jsp");
			dispatcher.forward(request, response);
		//neu khong phai admin	
		}else{
			response.sendRedirect(request.getContextPath()+"/dashboard");
		}
		//----end---
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();
		String filter = request.getParameter("filter");
		System.out.println(filter);
		if (filter == null) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ThongKeLoiNhuan/thong-ke-theo-thang.jsp");
			dispatcher.forward(request, response);
		}
		else {
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM/yyyy");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy");
			SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MM");
			String year = "";
			String month = "";
			try {
				Date date = simpleDateFormat1.parse(filter);
				year = simpleDateFormat2.format(date);
				month = simpleDateFormat3.format(date);
//				System.out.println("date: " + date + ", year: " + year + ", month: " + month);
				long profit = ThongKeLoiNhuanBO.getTotalProfitByMonth(year, month);
				long fee = ThongKeLoiNhuanBO.getTotalFeeByMonth(year, month);
				ArrayList<ThongKeLoiNhuanBEAN> thongKeLoiNhuanBEANs = ThongKeLoiNhuanBO.thongKeTheoThang(year, month);
				request.setAttribute("list", thongKeLoiNhuanBEANs);
				request.setAttribute("month", month);
				request.setAttribute("year", year);
				request.setAttribute("cost", profit - fee);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ThongKeLoiNhuan/thong-ke-theo-thang.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				msg.setAttribute("errors", "Sai định dạng ngày tháng. Vui lòng nhập theo định dạng <b>MM/YYYY</b>");
				response.sendRedirect(request.getContextPath() + "/thong-ke-theo-thang");
			}
			
		}
	}

}
