package controller.TaiXe;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.TaiXeBEAN;
import model.bo.TaiXeBO;

/**
 * Servlet implementation class AddBaoDuongXeController
 */
public class AddTaiXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaiXeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/TaiXe/them-tai-xe.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();
		String maTX = request.getParameter("ma-tai-xe");
		String hoTen = request.getParameter("ho-va-ten");
		String ngaySinh = request.getParameter("ngay-sinh");
		
		TaiXeBEAN taiXeBEAN = new TaiXeBEAN();
		
		taiXeBEAN.setMaTaiXe(maTX);
		taiXeBEAN.setHoTen(hoTen);
		taiXeBEAN.setNgaySinh(ngaySinh);
		
		if (TaiXeBO.addTaiXe(taiXeBEAN)) {
			msg.setAttribute("messages", "<ul><li>Thêm tài xế thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-tai-xe");		
		}
		else {
			msg.setAttribute("errors", "<ul><li>Thêm tài xế không thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-tai-xe");		
		}
	}

}
