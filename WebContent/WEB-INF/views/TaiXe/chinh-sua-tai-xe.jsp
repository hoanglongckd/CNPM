<%@page import="model.bean.TaiXeBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Chỉnh sửa thông tin tài xế</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<%
	TaiXeBEAN taiXe = new TaiXeBEAN();
	if(request.getAttribute("taiXe")!=null){ 
		taiXe=(TaiXeBEAN)request.getAttribute("taiXe");
	}
%>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Chỉnh sửa <small>Thông tin tài xế</small>
				</h1>
			</div>
			<jsp:include page="../_message-block.jsp" />
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="${pageContext.request.contextPath}/chinh-sua-tai-xe"
					method="POST">
					<input type="hidden" name="id" id="id" value="<%=taiXe.getId()%>">
					<div class="form-group">
						<label>Mã tài xế: </label> <input class="form-control"
							type="text" name="ma-nhan-vien" value="<%=taiXe.getMaTaiXe()%>" readonly="readonly" />
					</div>
					<div class="form-group">
						<label>Họ và tên: </label> <input class="form-control" type="text"
							name="ho-va-ten" value="<%=taiXe.getHoTen()%>" required/>
					</div>
					<div class="form-group">
						<label>Ngày sinh: </label> <input class="form-control" type="text"
							name="ngay-sinh"  value="<%=taiXe.getNgaySinh()%>"required/> 
					</div>
					<button type="submit" class="btn btn-default">Save</button>
					<a href="<%=request.getContextPath()%>/danh-sach-tai-xe" class = "btn btn-default">Cancel</a>
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
		    	locale: 
		    	{
	    	    	format: 'DD/MM/YYYY'
	    	    },
		        singleDatePicker: true,
		        showDropdowns: true
		    });
	});
</script>


<jsp:include page="../_footer-end.jsp" />