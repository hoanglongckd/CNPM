<%@page import="model.bean.QuanLyVangNghiBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Danh sách vắng nghỉ</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<div id="wrapper">
	<!-- Page Content -->
	<%
	 ArrayList<QuanLyVangNghiBEAN> list  = null;
	if(request.getAttribute("list")!=null){
		list = (ArrayList<QuanLyVangNghiBEAN>)request.getAttribute("list");
	}
	else System.out.print("List vang nghi eo co null");
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Danh sách 
						<small>vắng nghỉ</small>
					</h1>
				</div>
				
				<jsp:include page="../_message-block.jsp"></jsp:include>
				
				<!-- /.col-lg-12 -->
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr align="center">
							<th>STT</th>
							<th>Mã Nhân viên</th>
							<th>Họ và tên</th>
							<th>Tổng Ngày Nghỉ  </th>
							<th>Chi Tiết </th>
						</tr>
					</thead>
					<tbody>
						<% 
							int i = 0;
							for (QuanLyVangNghiBEAN item : list){
							
							%>
								<tr class="odd gradeX" align="center">
									<td><%=++i%></td>
									<td><%=item.getMaNV() %></td>
									
									<td><%=item.getTenNV() %></td>
									
									<td><%=item.getTongNgayNghi() %></td>
									<td>
										<i class="fa fa-eye fa-fw"></i>
										<a href="<%=request.getContextPath()%>/chi-tiet-vang-nghi?id=<%=item.getIdNhanVien() %>">Xem</a> 
									</td>
								</tr>
						 <% }%>
					</tbody>
				</table>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->

</div>

<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>

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
