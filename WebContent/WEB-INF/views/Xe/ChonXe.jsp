<%@page import="model.bean.XeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Chọn xe</title>
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
				<h1 class="page-header">Danh sách xe taxi</h1>
			</div>
			<!-- /.col-lg-12 -->
			<form action="<%=request.getContextPath()%>/chon-xe" method="POST">
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr align="center">
						<th>STT</th>
						<th>Tài xế</th>
						<th>Biển số xe</th>
						<th>Số chổ ngồi</th>
						<th>Accept</th>

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
						<td><%=item.getSoCho()%></td>

						<td class="center">
							<button type="submit" class="btn btn-default" name = "accept" id = "accept" value = "<%=item.getId()%>">Accept</button>
                        	
						</td>

					</tr>
					<%
						}
						}
					%>
				</tbody>
			</table>
			</form>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="../_footer-start.jsp" />
<jsp:include page="../_footer-end.jsp" />