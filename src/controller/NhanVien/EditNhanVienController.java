package controller.NhanVien;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaoDuongXeBEAN;
import model.bean.NhanVienBEAN;
import model.bo.BaoDuongXeBO;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class SuaXeBaoDuongController
 */
//@WebServlet("/SuaXeBaoDuongController")
public class EditNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNhanVienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNhanVien = request.getParameter("idNhanVien");

		NhanVienBEAN nhanVienBEAN = NhanVienBO.getNhanVien(idNhanVien);
		System.out.println(nhanVienBEAN.getNgaySinh()+"|"+nhanVienBEAN.getHoTen()+"|"+nhanVienBEAN.getMaNhanVien());
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = simpleDateFormat1.parse(nhanVienBEAN.getNgaySinh());
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
			nhanVienBEAN.setNgaySinh(simpleDateFormat2.format(date1));
			System.out.println(nhanVienBEAN.getNgaySinh()+"|");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("nhanVien", nhanVienBEAN);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/NhanVien/chinh-sua-nhan-vien.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();
		String param = request.getParameter("id");
		System.out.println(param);
		int id = 0;
		try {
			id = Integer.parseInt(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String hoTen = request.getParameter("ho-va-ten");
		String ngaySinh = request.getParameter("ngay-sinh");
		
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date date1 = simpleDateFormat1.parse(ngaySinh);
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			ngaySinh = simpleDateFormat2.format(date1);
			Date date11 = simpleDateFormat2.parse(ngaySinh);
			
			NhanVienBEAN nhanVienBEAN = new NhanVienBEAN();
			nhanVienBEAN.setId(id);
			nhanVienBEAN.setNgaySinh(ngaySinh);
			nhanVienBEAN.setHoTen(hoTen);
			if (NhanVienBO.setSuaNhanVien(nhanVienBEAN)) {
				msg.setAttribute("messages", "<ul><li>Chỉnh sửa nhân viên thành công!</li></ul>");
				response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
			} 
			else {
				msg.setAttribute("errors", "<ul><li>Chỉnh sửa nhân viên không thành công!</li></ul>");
				response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
