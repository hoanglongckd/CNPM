package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String maTX = (String) request.getParameter("matx");
		String bienSoXe = (String) request.getParameter("biensoxe");
		String model = (String)request.getParameter("model");
		int soChoNgoi = Integer.parseInt(request.getParameter("sochongoi"));
		String hang = (String)request.getParameter("hang");
		String ghiChu = (String) request.getParameter("ghichu");
		String tinhTrang = "False";
		//-----------------------------------------------------------
//		System.out.println(bienSoXe);
//		try{
			// add into Xe Table
		    xeBO xebo = new xeBO();
//		    xebo.addXe(bienSoXe,model,soChoNgoi,hang,tinhTrang,ghiChu);
		    //------------------------------------
		   		   
		    response.sendRedirect(request.getContextPath() + "/listXe");
		    
//		}catch(Exception e){
//			response.sendRedirect(request.getContextPath() + "/listXe");
//		}
	}

}
