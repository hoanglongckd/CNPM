<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Danh sách nhân viên</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<div id="wrapper">
	<!-- Page Content -->
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Danh sách <small>Tài xế</small>
					</h1>
				</div>
				<!-- /.col-lg-12 -->
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr align="center">
							<th>STT</th>
							<th>MaTX</th>
							<th>Họ và tên</th>
							<th>Ngày sinh</th>
							<th>Ca làm việc</th>
							<th>Delete</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<tr class="odd gradeX" align="center">
							<td>1</td>
							<td>TX001</td>
							<td>Trần văn Tèo</td>
							<td>2016-10-15</td>
							<td>Ca 1</td>
							<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
								href="#"> Delete</a></td>
							<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
								href="#">Edit</a></td>
						</tr>
						<tr class="even gradeC" align="center">
							<td>2</td>
							<td>TX002</td>
							<td>Trần văn Tý</td>
							<td>2016-10-15</td>
							<td>Ca 2</td>
							<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
								href="#"> Delete</a></td>
							<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
								href="#">Edit</a></td>
						</tr>
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
