<%@page import="model.bean.QuanLyVangNghiBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Update Nhân Viên Vắng Nghỉ</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<%
	QuanLyVangNghiBEAN item = null;
	if(request.getAttribute("item") != null){
		item = (QuanLyVangNghiBEAN)request.getAttribute("item");
	}
%>


<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Update
					<small>nhân viên vắng nghỉ</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="<%=request.getContextPath() %>/cap-nhat-vang-nghi" method="POST">
					<div class="form-group">
						<label>Mã nhân viên: </label>  
						<input type="text" class="form-control" value="<%=item.getMaNV() %>" readonly>
					</div>
					<div class="form-group">
						<label>Ngày Nghỉ: </label> 
						<input type="text" class="form-control" name="ngay-nghi" value="<%=item.getNgayNghi() %>">
					</div>
					<div class="form-group">
						<label>Phép: </label><br>
						<div class="radio-inline">
							<label>
						 		<input type="radio" name="phep" value="Yes" <% if(item.isCoPhep()) { %> checked <% } %> > Có 
						 	</label>
					 	</div>
					 	<div class="radio-inline">
						 	<label>
  								<input type="radio" name="phep" value="No" <% if(!item.isCoPhep()) { %> checked <% } %> > Không
  							</label>
  						</div>
					</div>
					<div class="form-group">
						<label>Lý do: </label><br>
						<textarea class="form-control" placeholder="Nhập lý do nhân viên xin nghỉ..."
						name="lydo" rows="4" ><%=item.getLyDo() %></textarea>
					</div>
					<input type="hidden" name="idNhanVien" value="<%=item.getIdNhanVien() %>">
					<input type="hidden" name="id" value="<%=item.getId() %>" >
					<button type="submit"  name="btnUpdate" class="btn btn-default">Update</button>
					<button type="reset" name="btnReset"  value="Reset" class="btn btn-default">Reset</button>
					<a href="<%=request.getContextPath() %>/chi-tiet-vang-nghi?id=<%=item.getIdNhanVien() %>" class="btn btn-default">Hủy</a>
				
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