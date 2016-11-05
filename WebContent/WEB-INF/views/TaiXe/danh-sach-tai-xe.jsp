<%@page import="model.bean.TaiXeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Danh sách tài xế</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<div id="wrapper">
	<!-- Page Content -->
	<%
	ArrayList<TaiXeBEAN> listTaiXe = null;
	if(request.getAttribute("listTaiXe")!=null){
		listTaiXe = (ArrayList<TaiXeBEAN>)request.getAttribute("listTaiXe");
	}
	else System.out.print("List tai xế null");
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Danh sách <small>Tài xế</small>
					</h1>
				</div>
				<jsp:include page="../_message-block.jsp" />
				<!-- /.col-lg-12 -->
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr align="center">
							<th>STT</th>
							<th>Mã tài xế</th>
							<th>Họ và tên</th>
							<th>Ngày sinh</th>
							<th>Cập nhật</th>
							<th>Xóa</th>
						</tr>
					</thead>
					<tbody>

						<% for (int i=0;i<listTaiXe.size();i++){
							 if(i%2==0){%>
						<tr class="odd gradeX" align="center">
							<td><%=i+1%></td>
							<td><%=listTaiXe.get(i).getMaTaiXe()%></td>
							<td><%=listTaiXe.get(i).getHoTen()%></td>
							<td><%=listTaiXe.get(i).getNgaySinh()%></td>
							<td class="center"><i class="fa fa-edit"></i> <a
								href="<%=request.getContextPath()%>/chinh-sua-tai-xe?idTaiXe=<%=listTaiXe.get(i).getId()%>">Cập nhật</a></td>
							<td class="center"><i class="fa fa-trash-o fa-fw"></i> <a
								href="<%=request.getContextPath()%>/xoa-tai-xe?idTaiXe=<%=listTaiXe.get(i).getId() %>">Xóa</a></td>
						</tr>
						<% }else{%>
						<tr class="odd gradeX" align="center">
							<td><%=i+1%></td>
							<td><%=listTaiXe.get(i).getMaTaiXe()%></td>
							<td><%=listTaiXe.get(i).getHoTen()%></td>
							<td><%=listTaiXe.get(i).getNgaySinh()%></td>
							<td class="center"><i class="fa fa-edit"></i> <a
								href="<%=request.getContextPath()%>/chinh-sua-tai-xe?idTaiXe=<%=listTaiXe.get(i).getId() %>">Cập nhật</a></td>
							<td class="center"><i class="fa fa-trash-o fa-fw"></i> <a
								href="<%=request.getContextPath()%>/xoa-tai-xe?idTaiXe=<%=listTaiXe.get(i).getId() %>">Xóa</a></td>
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
