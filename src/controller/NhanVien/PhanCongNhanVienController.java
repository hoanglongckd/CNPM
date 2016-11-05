package controller.NhanVien;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVienBEAN;
import model.bean.PhanCongNhanVienBEAN;
import model.bo.NhanVienBO;
import model.bo.PhanCongNhanVienBO;
import model.bean.CaLamViecBEAN;
import model.bo.CaLamViecBO;
import model.bean.ThuNgayBEAN;
import model.bo.ThuNgayBO;

/**
 * Servlet implementation class PhanCongNhanVienController
 */
@WebServlet("/PhanCongNhanVienController")
public class PhanCongNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhanCongNhanVienController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<NhanVienBEAN> listNhanVien = NhanVienBO.getDanhSachNhanVien();
		request.setAttribute("listNhanVien", listNhanVien);
		ArrayList<CaLamViecBEAN> listCaLamViec = CaLamViecBO.getDanhSachCaLamViec();
		request.setAttribute("listCaLamViec", listCaLamViec);
		ArrayList<ThuNgayBEAN> listThuNgay = ThuNgayBO.getDanhSachThuNgay();
		request.setAttribute("listThuNgay", listThuNgay);

		System.out.println("dâfafa" + listNhanVien.isEmpty());
		
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/NhanVien/them-phan-cong-nhan-vien.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession msg = request.getSession();

		int idNhanVien = Integer.parseInt(request.getParameter("idNhanVien"));
		int idCa = Integer.parseInt(request.getParameter("idCaLamViec"));
		int idThuNgay = Integer.parseInt(request.getParameter("idThuNgay"));
		System.out.println(idNhanVien+"|"+idCa+"|"+ idThuNgay);
		
		PhanCongNhanVienBEAN phanCongNhanVienBEAN = new PhanCongNhanVienBEAN();
		phanCongNhanVienBEAN.setIdCa(idCa);
		phanCongNhanVienBEAN.setIdNhanVien(idNhanVien);
		phanCongNhanVienBEAN.setIdThuNgay(idThuNgay);
		if (PhanCongNhanVienBO.themPhanCongNhanVien(phanCongNhanVienBEAN)) {
			msg.setAttribute("messages", "<ul><li>Thêm phân công nhân viên thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		} else {
			msg.setAttribute("errors", "<ul><li>Thêm phân công nhân viên không thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		}

	}

}
