package controller.Profiles;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date date1 = sdf1.parse(nhanVien.getNgaySinh());
				nhanVien.setNgaySinh(sdf2.format(date1)) ;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//
			ArrayList<ChucVuBEAN> listChucVu = chucVuBO.listChucVu();
			String chucVu = null;
			for(ChucVuBEAN cv : listChucVu){
				if (nhanVien.getIdChucVu()==cv.getId()){
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
			if(session.getAttribute("maNV")!=null){
				if(request.getParameter("change-password")!=null){
					response.sendRedirect(request.getContextPath()+"/doi-mat-khau");
				}else{
					String maNV = (String) session.getAttribute("maNV");
				
					//click edit-button
					if(request.getParameter("edit")!=null){
						System.out.println("edit");
						//get
						String ten = (String) request.getParameter("ten"); 
						String ngaySinh = (request.getParameter("ngaySinh"));
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
						SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
						try {
							Date date1 = sdf2.parse(ngaySinh);
							ngaySinh = sdf1.format(date1);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						NhanVienBEAN nhanVien = new NhanVienBEAN(0, maNV, ten,ngaySinh, 0,"");
						System.out.println("chuan bi sua:"+ten+"/"+ngaySinh+"/"+maNV);
						if(nhanVienBO.setSuaNhanVien(nhanVien)){
							session.setAttribute("messages", "<ul><li> Cập nhập thành công!</li></ul>");
							response.sendRedirect(request.getContextPath()+"/profile");
						}else{
							session.setAttribute("errors", "<ul><li>Có lỗi xảy ra! Vui lòng liên hệ với nhà cung cấp dịch vụ!</li></ul>");
							response.sendRedirect(request.getContextPath()+"/profile");
						}
					}
				}
			}else{
				response.sendRedirect(request.getContextPath()+"/login");
			}
	}

}
