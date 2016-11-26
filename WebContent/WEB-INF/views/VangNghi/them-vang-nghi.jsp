<%@page import="model.bean.QuanLyVangNghiBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Thêm Mới Nhân Viên Vắng Nghỉ</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<%
	ArrayList<QuanLyVangNghiBEAN> list = null;
	if(request.getAttribute("list")!=null){
		list = (ArrayList<QuanLyVangNghiBEAN>)request.getAttribute("list");
	}
%>
<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Thêm mới 
					<small>nhân viên vắng nghỉ</small>
				</h1>
			</div>
			
			<jsp:include page="../_message-block.jsp"></jsp:include>
			
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="<%=request.getContextPath() %>/them-nhan-vien-nghi"
					method="POST">
					<div class="form-group">
						<label>Mã nhân viên: </label>
						<select class="form-control" name="id-nhan-vien" required>
							<option value="">Vui lòng chọn mã nhân viên</option>
							<% 
								if(list != null){
									for(QuanLyVangNghiBEAN item : list){
										%>
										<option value="<%=item.getIdNhanVien()%>"><%=item.getMaNV() %></option>
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
						<label>Ngày Nghỉ: </label> 
						<input class="form-control" type="text" name="ngay-nghi" />
					</div>
					<div class="form-group">
						<label>Phép: </label><br>
						<div class="radio-inline">
							<label>
						 		<input type="radio" name="phep" value="Yes" > Có 
						 	</label>
					 	</div>
					 	<div class="radio-inline">
						 	<label>
  								<input type="radio" name="phep" value="No" checked> Không
  							</label>
  						</div>
					</div>
					<div class="form-group">
						<label>Lý do: </label><br>
						<textarea class="form-control" placeholder="Nhập lý do nhân viên xin nghỉ..."
						name="lyDo" rows="4"></textarea>
					</div>
					<button type="submit"  name="btnAdd"  value="Thêm" class="btn btn-default">Thêm</button>
					<button type="reset" name="btnReset"  value="Reset" class="btn btn-default">Reset</button>
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
		$('input[name="ngay-nghi"]').daterangepicker({
			locale: 
	    	{
    	    	format: 'DD/MM/YYYY'
    	    },
			singleDatePicker : true,
			showDropdowns : true
		});
	});
</script>


<jsp:include page="../_footer-end.jsp" />