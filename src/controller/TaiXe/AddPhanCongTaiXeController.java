	package controller.TaiXe;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVienBEAN;
import model.bean.PhanCongTaiXeBEAN;
import model.bo.TaiXeBO;

/**
 * Servlet implementation class AddBaoDuongXeController
 */
//@WebServlet("/them-nhan-vien")
public class AddPhanCongTaiXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPhanCongTaiXeController() { 	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/TaiXe/them-phan-cong-tai-xe.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();
		
		int idTaiXe = Integer.parseInt(request.getParameter("idTaiXe"));
		int idXe = Integer.parseInt(request.getParameter("idXe"));
		int idCa = Integer.parseInt(request.getParameter("idCaLamViec"));
		int idThuNgay = Integer.parseInt(request.getParameter("idThuNgay"));
		PhanCongTaiXeBEAN phanCongTaiXeBEAN = new PhanCongTaiXeBEAN();
		
		phanCongTaiXeBEAN.setIdTaiXe(idTaiXe);
		phanCongTaiXeBEAN.setIdCa(idCa);
		phanCongTaiXeBEAN.setIdThuNgay(idThuNgay);
		phanCongTaiXeBEAN.setIdXe(idXe);
		
		if (TaiXeBO.addPhanCongTaiXe(phanCongTaiXeBEAN)) {
			msg.setAttribute("messages", "<ul><li>Thêm phân công tài xế thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-tai-xe");		
			}
		else {
			msg.setAttribute("errors", "<ul><li>Thêm phân công tài xế không thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-tai-xe");
		}
		
	}

}
