<%@page import="model.bean.NhanVien.NhanVienBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Danh sách nhân viên</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<div id="wrapper">
	<!-- Page Content -->
	<%
	ArrayList<NhanVienBEAN> listNhanVien = null;
	if(request.getAttribute("listNhanVien")!=null){
		listNhanVien = (ArrayList<NhanVienBEAN>)request.getAttribute("listNhanVien");
	}
	else System.out.print("List nhan vien null");
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Danh sách <small>Nhân viên</small>
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
							<th>Ngày sinh</th>
							<th>Ca làm việc</th>
							<th>Delete</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<% for (int i=0;i<listNhanVien.size();i++){
							if(listNhanVien.get(i).getCaLamViec()==1){
								 String ca = "Ca 1";
							} else if (listNhanVien.get(i).getCaLamViec()==2) {
								String ca = "Ca 2";
							} else {String ca = "Ca 3";}
							
							 if(i%2==0){%>
								<tr class="odd gradeX" align="center">
									<td><%=i+1%></td>
									<td><%=listNhanVien.get(i).getMaNhanVien()%></td>
									
									<td><%=listNhanVien.get(i).getHoTen()%></td>
									
									<td><%=listNhanVien.get(i).getNgaySinh()%></td>
									<td>1</td>
									<td><a href="ShowUpdateNhanVienController?idNhanVien=<%=listNhanVien.get(i).getId()%>" class = "btn btn-danger">Update</a> </td>
									<td><a href="DeleteNhanVienController?idNhanVien=<%=listNhanVien.get(i).getId() %>" class = "btn btn-info">Delete</a></td>
								</tr>
						 <% }else{%>
								<tr class="odd gradeX" align="center">
									<td><%=i+1%></td>
									<td><%=listNhanVien.get(i).getMaNhanVien()%></td>
									<td><%=listNhanVien.get(i).getHoTen()%></td>
									<td><%=listNhanVien.get(i).getNgaySinh()%></td>
									<td>1</td>
									<td><a href="ShowUpdateNhanVienController?idNhanVien=<%=listNhanVien.get(i).getId() %>" class = "btn btn-danger">Update</a> </td>
									<td><a href="DeleteNhanVienController?idNhanVien=<%=listNhanVien.get(i).getId() %>" class = "btn btn-info">Delete</a></td>
								</tr>
						 <%}}%>
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
