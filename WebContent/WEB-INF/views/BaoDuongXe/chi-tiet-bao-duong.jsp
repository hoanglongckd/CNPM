<%@page import="model.bean.BaoDuongXeBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Chi tiết xe bảo dưỡng</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<%
	BaoDuongXeBEAN chiTietBaoDuong = new BaoDuongXeBEAN();
	if(request.getAttribute("chiTietBaoDuong")!=null){
		chiTietBaoDuong = (BaoDuongXeBEAN)request.getAttribute("chiTietBaoDuong");
	}
%>
<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Chi tiết
					<small>Xe Bảo Dưỡng</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom:120px">
				<form action="${pageContext.request.contextPath}/them-xe-bao-duong" method="POST">
					<div class="form-group">
						<label>Biển số xe</label>
						<input class="form-control" type="text" name="current-date" 
						value="<%=chiTietBaoDuong.getBienSoXe()%>"/>
					</div>
					<div class="form-group">
						<label>Model</label>
						<input class="form-control" type="text" name="current-date"
						value="<%=chiTietBaoDuong.getModel()%>"/>
					</div>
					<div class="form-group">
						<label>Số chỗ</label>
						<input class="form-control" type="text" name="next-date" 
						value="<%=chiTietBaoDuong.getSoCho()%>"/>
					</div>
					<div class="form-group">
						<label>Tổng chi phí</label>
						<input type="number" class="form-control" name="cost"
						value="<%=chiTietBaoDuong.getSoCho()%>" />
					</div>
					<div class="form-group">
						<label>Chi tiết</label>
						<textarea class="form-control" rows="4" name="detail"
						><%=chiTietBaoDuong.getChiTiet()%></textarea>
					</div>
					<a href="<%=request.getContextPath()%>/sua-xe-bao-duong?id=<%=chiTietBaoDuong.getId()%>" class="btn btn-default">Sửa</a>
					<a href="<%=request.getContextPath()%>/bao-cao-xe-bao-duong" class="btn btn-default">Back</a>
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