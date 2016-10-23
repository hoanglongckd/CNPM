<%@page import="model.bean.BaoDuongXeBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Sửa xe bảo dưỡng</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<%
	BaoDuongXeBEAN xeDaBaoDuong = new BaoDuongXeBEAN();
	if(request.getAttribute("xeDaBaoDuong")!=null){
		xeDaBaoDuong = (BaoDuongXeBEAN)request.getAttribute("xeDaBaoDuong");
	}
%>
<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Sửa
					<small>Xe Bảo Dưỡng</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			
			<jsp:include page="../_message-block.jsp" />
			
			<div class="col-lg-7" style="padding-bottom:120px">
				<form action="${pageContext.request.contextPath}/sua-xe-bao-duong" method="POST">
					<input type="hidden" name="id" id="id" value="<%=xeDaBaoDuong.getId()%>">
					<div class="form-group">
						<label for="bien-so-xe">Biển số xe</label>
						<input class="form-control" type="text" name="bien-so-xe" 
						id="bien-so-xe" value="<%=xeDaBaoDuong.getBienSoXe()%>" readonly />
					</div>
					<div class="form-group">
						<label for="current-date">Ngày bảo dưỡng hiện tại</label>
						<input class="form-control" type="text" name="current-date" 
						id="current-date" value="<%=xeDaBaoDuong.getNgayBaoDuong()%>" />
					</div>
					<div class="form-group">
						<label for="next-date">Ngày bảo dưỡng tiếp theo</label>
						<input class="form-control" type="text" name="next-date"
						id="next-date" value="<%=xeDaBaoDuong.getNgayBaoDuongTiepTheo()%>" />
					</div>
					<div class="form-group">
						<label for="cost">Chi phí bảo dưỡng</label>
						<input type="number" class="form-control" name="cost" 
						id="cost" value="<%=xeDaBaoDuong.getSoTien()%>" />
					</div>
					<div class="form-group">
						<label for="chi-tiet">Chi tiết</label>
						<textarea class="form-control" rows="4" name="detail" id="chi-tiet"
						placeholder="Nhập chi tiết các phần bảo dưỡng ứng với số tiền..."><%=xeDaBaoDuong.getChiTiet()%></textarea>
					</div>
					<button type="submit" class="btn btn-default">Sửa</button>
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
	    $('input[name="current-date"]').daterangepicker({
	    	locale: 
	    	{
    	    	format: 'DD/MM/YYYY'
    	    },
	        singleDatePicker: true,
	        showDropdowns: true
	    });
	    $('input[name="next-date"]').daterangepicker({
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