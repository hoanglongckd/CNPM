<%@page import="model.bean.NhanVienBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Chỉnh sửa thông tin nhân viên</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<% NhanVienBEAN nhanVien=(NhanVienBEAN)request.getAttribute("nhanVien"); %>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Chỉnh sửa <small>Thông tin nhân viên</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="${pageContext.request.contextPath}/them-nhan-vien"
					method="POST">
					<div class="form-group">
						<label>Mã nhân viên: </label> <input class="form-control"
							type="text" name="ma-nhan-vien" value=<%=nhanVien.getMaNhanVien()%> />
					</div>
					<div class="form-group">
						<label>Họ và tên: </label> <input class="form-control" type="text"
							name="ho-va-ten" value=<%=nhanVien.getHoTen()%>/>
					</div>
					<div class="form-group">
						<label>Ngày sinh: </label> <input class="form-control" type="text"
							name="ngay-sinh"/> 
					</div>
					<div class="form-group">
						<select class="form-control" name="chuc-vu">
						<% if(nhanVien.getChucVu()==1){%>
							<option value="1">Nhân viên</option>
							<%}else{ %><option value="2">Tài xế</option>
							<%}%>
						</select>
					</div>
					<div class="form-group">
						<select class="form-control" name="ca-lam-viec">
							<option value="1">Ca 1</option>
							<option value="2">Ca 2</option>
							<option value="3">Ca 3</option>
						</select>
					</div>
					<button type="submit" class="btn btn-default">Save</button>
					<button type="submit" class="btn btn-default">Cancel</button>
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
		$('input[name="ngay-sinh"]').daterangepicker({
			singleDatePicker : true,
			showDropdowns : true
		});
	});
</script>


<jsp:include page="../_footer-end.jsp" />