package controller.BaoDuongXe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaoDuongXeBEAN;
import model.bo.BaoDuongXeBO;

public class ChiTietBaoDuongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChiTietBaoDuongController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		///kiem tra chuc vu admin 
		if(session.getAttribute("maChucVu").toString().equals("AD")){// kiem tra chuc vu admin 
			String param = request.getParameter("id");
			int id = 0;
			try {
				id = Integer.parseInt(param);
			} catch (Exception e) {
				e.printStackTrace();
			}
			BaoDuongXeBEAN baoDuongXeBEAN = BaoDuongXeBO.chiTietXeBaoDuong(id);
			request.setAttribute("chiTietBaoDuong", baoDuongXeBEAN);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/BaoDuongXe/chi-tiet-bao-duong.jsp");
			dispatcher.forward(request, response);
		//neu khong phai admin	
		}else{
			response.sendRedirect(request.getContextPath()+"/dashboard");
		}
		//----end---
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
