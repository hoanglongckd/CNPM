package controller.QuanLyXe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TaiXe;
import model.bean.XeBEAN;
import model.bo.xeBO;

/**
 * Servlet implementation class UpdateXeServlet
 */
@WebServlet("/UpdateXeServlet")
public class UpdateXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateXeServlet() {
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
		request.setCharacterEncoding("UTF-8");

		String param = request.getParameter("id");
		System.out.println(param);
		int id = 0;
		try {
			id = Integer.parseInt(param);
	//		System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		XeBEAN xe = new XeBEAN();
		TaiXe taixe = new TaiXe();
		taixe.setId(Integer.parseInt(request.getParameter("tentx")));
		
		xe.setId(id);
		xe.setTaiXe(request.getParameter("tentx"));
		xe.setModel(request.getParameter("model"));
		xe.setSoCho(Integer.parseInt(request.getParameter("sochongoi")));
		xe.setHang(request.getParameter("hang"));
		xe.setGhiChu(request.getParameter("ghichu"));
	
		if (xeBO.setCapNhatXe(xe)) {
			if (xeBO.setCapNhatPhanCongTX(taixe, xe))
			response.sendRedirect(request.getContextPath() + "/list-xe");
		} else {
			System.out.println("Fail");
		}
	}

}
