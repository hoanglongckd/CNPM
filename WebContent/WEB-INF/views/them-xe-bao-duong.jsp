<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Thêm xe bảo dưỡng</title>
<jsp:include page="_top.jsp" />
<jsp:include page="_menu.jsp" />

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
				<form action="" method="POST">
					<div class="form-group">
						<label>Biển số xe</label>
						<select class="form-control">
							<option value="0">Please Choose Category</option>
							<option value="">Tin Tức</option>
						</select>
					</div>
				<div class="form-group">
					<label>Ngày bảo dưỡng hiện tại</label>
					<input class="form-control" type="text" name="current-date" />
<!-- 					<input class="form-control" name="txtCateName" placeholder="Please Enter Category Name" /> -->
				</div>
				<div class="form-group">
					<label>Ngày bảo dưỡng tiếp theo</label>
					<input class="form-control" type="text" name="next-date" />
<!-- 					<input class="form-control" name="txtOrder" placeholder="Please Enter Category Order" /> -->
				</div>
				<div class="form-group">
					<label>Chi phí bảo dưỡng</label>
					<input class="form-control" name="txtOrder" placeholder="Please Enter Category Keywords" />
				</div>
				<div class="form-group">
					<label>Chi tiết</label>
					<textarea class="form-control" rows="3"></textarea>
				</div>
				<button type="submit" class="btn btn-default">Category Add</button>
				<button type="reset" class="btn btn-default">Reset</button>
				</form>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="_footer-start.jsp" />

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


<jsp:include page="_footer-end.jsp" />