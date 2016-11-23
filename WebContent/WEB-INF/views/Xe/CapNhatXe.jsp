<%@page import="model.bean.XeBEAN"%>
<%@page import="model.bean.TaiXeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
<title>Cập nhật xe</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<%
	XeBEAN xe = new XeBEAN();
	if (request.getAttribute("xeduocchon") != null) {
		xe = (XeBEAN) request.getAttribute("xeduocchon");
	}
	
%>

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Cập nhật phương tiện</h1>
			</div>
			<jsp:include page="../_message-block.jsp" />
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="<%=request.getContextPath()%>/cap-nhat-xe" id = "form_capnhatxe" method="POST">
					<input type="hidden" name="id" value="<%=xe.getId() %>">
					<div class="form-group">
						<label>Biển số xe</label> <input class="form-control"
							name="biensoxe" id="biensoxe" value="<%=xe.getBienSoXe()%>" readonly/>
					</div>

					<div class="form-group">
						<label>Model</label> <input class="form-control" name="model"
							id="model" value="<%=xe.getModel()%>" required/>
					</div>
					
					<div class="form-group">
						<label>Số chổ ngồi</label> <select class="form-control"
							name="sochongoi" id="sochongoi" required>
							<option value="<%=xe.getSoCho()%>"><%=xe.getSoCho()%></option>
							<option value="4">4</option>
							<option value="7">7</option>
						</select>
					</div>
					
					<div class="form-group">
						<label>Hãng</label> <input class="form-control" name="hang"
							id="hang" value="<%=xe.getHang()%>" required/>
					</div>
					
					<div class="form-group">
						<label>Ghi chú</label>
						<textarea class="form-control" name="ghichu" id="ghichu" rows="3" ><%=xe.getGhiChu()%></textarea>
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
	$.validator.addMethod('maxlength20', function(str){
		if (str.length > 20) return false;
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
		$('#form_capnhatxe').validate(
				{
					rules : {
						model : {
							required : true,
							whitespace : true,
							maxlength50: true,
							specialcharacter: true
						},
						hang : {
							required : true,
							whitespace : true,
							maxlength20 : true,
							specialcharacter: true
						}
					},
					messages : {
						model : {
							required : 'Vui lòng điền vào trường này.',
							whitespace : 'Không được nhập toàn ký tự trắng',
							maxlength50: 'Không được vượt quá 50 ký tự',
							specialcharacter: 'Không được nhập ký tự đặc biệt'
						},
						hang : {
							required : 'Vui lòng điền vào trường này.',
							whitespace : 'Không được nhập toàn ký tự trắng',
							maxlength20: 'Không được vượt quá 20 ký tự',
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