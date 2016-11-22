<%@page import="utils.FormatMoneyUtils"%>
<%@page import="model.bean.BaoDuongXeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>Báo cáo xe bảo dưỡng</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<%
	ArrayList<BaoDuongXeBEAN> danhSachBaoDuongXe = null;
	if(request.getAttribute("danhSachBaoDuongXe")!=null){
		danhSachBaoDuongXe = (ArrayList<BaoDuongXeBEAN>)request.getAttribute("danhSachBaoDuongXe");
	}
	
%>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Báo Cáo
                    <small>Xe Bảo Dưỡng</small>
                </h1>
            </div>
            
            <jsp:include page="../_message-block.jsp" />
            
            <!-- /.col-lg-12 -->
            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                    <tr align="center">
                        <th>STT</th>
                        <th>Biển số xe</th>
                        <th>BD gần đây</th>
                        <th>BD tiếp theo</th>
                        <th>Chi phí</th>
                        <th>Chi tiết</th>
                        <th>Xóa</th>
                    </tr>
                </thead>
                <tbody>
                <%
                	int stt = 0;
                	if (danhSachBaoDuongXe != null) {
                		for (BaoDuongXeBEAN xeBaoDuong: danhSachBaoDuongXe) {
                			stt++;
                %>
                	<tr class="odd gradeX" align="center">
                        <td><%=stt%></td>
                        <td><%=xeBaoDuong.getBienSoXe()%></td>
                        <td><%=xeBaoDuong.getNgayBaoDuong()%></td>
                        <td><%=xeBaoDuong.getNgayBaoDuongTiepTheo()%></td>
                        <td><%=FormatMoneyUtils.convertToMoney(xeBaoDuong.getSoTien())%></td>
                        <td class="center">
                        	<i class="fa fa-eye fa-fw"></i>
                        	<a href="<%=request.getContextPath()%>/chi-tiet-bao-duong?id=<%=xeBaoDuong.getId()%>"> Xem</a>
                       	</td>
                        <td class="center">
                        	<i class="fa fa-trash-o fa-fw"></i> 
                        	<a href="<%=request.getContextPath()%>/xoa-xe-bao-duong?id=<%=xeBaoDuong.getId()%>"> Xóa</a>
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