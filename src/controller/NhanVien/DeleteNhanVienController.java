package controller.NhanVien;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NhanVienBO;

public class DeleteNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteNhanVienController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession msg = request.getSession();
		
		NhanVienBO nhanVienBO = new NhanVienBO();
		
		String idNhanVien= request.getParameter("idNhanVien");
		
		if(nhanVienBO.isNhanVienDeleted(idNhanVien)){
			msg.setAttribute("messages", "<ul><li>Xóa nhân viên thành công!</li></ul>");
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		}
		else{
			msg.setAttribute("errors", "<ul><li>Xóa nhân viên không thành công!</li></ul>");	
			response.sendRedirect(request.getContextPath() + "/danh-sach-nhan-vien");
		}
		
	}

}
