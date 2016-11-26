<%@page import="model.bean.NhanVienBEAN"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.bean.PhanCongNhanVienBEAN"%>
<%@page import="model.bean.CaLamViecBEAN"%>
<%@page import="model.bean.ThuNgayBEAN"%>
<%@page import="model.bean.NhanVienBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Phân công nhân viên</title>
<jsp:include page="../_top.jsp" />s
<jsp:include page="../_menu.jsp" />

<%
	ArrayList<NhanVienBEAN> listNhanVien = null;
	if(request.getAttribute("listNhanVien")!=null){
		listNhanVien = (ArrayList<NhanVienBEAN>)request.getAttribute("listNhanVien");
	}
	
	ArrayList<CaLamViecBEAN> listCaLamViec = null;
	if(request.getAttribute("listCaLamViec")!=null){
		listCaLamViec = (ArrayList<CaLamViecBEAN>)request.getAttribute("listCaLamViec");
	}
	
	ArrayList<ThuNgayBEAN> listThuNgay = null;
	if(request.getAttribute("listThuNgay")!=null){
		listThuNgay = (ArrayList<ThuNgayBEAN>)request.getAttribute("listThuNgay");
	}
%>
<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Phân công <small>Nhân viên</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->

			<jsp:include page="../_message-block.jsp" />

			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="${pageContext.request.contextPath}/them-phan-cong-nhan-vien"
					method="POST">
					<div class="form-group">
						<label>Nhân viên: </label> <select class="form-control"
							name="idNhanVien" required>
							<option value="">Vui lòng chọn nhân viên</option>
							<%
								if(listNhanVien!=null){
									for(NhanVienBEAN nhanVien : listNhanVien){
										%>
							<option value="<%=nhanVien.getId()%>"><%=nhanVien.getHoTen()%></option>
							<%	}
								}else{
									%>
							<option value="">Null!</option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<label>Ca làm việc: </label> <select class="form-control"
							name="idCaLamViec" required>
							<option value="">Vui lòng chọn ca làm việc</option>
							<% 
								if(listCaLamViec!=null){
									for(CaLamViecBEAN caLamViec : listCaLamViec){
										%>
							<option value="<%=caLamViec.getId()%>"><%=caLamViec.getTenCa() %></option>
							<%
										
									}
								}else{
									%>
							<option value="">Null!</option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<label>Thứ ngày: </label> <select class="form-control"
							name="idThuNgay" required>
							<option value="">Vui lòng chọn thứ ngày</option>
							<% 
								if(listThuNgay!=null){
									for(ThuNgayBEAN thuNgay : listThuNgay){
										%>
							<option value="<%=thuNgay.getId()%>"><%=thuNgay.getTenThuNgay() %></option>
							<%
									
									}
								}else{
									%>
							<option value="">Null!</option>
							<%
								}
							%>
						</select>
					</div>
					<button type="submit" class="btn btn-default">Thêm</button>
					<button type="reset" class="btn btn-default">Reset</button>
				</form>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="../_footer-start.jsp" />


<jsp:include page="../_footer-end.jsp" />