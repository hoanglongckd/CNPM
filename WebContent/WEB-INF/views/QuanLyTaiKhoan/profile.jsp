<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.*" %>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Profile</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<% 
NhanVienBEAN nv = null;
nv = (NhanVienBEAN)request.getAttribute("nhanVien");
String chucvu=(String)  request.getAttribute("chucVu");
String msg = null;
if(request.getAttribute("msg")!=null)
	msg =(String)request.getAttribute("msg");

%>

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Profile	
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom:120px">
				<form action="<%=request.getContextPath()%>/profile" method="POST">
					<%
						if("1".equals(msg)){
					%>
						<div class="form-group">
							<label style="color:green">Sửa thành công</label>
						</div>
					<%}else if("2".equals(msg)){ %>
						<div class="form-group">
							<label style="color:red">Sửa thất bại</label>
						</div>
					<%} %>
					<div class="form-group">
						<label>Mã Nhân Viên</label>
						<input class="form-control" name="maNV" id="maNV" placeholder="" value="<%=nv.getMaNhanVien() %>" readonly="readonly"/>
					</div>
				<div class="form-group">
					<label>Tên</label>
					<input class="form-control" name="ten" id="ten" placeholder="Nhập mới tên của bạn" value="<%=nv.getHoTen()%>"/>
				</div>
				<div class="form-group">
					<label>Ngày sinh</label>
					<input class="form-control" type="text" name="ngaySinh" value="<%=nv.getNgaySinh()%>"/>
				</div>
				<div class="form-group">
						<label>Chức vụ</label>
						<input class="form-control" name="chucvu" id="chucvu" placeholder="" value="<%=chucvu%>" readonly="readonly"/>
					</div>
				<div class="form-group">
					<label>Password</label>
					<input type="password" class="form-control" name="password" id="password" placeholder="" value="<%=nv.getPassword() %>"readonly="readonly" />
				</div>
				<button type="submit" class="btn btn-default" value="edit" name="edit">OK</button>
				<button type="submit" class="btn btn-default" value="change-password" name="change-password">Change Password</button>
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

<script type="text/javascript">
	$(function() {
	    $('input[name="ngaySinh"]').daterangepicker({
	    	
	    	singleDatePicker: true,
	        showDropdowns: true
	    });
	});
</script>


<jsp:include page="../_footer-end.jsp" />