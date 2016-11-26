package controller.ThongKeLoiNhuan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
		HttpSession session = request.getSession();
		///kiem tra chuc vu admin 
		if(session.getAttribute("maChucVu").toString().equals("AD")){// kiem tra chuc vu admin 
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ThongKeLoiNhuan/thong-ke-theo-nam.jsp");
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
		String year = request.getParameter("year");
		long profit = ThongKeLoiNhuanBO.getTotalProfitByYear(year);
		long fee = ThongKeLoiNhuanBO.getTotalFeeByYear(year);
		ArrayList<ThongKeLoiNhuanBEAN> list = ThongKeLoiNhuanBO.thongKeTheoNam(year);
		request.setAttribute("year", year);
		request.setAttribute("list", list);
		request.setAttribute("cost", profit - fee);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ThongKeLoiNhuan/thong-ke-theo-nam.jsp");
		dispatcher.forward(request, response);
	}

}
