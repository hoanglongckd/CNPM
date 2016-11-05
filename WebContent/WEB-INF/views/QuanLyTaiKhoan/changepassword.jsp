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
String msg = null;
if(request.getAttribute("msg")!=null)
	msg =(String)request.getAttribute("msg");

%>

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Change Password	
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<jsp:include page="../_message-block.jsp" />
			<div class="col-lg-7" style="padding-bottom:120px">
				<form action="<%=request.getContextPath()%>/doi-mat-khau" method="POST">
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
					<label> Tên nhân viên:</label>
					<input type="text" class="form-control" name="ten" id="ten" value="<%=nv.getHoTen()%>" readonly="read-only"/>
				</div>	
				<div class="form-group">
					<label>Password cũ</label>
					<input type="password" class="form-control" name="password" id="password" placeholder="Nhập mới tên của bạn" value="<%=nv.getPassword()%>" readonly="read-only"/>
				</div>
				<div class="form-group">
					<label>Password mới</label>
					<input class="form-control" type="password" name="new-password" value=""/>
				</div>
<!-- 				<div class="form-group"> -->
<!-- 						<label> Nhập lại password mới -->
<!-- 						</label> -->
<!-- 						<input type="password" class="form-control" name="renew-password" value="" /> -->
<!-- 					</div> -->
				<div hidden>
					<input type="text" class="form-control" name="maNhanVien"  value="<%=nv.getMaNhanVien()%>" />
				</div>
				<button type="submit" class="btn btn-default" value="change-password" name="submit">Change Password</button>
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