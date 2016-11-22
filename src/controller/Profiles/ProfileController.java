package controller.Profiles;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ChucVuBEAN;
import model.bean.NhanVienBEAN;
import model.bo.ChucVuBO;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class Login
 */
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    NhanVienBO nhanVienBO = new NhanVienBO();
    ChucVuBO chucVuBO = new ChucVuBO();  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
			String maNV = null;
			String msg =  "";
			if(request.getParameter("msg")!=null){
				msg = (request.getParameter("msg"));
			}
			maNV = (String) session.getAttribute("maNV");
			
			NhanVienBEAN nhanVien = nhanVienBO.getNhanVienByMaNV(maNV);
			//doi kieu ngay thang nam
			String[] chuoi = nhanVien.getNgaySinh().split("-");
			nhanVien.setNgaySinh(chuoi[1]+"/"+chuoi[2]+"/"+chuoi[0]);
			//
			ArrayList<ChucVuBEAN> listChucVu = chucVuBO.listChucVu();
			String chucVu = null;
			for(ChucVuBEAN cv : listChucVu){
				if (nhanVien.getId()==cv.getId()){
					chucVu = cv.getTenChucVu();
					break;
				}
			}
			if(msg!="") request.setAttribute("msg", msg);
			request.setAttribute("nhanVien", nhanVien);
			request.setAttribute("chucVu", chucVu);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/QuanLyTaiKhoan/profile.jsp");
			dispatcher.forward(request, response);
		//----end---
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("maChucVu").toString().equals("AD")){
			if(session.getAttribute("maNV")!=null){
				if(request.getParameter("change-password")!=null){
					response.sendRedirect(request.getContextPath()+"/doi-mat-khau");
				}
				String maNV = (String) session.getAttribute("maNV");
				System.out.println("cmnr");
				//click change-password button
				if(request.getParameter("change-password")!=null){
					System.out.println("change-password");
					//response.sendRedirect(request.getContextPath()+"/change-password");
				}else{
					//click edit-button
					if(request.getParameter("edit")!=null){
						System.out.println("edit");
						//get
						String ten = (String) request.getParameter("ten"); 
						String ngaySinh = (request.getParameter("ngaySinh"));
						NhanVienBEAN nhanVien = new NhanVienBEAN(0, maNV, ten, ngaySinh, 0,"");
						
						if(nhanVienBO.setSuaNhanVien(nhanVien)){
							response.sendRedirect(request.getContextPath()+"/profile?msg=1");
						}else{
							response.sendRedirect(request.getContextPath()+"/profile?msg=2");
						}
					}
				}
			}else{
				response.sendRedirect(request.getContextPath()+"/login");
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/dashboard");
		}
	}

}
