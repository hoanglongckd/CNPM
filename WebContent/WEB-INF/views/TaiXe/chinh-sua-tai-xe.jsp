<%@page import="model.bean.TaiXeBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Chỉnh sửa thông tin tài xế</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<%
	TaiXeBEAN taiXe = new TaiXeBEAN();
	if(request.getAttribute("taiXe")!=null){ 
		taiXe=(TaiXeBEAN)request.getAttribute("taiXe");
	}
%>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Chỉnh sửa <small>Thông tin tài xế</small>
				</h1>
			</div>
			<jsp:include page="../_message-block.jsp" />
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="${pageContext.request.contextPath}/chinh-sua-tai-xe"
					method="POST" id="form_chinhsuataixe">
					<input type="hidden" name="id" id="id" value="<%=taiXe.getId()%>">
					<div class="form-group">
						<label>Mã tài xế: </label> <input class="form-control"
							type="text" name="mataixe" value="<%=taiXe.getMaTaiXe()%>" readonly="readonly" />
					</div>
					<div class="form-group">
						<label>Họ và tên: </label> <input class="form-control" type="text"
							name="hovaten" value="<%=taiXe.getHoTen()%>" required/>
					</div>
					<div class="form-group">
						<label>Ngày sinh: </label> <input class="form-control" type="text"
							name="ngay-sinh"  value="<%=taiXe.getNgaySinh()%>"required/> 
					</div>
					<button type="submit" class="btn btn-default">Save</button>
					<a href="<%=request.getContextPath()%>/danh-sach-tai-xe" class = "btn btn-default">Cancel</a>
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

<script type="text/javascript">
	$(function() {
		 $('input[name="ngay-sinh"]').daterangepicker({
		    	locale: 
		    	{
	    	    	format: 'DD/MM/YYYY'
	    	    },
		        singleDatePicker: true,
		        showDropdowns: true
		    });
	});
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
	$.validator.addMethod('maxlength5', function(str){
		if (str.length > 5) return false;
		else return true;
	})
	$.validator.addMethod('maxlength50', function(str){
		if (str.length > 50) return false;
		else return true;
	})
	$.validator.addMethod('specialcharacter', function(str){
		var pattern = /^[^~!@#$%^&\*()/\\<>;:{}\|?\[\]+=]+$/;
		if(pattern.test(str)) return true;
		else return false;
	})
	$(function() {
		$('#form_chinhsuataixe').validate(
				{
					rules : {
						hovaten : {
							required : true,
							whitespace : true,
							maxlength50: true,
							specialcharacter: true
						}
					},
					messages : {
						hovaten : {
							required : 'Vui lòng điền vào trường này.',
							whitespace : 'Không được nhập toàn ký tự trắng',
							maxlength50: 'Không được vượt quá 50 ký tự',
							specialcharacter: 'Không được nhập ký tự đặc biệt'
						}
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