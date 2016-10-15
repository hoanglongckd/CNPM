package controller.NhanVien;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien.NhanVienBEAN;
import model.bo.NhanVien.DanhSachNhanVienBO;
import model.bo.NhanVien.DanhSachTaiXeBO;
import model.bo.NhanVien.ThemNhanVienBO;
import model.dao.NhanVien.ThemNhanVienDAO;

/**
 * Servlet implementation class AddBaoDuongXeController
 */
@WebServlet("/danh-sach-tai-xe")
public class DanhSachTaiXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachTaiXeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DanhSachTaiXeBO danhSachTaiXeBO = new DanhSachTaiXeBO();

		ArrayList<NhanVienBEAN> listTaiXe = DanhSachTaiXeBO.listTaiXe();
		request.setAttribute("listTaiXe", listTaiXe);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NhanVien/danh-sach-tai-xe.jsp");
		rd.forward(request, response);
	}

}
