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
import model.bo.NhanVien.ShowDanhSachNhanVienBO;
import model.bo.NhanVien.ShowDanhSachTaiXeBO;
import model.bo.NhanVien.AddNhanVienBO;
import model.dao.NhanVien.AddNhanVienDAO;

/**
 * Servlet implementation class AddBaoDuongXeController
 */
@WebServlet("/danh-sach-tai-xe")
public class ShowDanhSachTaiXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDanhSachTaiXeController() {
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
		ShowDanhSachTaiXeBO danhSachTaiXeBO = new ShowDanhSachTaiXeBO();

		ArrayList<NhanVienBEAN> listTaiXe = ShowDanhSachTaiXeBO.listTaiXe();
		request.setAttribute("listTaiXe", listTaiXe);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NhanVien/danh-sach-tai-xe.jsp");
		rd.forward(request, response);
	}

}
