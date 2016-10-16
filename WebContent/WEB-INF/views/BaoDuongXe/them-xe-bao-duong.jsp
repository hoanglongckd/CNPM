<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.bean.XeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Thêm xe bảo dưỡng</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<%
	ArrayList<XeBEAN> listXe = null;
	if(request.getAttribute("listXe")!=null){
		listXe = (ArrayList<XeBEAN>)request.getAttribute("listXe");
	}
%>
<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thêm
					<small>Xe Bảo Dưỡng</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom:120px">
				<form action="${pageContext.request.contextPath}/them-xe-bao-duong" method="POST">
					<div class="form-group">
						<label>Biển số xe</label>
						
						<select class="form-control" name="idCar">
							<option value="0">Vui lòng chọn xe</option>
							<% 
								int i=1;
								if(listXe!=null){
									for(XeBEAN xe : listXe){
										%>
										<option value="<%=i%>"><%=xe.getBienSoXe() %></option>
										<%
										i++;
									}
								}else{
									%>
									<option value="<%=i%>">lỗi cmnr!</option>
									<%
								}
							%>
						</select>
					</div>
				<div class="form-group">
					<label>Ngày bảo dưỡng hiện tại</label>
					<input class="form-control" type="text" name="current-date"/>
				</div>
				<div class="form-group">
					<label>Ngày bảo dưỡng tiếp theo</label>
					<input class="form-control" type="text" name="next-date" />
				</div>
				<div class="form-group">
					<label>Chi phí bảo dưỡng</label>
					<input type="number" class="form-control" name="cost" placeholder="Vui lòng nhập tổng số tiền bảo dưỡng" />
				</div>
				<div class="form-group">
					<label>Chi tiết</label>
					<textarea class="form-control" rows="4" name="detail"
					placeholder="Nhập chi tiết các phần bảo dưỡng ứng với số tiền..."></textarea>
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

<script type="text/javascript">
	$(function() {
	    $('input[name="current-date"]').daterangepicker({
	        singleDatePicker: true,
	        showDropdowns: true
	    });
	    $('input[name="next-date"]').daterangepicker({
	        singleDatePicker: true,
	        showDropdowns: true
	    });
	});
</script>


<jsp:include page="../_footer-end.jsp" />