<%@page import="model.bean.TheoDoiNhanVienBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Update Nhân Viên Vắng Nghỉ</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
	<%
	TheoDoiNhanVienBEAN nv = null;
	if(request.getAttribute("NV")!=null){
		nv = (TheoDoiNhanVienBEAN)request.getAttribute("NV");
	}
	else System.out.print(" eo co null");
	%>


<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Update nhân viên vắng nghỉ
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="<%=request.getContextPath() %>/cap-nhat-vang-nghi" method="POST">
					<div class="form-group">
						<label>Mã nhân viên: </label>  <%=nv.getIdNhanVien() %>
					</div>
					<div class="form-group">
						<label>Ngày Nghỉ: </label> <%= nv.getNgaynghi() %>
					</div>
					<div class="form-group">
						<label>Phép: </label>
						 <input type="radio" name="rdPhep" value="Yes"  checked> Có 
  						<input type="radio" name="rdPhep" value="No"> Không<br>
  						
					</div>
					<div class="form-group">
						<label>Lý do: </label><br>
						<textarea class="form-control" placeholder="Describe yourself here..."
						name="lydo" ><%=nv.getLydo() %></textarea>
					</div>
					<input type="hidden" name="action" value="<%=nv.getId() %>" >
					<button type="submit"  name="btnUpdate"  value="<%=nv.getIdNhanVien() %>" class="btn btn-default">Update</button>
					<button type="reset" name="btnReset"  value="Reset" class="btn btn-default">Reset</button>
					<button type="submit"name="btnCancel"  value="<%=nv.getIdNhanVien() %>"  class="btn btn-default">Hủy</button>
				
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