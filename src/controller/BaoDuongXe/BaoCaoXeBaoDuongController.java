package controller.BaoDuongXe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaoDuongXeBEAN;
import model.bo.BaoDuongXeBO;

/**
 * Servlet implementation class BaoCaoXeBaoDuongController
 */
//@WebServlet("/BaoCaoXeBaoDuongController")
public class BaoCaoXeBaoDuongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaoCaoXeBaoDuongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BaoDuongXeBEAN> baoDuongXeBEANs = BaoDuongXeBO.lietKeDanhSachBaoDuong();
		request.setAttribute("danhSachBaoDuongXe", baoDuongXeBEANs);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/BaoDuongXe/bao-cao-xe-bao-duong.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
