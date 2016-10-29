<%@page import="model.bean.NhanVienBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Thêm Mới Nhân Viên Vắng Nghỉ</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<%
	ArrayList<NhanVienBEAN> listNV = null;
	if(request.getAttribute("listNV")!=null){
		listNV = (ArrayList<NhanVienBEAN>)request.getAttribute("listNV");
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
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="<%=request.getContextPath() %>/them-nhan-vien-nghi"
					method="POST">
					<div class="form-group">
						<label>Mã nhân viên: </label>
						<select class="form-control" name="idNV" required>
							<option value="">Vui lòng Id Nhân Viên</option>
							<% 
								int i=1;
								if(listNV!=null){
									for(NhanVienBEAN nv : listNV){
										%>
										<option value="<%=i%>"><%=nv.getId() %></option>
										<%
										i++;
									}
								}else{
									%>
									<option value="<%=i%>">ERRORS!</option>
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
						 		<input type="radio" name="rdPhep" value="Yes" > Có 
						 	</label>
					 	</div>
					 	<div class="radio-inline">
						 	<label>
  								<input type="radio" name="rdPhep" value="No" checked> Không
  							</label>
  						</div>
					</div>
					<div class="form-group">
						<label>Lý do: </label><br>
						<textarea class="form-control" placeholder="Describe yourself here..."
						name="lydo" rows="4"></textarea>
					</div>
					<button type="submit"  name="btnAdd"  value="Thêm" class="btn btn-default">Thêm</button>
					<button type="reset" name="btnReset"  value="Reset" class="btn btn-default">Reset</button>
					<button type="submit"name="btnCancel"  value="Hủy"  class="btn btn-default">Hủy</button>
				
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
			singleDatePicker : true,
			showDropdowns : true
		});
	});
</script>


<jsp:include page="../_footer-end.jsp" />