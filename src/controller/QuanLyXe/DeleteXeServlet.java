package controller.QuanLyXe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.XeBO;

/**
 * Servlet implementation class XoaXe
 */
//@WebServlet("/xoa-xe")
public class DeleteXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteXeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession msg = request.getSession();
		
		String param = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(XeBO.xoaXe(id)){
			msg.setAttribute("messages", "<ul><li>Xóa xe thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/list-xe");
		} else {
			msg.setAttribute("messages", "<ul><li>Lỗi cơ sở dữ liệu!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/list-xe");
		}
	
	}

}
