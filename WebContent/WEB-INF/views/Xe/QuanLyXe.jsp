<%@page import="model.bean.TaiXeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Thêm mới xe</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Phương tiện <small>Add</small>
				</h1>
			</div>
			<jsp:include page="../_message-block.jsp" />
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="<%=request.getContextPath()%>/them-xe" method="POST">
					
					<div class="form-group">
						<label>Biển số xe</label> <input class="form-control"
							name="biensoxe" id="biensoxe" placeholder="Nhập biển số xe" required/>
					</div>
					<div class="form-group">
						<label>Model</label> <input class="form-control" name="model"
							id="model" placeholder="Nhập model xe" required/>
					</div>
					<div class="form-group">
						<label>Số chổ ngồi</label> <select class="form-control"
							name="sochongoi" id="sochongoi" required>
							
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="7">7</option>
							<option value="8">8</option>
						</select>
					</div>
					<div class="form-group">
						<label>Hãng</label> <input class="form-control" name="hang"
							id="hang" placeholder="Nhập hãng xe" required/>
					</div>
					<div class="form-group">
						<label>Ghi chú</label>
						<textarea class="form-control" name="ghichu" id="ghichu" rows="3"></textarea>
					</div>
					<button type="submit" class="btn btn-default">OK</button>
					<a href="list-xe" class="btn btn-default" role="button">Cancel</a>
					<button type="reset" class="btn btn-default">Reset</button>
				</form>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->


<jsp:include page="../_footer-start.jsp" />
<jsp:include page="../_footer-end.jsp" />