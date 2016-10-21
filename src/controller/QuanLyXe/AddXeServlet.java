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
 * Servlet implementation class AddXeServlet
 */
@WebServlet("/AddXeServlet")
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
		doPost(request, response);
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
				
		boolean check = xeBO.themXe(xe);
		
		xe.setId(xeBO.getMaxXeId());
		boolean check2 = xeBO.themPhanCongTX(taixe,xe);
		
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
