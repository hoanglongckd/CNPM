package controller.QuanLyVangNghi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.QuanLyVangNghiBO;

/**
 * Servlet implementation class XoaVangNghiController
 */
//@WebServlet("/XoaVangNghiController")
public class XoaVangNghiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaVangNghiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession msg = request.getSession();
		String idParam = request.getParameter("id");
		String idNVParam = request.getParameter("idNV");
		int id = 0;
		int idNV = 0;
		try {
			id = Integer.parseInt(idParam);
			idNV = Integer.parseInt(idNVParam);
		} catch (Exception e) {
			msg.setAttribute("errors", "<ul><li>Vui lòng không sửa đường dẫn!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/chi-tiet-vang-nghi?id=" + idNV);
			e.printStackTrace();
		}
		if (QuanLyVangNghiBO.xoaVangNghi(id)) {
			msg.setAttribute("messages", "<ul><li>Xóa thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/chi-tiet-vang-nghi?id=" + idNV);
		} else {
			msg.setAttribute("errors", "<ul><li>Có lỗi xảy ra. Vui lòng liên hệ với nhà cung cấp dịch vụ!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/chi-tiet-vang-nghi?id=" + idNV);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
