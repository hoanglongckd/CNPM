<%@page import="model.bean.XeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Lịch sử điều phối</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<%
	ArrayList<XeBEAN> listXe = null;
	if (request.getAttribute("danhSachXe") != null) {
		listXe = (ArrayList<XeBEAN>) request.getAttribute("danhSachXe");
	}
%>
<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Lịch sử điều phối</h1>
			</div>
			 <jsp:include page="../_message-block.jsp" />
			<!-- /.col-lg-12 -->
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr align="center">
						<th>STT</th>
						<th>Tài xế</th>
						<th>Biển số xe</th>
						<th>Địa chỉ nhận khách</th>
						<th>Thời gian</th>
					</tr>
				</thead>
				<tbody>
					<%
						int stt = 0;
						if (listXe != null) {
							for (XeBEAN item : listXe) {
								stt++;
					%>
					<tr class="odd gradeX" align="center">
						<td><%=stt%></td>
						<td><%=item.getTaiXe()%></td>
						<td><%=item.getBienSoXe()%></td>
						<td><%=item.getDiaChi()%></td>
						<td><%=item.getThoiGian()%></td>
					</tr>
					<%
						}
						}
					%>
				</tbody>
			</table>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="../_footer-start.jsp" />
<jsp:include page="../_footer-end.jsp" />