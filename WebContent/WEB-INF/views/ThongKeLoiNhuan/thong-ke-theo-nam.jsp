<%@page import="utils.FormatMoneyUtils"%>
<%@page import="model.bean.ThongKeLoiNhuanBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Thống kê lợi nhuận theo năm</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<%
	ArrayList<ThongKeLoiNhuanBEAN> list = null;
	String month = "", year = "";
	long cost = 0;
	if (request.getAttribute("list") != null) {
		list = (ArrayList<ThongKeLoiNhuanBEAN>) request.getAttribute("list");
	}
	if (request.getAttribute("year") != null) {
		year = (String) request.getAttribute("year");
	}
	if (request.getAttribute("cost") != null) {
		cost = (Long) request.getAttribute("cost");
	}
%>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Thống kê
                <%
                	if (!"".equals(year)) {
             	%>
             		<small>lợi nhuận năm <%=year %></small>
                <%
                	}
                	else {
                %>
                	<small>lợi nhuận theo năm</small>
                <%
                	}
                %>
                </h1>
            </div>
            
            <div class="col-lg-4" style="margin-left: -0.1em; padding-left:0px;">
            <form method="POST">
            	<div class="form-inline" class="form-group">
            		<label>Tổng lợi nhuận</label>
            		<input class="form-control" type="text" name="totalcost" value="<%=FormatMoneyUtils.convertToMoney(cost) %>" readonly>
            	</div>
            	</form>
            </div>
            
            <div class="col-lg-4 col-lg-offset-4">
	            <form action="<%=request.getContextPath() %>/thong-ke-theo-nam" class="form-inline" method="POST">
	            	<div class="form-group">
	            	<%
	            		if (!"".equals(year)) {
	            	%>
	            		<input class="form-control" type="number" name="year" value="<%=year %>"/>
	            	<%
	            		}
	            		else {
	            	%>
	            		<input class="form-control" type="number" placeholder="Nhập năm" name="year"/>
	            	<%
	            		}
	            	%>
						<button type="submit" class="btn btn-default">Thống kê</button>
					</div>
				</form>
            </div>
            
            <jsp:include page="../_message-block.jsp" />
            
            
            <!-- /.col-lg-12 -->
            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                    <tr align="center">
                        <th>STT</th>
                        <th>Biển số xe</th>
                        <th>Tiền tài xế trả</th>
                        <th>Tiền bảo dưỡng</th>
                        <th>Tiền lời</th>
                    </tr>
                </thead>
                <tbody>
               	<%
               		int stt = 0;
               		if (list != null) {
               			for (ThongKeLoiNhuanBEAN item : list) {
               				stt++;
               				
               	%>
               		<tr class="odd gradeX" align="center">
               			<td><%=stt %></td>
               			<td><%=item.getBienSoXe() %></td>
               			<td><%=FormatMoneyUtils.convertToMoney(item.getTienTaiXeTra()) %></td>
               			<td><%=FormatMoneyUtils.convertToMoney(item.getTienBaoDuong()) %></td>
               			<td><%=FormatMoneyUtils.convertToMoney(item.getTienTaiXeTra() - item.getTienBaoDuong()) %></td>
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
<script type="text/javascript">
	$(function() {
	    $('input[name="filter"]').daterangepicker({
	    	locale: 
	    	{
    	    	format: 'MM/YYYY'
    	    },
	    	singleDatePicker: true,
	        showDropdowns: true
	    });
	});
</script>
<jsp:include page="../_footer-end.jsp" />