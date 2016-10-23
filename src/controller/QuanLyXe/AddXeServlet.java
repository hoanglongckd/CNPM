package controller.QuanLyXe;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TaiXe;
import model.bean.XeBEAN;
import model.bo.TaiXeBO;
import model.bo.XeBO;

/**
 * Servlet implementation class AddXeServlet
 */
//@WebServlet("/AddXeServlet")
public class AddXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddXeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {

			// get List Name Of Class present
			TaiXeBO taiXebo = new TaiXeBO();
			List<TaiXe> listMaTX = null;
			listMaTX = taiXebo.getAllTenTX();
			request.setAttribute("listMaTX", listMaTX);
//			System.out.println(listMaTX.get(0));
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/Xe/QuanLyXe.jsp");
			dispatcher.forward(request, response);

//		} catch (Exception e) {
//			response.sendRedirect(request.getContextPath() + "/listXe");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		XeBEAN xe = new XeBEAN();
		TaiXe taixe = new TaiXe();
		taixe.setId(Integer.parseInt(request.getParameter("tentx")));
		xe.setBienSoXe(request.getParameter("biensoxe"));
		xe.setModel(request.getParameter("model"));
		xe.setSoCho(Integer.parseInt(request.getParameter("sochongoi")));
		xe.setHang(request.getParameter("hang"));
		xe.setGhiChu(request.getParameter("ghichu"));
		xe.setTinhTrangHoatDong(false);
				
		boolean check = XeBO.themXe(xe);
		
		xe.setId(XeBO.getMaxXeId());
		boolean check2 = XeBO.themPhanCongTX(taixe,xe);
		
		if (check) {
			if (check2)	
				response.sendRedirect(request.getContextPath() + "/list-xe");
		} else {
			System.out.println("Fail");
		}
		    
//		}catch(Exception e){
//			response.sendRedirect(request.getContextPath() + "/listXe");
//		}
	}

}
