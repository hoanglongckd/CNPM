<%@page import="model.bean.NhanVienBEAN"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.bean.PhanCongTaiXeBEAN"%>
<%@page import="model.bean.XeBEAN"%>
<%@page import="model.bean.CaLamViecBEAN"%>
<%@page import="model.bean.ThuNgayBEAN"%>
<%@page import="model.bean.TaiXeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Phân công tài xế</title>
<jsp:include page="../_top.jsp" />s
<jsp:include page="../_menu.jsp" />

<%
	ArrayList<TaiXeBEAN> listTaiXe = null;
	if(request.getAttribute("listTaiXe")!=null){
		listTaiXe = (ArrayList<TaiXeBEAN>)request.getAttribute("listTaiXe");
	}
	
	ArrayList<XeBEAN> listXe = null;
	if(request.getAttribute("listXe")!=null){
		listXe = (ArrayList<XeBEAN>)request.getAttribute("listXe");
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
					Phân công <small>Tài xế</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->

			<jsp:include page="../_message-block.jsp" />

			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="${pageContext.request.contextPath}/phan-cong-tai-xe"
					method="POST">
					<div class="form-group">
						<label>Tài xế: </label> <select class="form-control"
							name="idTaiXe" required>
							<option value="">Vui lòng chọn tài xế</option>
							<%
								if(listTaiXe!=null){
									for(TaiXeBEAN taiXe : listTaiXe){
										%>
							<option value="<%=taiXe.getId()%>"><%=taiXe.getHoTen()%></option>
							<%	}
								}else{
									%>
							<option value="">ERRORS!</option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<label>Xe: </label> <select class="form-control"
							name="idXe" required>
							<option value="">Vui lòng chọn xe</option>
							<%
								if(listXe!=null){
									for(XeBEAN xe : listXe){
										%>
							<option value="<%=xe.getId()%>"><%=xe.getBienSoXe()%></option>
							<%	}
								}else{
									%>
							<option value="">ERRORS!</option>
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
							<option value="">ERRORS!</option>
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
							<option value="">ERRORS!</option>
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