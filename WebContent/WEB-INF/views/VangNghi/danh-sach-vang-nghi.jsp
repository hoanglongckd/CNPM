<%@page import="model.bean.NhanVienVangNghiBEAN"%>
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
	 ArrayList<NhanVienVangNghiBEAN> listVN  = null;
	if(request.getAttribute("listVN")!=null){
		listVN = (ArrayList<NhanVienVangNghiBEAN>)request.getAttribute("listVN");
	}
	else System.out.print("List vang nghi eo co null");
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Danh sách <small>vắng nghỉ</small>
					</h1>
				</div>
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
						<% for (int i=0;i< listVN.size();i++){
							
							%>
								<tr class="odd gradeX" align="center">
									<td><%=i+1%></td>
									<td><%=listVN.get(i).getMaNv()%></td>
									
									<td><%=listVN.get(i).getTenNV()%></td>
									
									<td><%=listVN.get(i).getTongNgayNghi()%></td>
									<td>
										<a href="<%=request.getContextPath()%>/chi-tiet-vang-nghi?id=<%=listVN.get(i).getMaNv()%>" class = "btn btn-danger">Chi Tiết</a> </td>
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
