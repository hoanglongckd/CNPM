<%@page import="model.bean.TaiXeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Điều phối</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Điều phối đón khách
				</h1>
			</div>
			<jsp:include page="../_message-block.jsp" />
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="<%=request.getContextPath()%>/dieu-phoi"
					method="POST" id = "form_dieuphoi">
					
					<div class="form-group">
						<label>Địa điểm</label>
						<textarea class="form-control" name="diadiem" id="diadiem" rows="4" required></textarea>
					</div>
					
					<div class="form-group">
						<label>Loại xe</label> <select class="form-control"
							name="loaixe" id="loaixe" required>
							<option value="4">4 chổ</option>
							<option value="7">7 chổ</option>
						</select>
					</div>
										
					<button type="submit" class="btn btn-default">  Next  </button>
					<a href="dashboard" class="btn btn-default" role="button">Cancel</a>
					
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
	$.validator.addMethod('whitespace', function(str) {
		if (str.indexOf(' ') > -1) {
			for (var i = 0; i < str.length; i++) {
				if (str[i] != ' ')
					return true;
			}
			return false;
		} else {
			return true;
		}
	})
	$.validator.addMethod('maxlength255', function(str){
		if (str.length > 255) return false;
		else return true;
	})
	$.validator.addMethod('specialcharacter', function(str){
		var pattern = /^[^~!@#$%^&\*()/\\<>;:{}\|?\[\]+=]+$/;
		if(pattern.test(str)) return true;
		else return false;
	})
	$(function() {
		$('#form_dieuphoi').validate(
				{
					rules : {
						diadiem : {
							required : true,
							whitespace : true,
							maxlength255 : true,
							specialcharacter: true
						},
					},
					messages : {
						diadiem : {
							required : 'Vui lòng điền vào trường này.',
							whitespace : 'Không được nhập toàn ký tự trắng',
							maxlength255: 'Không được vượt quá 255 ký tự',
							specialcharacter: 'Không được nhập ký tự đặc biệt'
						},
					},
					errorElement : "b",
					errorPlacement : function(error, element) {
						// Add the `help-block` class to the error element
						error.addClass("help-block");

						if (element.prop("type") === "checkbox") {
							error.insertAfter(element.parent("label"));
						} else {
							error.insertAfter(element);
						}
					},
					highlight : function(element, errorClass, validClass) {
						$(element).closest(".form-group").addClass("has-error")
								.removeClass("has-success");
					},
					unhighlight : function(element, errorClass, validClass) {
						$(element).closest(".form-group").removeClass(
								"has-error");
					}
				})
	});
</script>
<jsp:include page="../_footer-end.jsp" />