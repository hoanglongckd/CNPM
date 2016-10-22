<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Thêm Mới Nhân Viên Vắng Nghỉ</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Thêm mới nhân viên vắng nghỉ
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="<%=request.getContextPath() %>/Add-Theo-Doi-Nhan-Vien"
					method="POST">
					<div class="form-group">
						<label>Mã nhân viên: </label> <input class="form-control"
							type="text" name="ma-nhan-vien" />
					</div>
					<div class="form-group">
						<label>Ngày Nghỉ: </label> <input class="form-control" type="text"
							name="ngay-nghi" />
					</div>
					<div class="form-group">
						<label>Phép: </label>
						 <input type="radio" name="rdPhep" value="Yes" > Có 
  						<input type="radio" name="rdPhep" value="No" checked> Không<br>
  						
					</div>
					<div class="form-group">
						<label>Lý do: </label><br>
						<textarea placeholder="Describe yourself here..."
						name="lydo" ></textarea>
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