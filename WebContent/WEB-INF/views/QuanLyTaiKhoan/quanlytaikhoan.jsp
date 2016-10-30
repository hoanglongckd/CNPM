<%@page import="model.bean.NhanVienBEAN"%>
<%@page import="model.bean.BaoDuongXeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Quản lý tài khoản</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<%
	ArrayList<NhanVienBEAN> listNhanVien = null;
	if(request.getAttribute("listNhanVien")!=null){
		listNhanVien = (ArrayList<NhanVienBEAN>)request.getAttribute("listNhanVien");
	}
%>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header"> Quản lý
                    <small> Tài khoản</small>
                </h1>
            </div>
            <!-- /.col-lg-12 -->
            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                    <tr align="center">
                        <th>STT</th>
                        <th>Mã Nhân Viên</th>
                        <th>Password</th>
                        <th>Change password</th>
                    </tr>
                </thead>
                <tbody>
                <%
                	int stt = 0;
                	if (listNhanVien != null) {
                		for (NhanVienBEAN nhanVien: listNhanVien) {
                			stt++;
                %>
                	<tr class="odd gradeX" align="center">
                        <td><%=stt%></td>
                        <td><%=nhanVien.getMaNhanVien()%></td>
                        <td><%=nhanVien.getPassword()%></td>
                        <td class="center">
                        	<i class="fa fa-pencil"></i>
                        	<a href="<%=request.getContextPath()%>/doi-mat-khau?id=<%=nhanVien.getMaNhanVien()%>"> Change password</a>
                       	</td>
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