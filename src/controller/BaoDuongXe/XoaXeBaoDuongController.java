package controller.BaoDuongXe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.BaoDuongXeBO;

/**
 * Servlet implementation class XoaXeBaoDuongController
 */
//@WebServlet("/XoaXeBaoDuongController")
public class XoaXeBaoDuongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaXeBaoDuongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession msg = request.getSession();
		String param = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean valid = BaoDuongXeBO.xoaXeBaoDuong(id);
		if (valid) {
			msg.setAttribute("messages", "<ul><li>Xóa xe bảo dưỡng thành công!</li></ul>");
		} else {
			msg.setAttribute("errors", "<ul><li>Có lỗi xảy ra! Vui lòng liên hệ với nhà cung cấp dịch vụ!</li></ul>");
		}
		response.sendRedirect(request.getContextPath() + "/bao-cao-xe-bao-duong");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
