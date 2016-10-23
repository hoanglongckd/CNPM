<%@page import="model.bean.TheoDoiNhanVienBEAN"%>
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
	ArrayList<TheoDoiNhanVienBEAN> listVN = null;
	if(request.getAttribute("listVN")!=null){
		listVN = (ArrayList<TheoDoiNhanVienBEAN>)request.getAttribute("listVN");
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
                <h1 >
                    <small>Mã Nhân Viên: <%=listVN.get(0).getIdNhanVien() %>  </small>
                </h1>
                 <h1 >
                    <small>Họ Tên:<%=listVN.get(0).getName() %>  </small>
                </h1>
            </div>
            
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
                	int stt = 0;
                	for(int i=0;i<listVN.size();++i){
                		
                %>
                	<tr class="odd gradeX" align="center">
                        <td><%=i+1%></td>
                        <td><%=listVN.get(i).getNgaynghi()%></td>
                        <td><%=listVN.get(i).getPhep()%></td>
                        <td><%=listVN.get(i).getLydo()%></td>
               	
                        <td>
							<a href="<%=request.getContextPath()%>/cap-nhat-vang-nghi?id=<%=listVN.get(i).getId()%>" class = "btn btn-danger">Sửa</a> </td>
								
                        <td class="center"><i class="fa fa-trash-o fa-fw"></i> <a href="<%=request.getContextPath()%>/chi-tiet-vang-nghi?delete=<%=listVN.get(i).getId()%>,<%=listVN.get(i).getIdNhanVien()%>" > Xóa</a></td>
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