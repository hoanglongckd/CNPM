	package controller.NhanVien;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVienBEAN;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class AddBaoDuongXeController
 */
//@WebServlet("/them-nhan-vien")
public class AddNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNhanVienController() { 	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/NhanVien/them-nhan-vien.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();
		String maNV = request.getParameter("ma-nhan-vien");
		String hoTen = request.getParameter("ho-va-ten");
		int idChucVu = 1; //nhan vien la 1, admin la 1
		String ngaySinh = request.getParameter("ngay-sinh");
		String password = "123456"; //Mat khau mac dinh la 123456
		
		NhanVienBEAN nhanVienBEAN = new NhanVienBEAN();
		
		nhanVienBEAN.setMaNhanVien(maNV);
		nhanVienBEAN.setHoTen(hoTen);
		nhanVienBEAN.setNgaySinh(ngaySinh);
		nhanVienBEAN.setPassword(password);
		nhanVienBEAN.setIdChucVu(idChucVu);
		
		if (NhanVienBO.addNhanVien(nhanVienBEAN)) {
			msg.setAttribute("messages", "<ul><li>Thêm nhân viên thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");		
			}
		else {
			msg.setAttribute("errors", "<ul><li>Thêm nhân viên không thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		}
		
	}

}
