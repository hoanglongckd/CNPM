<%@page import="model.bean.QuanLyVangNghiBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Chi Tiết Vắng Nghỉ</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<%
	QuanLyVangNghiBEAN nhanVien = null;
	ArrayList<QuanLyVangNghiBEAN> list = null;
	String idNV = "";
	if(request.getAttribute("list") != null && request.getAttribute("nhanVien") != null && request.getAttribute("idNV") != null){
		nhanVien = (QuanLyVangNghiBEAN) request.getAttribute("nhanVien");
		list = (ArrayList<QuanLyVangNghiBEAN>)request.getAttribute("list");
		idNV = request.getAttribute("idNV").toString();
	}
%>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Chi tiết
                    <small> Vắng Nghỉ  </small>
                </h1>
            </div>
            
             <div class="col-lg-12">
                <h3>
                    Mã Nhân Viên: <%=nhanVien.getMaNV() %>
                </h3>
                 <h3>
                    Họ Tên: <%=nhanVien.getTenNV() %>
                </h3>
            </div>
            <br>
            
            <jsp:include page="../_message-block.jsp"></jsp:include>
            
            <!-- /.col-lg-12 -->
            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                    <tr align="center">
                        <th>STT</th>
                        <th>Ngày nghỉ</th>
                        <th>phép </th>
                        <th> Lý do</th>
                        <th>Sửa </th>
                        <th>Xóa</th>
                    </tr>
                </thead>
                <tbody>
                <%
                	int i = 0;
                	for(QuanLyVangNghiBEAN item : list){
                		
                %>
                	<tr class="odd gradeX" align="center">
                        <td><%=++i %></td>
                        <td><%=item.getNgayNghi() %></td>
                        <% if (item.isCoPhep()) { %>
                        <td>Có</td>
                        <% }else { %>
                        <td>Không</td>
                        <% } %>
                        <td><%=item.getLyDo() %></td>
               	
                        <td>
                        	<i class="fa fa-pencil fa-fw"></i>
							<a href="<%=request.getContextPath()%>/cap-nhat-vang-nghi?id=<%=item.getId() %>">Sửa</a>
						</td>
								
                        <td class="center">
                        	<i class="fa fa-trash-o fa-fw"></i>
							<a href="<%=request.getContextPath()%>/xoa-vang-nghi?id=<%=item.getId() %>&idNV=<%=idNV %>" > Xóa</a>
						</td>
                    </tr>
                <%
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