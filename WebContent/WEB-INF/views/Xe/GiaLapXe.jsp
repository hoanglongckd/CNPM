<%@page import="org.omg.PortableInterceptor.DISCARDING"%>
<%@page import="model.bean.DieuPhoiBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Giả lập taxi</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<%
	ArrayList<DieuPhoiBEAN> dieuPhoi = null;
	if (request.getAttribute("dieuPhoiBEAN") != null) {
		dieuPhoi = (ArrayList<DieuPhoiBEAN>) request.getAttribute("dieuPhoiBEAN");
	}
%>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Giả lập <small>xe taxi</small>
				</h1>
			</div>
			<jsp:include page="../_message-block.jsp" />
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="<%=request.getContextPath()%>/gia-lap-xe"
					method="POST">

					<div class="form-group">
						<label>Biển số xe</label> <select class="form-control"
							name="bien-so-xe" required>
							<option value="">Chọn biển số xe</option>
							<%
								if (dieuPhoi != null)
									for (DieuPhoiBEAN item : dieuPhoi) {
							%>
							<option value="<%=item.getId()%>"><%=item.getDiaChi()%></option>
							<%
								}
								else {
							%>
							<option value="">Chưa có điều phối nào!</option>
							<%
								}
							%>
						</select>
					</div>

					<div class="form-group">
						<label for="date-started">Thời gian bắt đầu</label> <input
							type="text" name="date-started" id="date-started"
							class="form-control">
					</div>

					<div class="form-group">
						<label for="date-ended">Thời gian kết thúc</label> <input
							type="text" name="date-ended" id="date-ended"
							class="form-control">
					</div>

					<div class="form-group">
						<label for="kilomet">Số KM đi được</label> <input type="number"
							name="kilomet" id="kilomet" class="form-control"
							placeholder="Nhập số km đi được">
					</div>

					<button type="submit" class="btn btn-default">Submit</button>
					<a href="list-xe" class="btn btn-default" role="button">Cancel</a>

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
		$('input[name="date-started"]').daterangepicker({
	        locale: {
	            format: 'YYYY-MM-DD HH:mm'
	        },
	        singleDatePicker: true,
	        showDropdowns: true,
	        timePicker: true,
	        timePickerIncrement: 1
			
	    });
	    $('input[name="date-ended"]').daterangepicker({
	    	locale: 
	    	{
    	    	format: 'YYYY-MM-DD HH:mm'
    	    },
    	    singleDatePicker: true,
	        showDropdowns: true,
	        timePicker: true,
	        timePickerIncrement: 1
	    });
	});
</script>

<jsp:include page="../_footer-end.jsp" />