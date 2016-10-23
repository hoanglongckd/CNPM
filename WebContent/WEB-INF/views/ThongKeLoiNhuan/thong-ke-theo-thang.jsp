<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Thống kê lợi nhuận theo tháng</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Thống kê
                    <small>lợi nhuận tháng</small>
                </h1>
            </div>
            
            <div class="col-lg-4 col-lg-offset-4">
	            <form class="form-inline" method="GET">
	            	<div class="form-group">
						<input class="form-control" type="text" name="filter"/>
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