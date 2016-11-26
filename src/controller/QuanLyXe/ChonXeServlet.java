package controller.QuanLyXe;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.DieuPhoiBEAN;
import model.bean.XeBEAN;
import model.bo.DieuPhoiBO;

/**
 * Servlet implementation class ChonXeServlet
 */
// @WebServlet("/ChonXeServlet")
public class ChonXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChonXeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("maChucVu").toString().equals("AD")){// kiem tra chuc vu admin 
			//get max iddieuphoi and loaixe after add dieu phoi at dieuphoi form
			int id = DieuPhoiBO.getMaxIDDieuPhoi();
			int loaiXe = DieuPhoiBO.getLoaiXe(id);
			
			//show list xe phu hop
			ArrayList<XeBEAN> listXe = DieuPhoiBO.lietKeListXeDieuPhoi(loaiXe);
			request.setAttribute("danhSachXe", listXe);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Xe/ChonXe.jsp");
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/dashboard");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession msg = request.getSession();
		
		//get id xe after click accept at chonxe page
		String param = request.getParameter("accept");
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss aa");
		Date d = new Date();
		
		//set information dieu phoi
		DieuPhoiBEAN dieuphoi = new DieuPhoiBEAN();
		dieuphoi.setIdPhanCong(DieuPhoiBO.getIDPhanCong(id));
		dieuphoi.setId(DieuPhoiBO.getMaxIDDieuPhoi());
		dieuphoi.setThoiGianBatDau(sdf.format(d));

		//check dieuphoi successful or not
		if (DieuPhoiBO.updateIDPhanCong(dieuphoi)) {
			if (DieuPhoiBO.updateTrangThai(dieuphoi)) {
				msg.setAttribute("messages", "<ul><li>Điều phối xe thành công!</li></ul>");
				response.sendRedirect(request.getContextPath() + "/danh-sach-dieu-phoi");
			} else {
				msg.setAttribute("errors", "<ul><li>Lỗi khi update trạng thái!</li></ul>");
				response.sendRedirect(request.getContextPath() + "/chon-xe");
			}
		} else {
			msg.setAttribute("errors", "<ul><li>Lỗi khi update điều phối!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/chon-xe");
		}
	}

}
