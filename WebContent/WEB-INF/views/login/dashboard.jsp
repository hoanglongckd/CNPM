<%@page import="model.bean.DashBoardBEAN"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.bean.XeBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../_header.jsp" />
<%-- <%@include file="header.jsp" %> --%>
	<title>DashBoard</title>
<jsp:include page="../_top.jsp" />
<jsp:include page="../_menu.jsp" />

<!-- Page Content -->
<%
	DashBoardBEAN dbb = null;
	if (request.getAttribute("dbb") != null) {
		dbb = (DashBoardBEAN) request.getAttribute("dbb");
	}
%>
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">DashBoard
				</h1>
			</div>
			<div class="col-lg-4 col-md-6">
	            <div class="panel panel-primary">
	                <div class="panel-heading">
	                    <div class="row">
	                        <div class="col-xs-3">
	                            <i class="fa fa-user fa-5x"></i>
	                        </div>
	                        <div class="col-xs-9 text-right">
	                            <div class="huge"><%=dbb.getSoNhanVien() %></div>
	                            <div>Quản lý nhân viên</div>
	                        </div>
	                    </div>
	                </div>
	                <a href="<%=request.getContextPath()%>/danh-sach-nhan-vien">
	                    <div class="panel-footer">
	                        <span class="pull-left">Xem chi tiết</span>
	                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                        <div class="clearfix"></div>
	                    </div>
	                </a>
	            </div>
	        </div>
	        <div class="col-lg-4 col-md-6">
	            <div class="panel panel-success">
	                <div class="panel-heading">
	                    <div class="row">
	                        <div class="col-xs-3">
	                            <i class="fa fa-users fa-5x"></i>
	                        </div>
	                        <div class="col-xs-9 text-right">
	                            <div class="huge"><%=dbb.getSoTaiXe() %></div>
	                            <div>Quản lý tài xế</div>
	                        </div>
	                    </div>
	                </div>
	                <a href="<%=request.getContextPath()%>/danh-sach-tai-xe">
	                    <div class="panel-footer">
	                        <span class="pull-left">Xem chi tiết</span>
	                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                        <div class="clearfix"></div>
	                    </div>
	                </a>
	            </div>
	        </div>
	        <div class="col-lg-4 col-md-6">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    <div class="row">
	                        <div class="col-xs-3">
	                            <i class="fa fa-taxi fa-5x"></i>
	                        </div>
	                        <div class="col-xs-9 text-right">
	                            <div class="huge"><%=dbb.getSoXe() %></div>
	                            <div>Quản lý xe</div>
	                        </div>
	                    </div>
	                </div>
	                <a href="<%=request.getContextPath()%>/list-xe">
	                    <div class="panel-footer">
	                        <span class="pull-left">Xem chi tiết</span>
	                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                        <div class="clearfix"></div>
	                    </div>
	                </a>
	            </div>
	        </div>
	        <div class="col-lg-4 col-md-6">
	            <div class="panel panel-danger">
	                <div class="panel-heading">
	                    <div class="row">
	                        <div class="col-xs-3">
	                            <i class="fa fa-location-arrow fa-5x"></i>
	                        </div>
	                        <div class="col-xs-9 text-right">
	                            <div class="huge"><%=dbb.getSoDieuPhoi() %></div>
	                            <div>Quản lý điều phối</div>
	                        </div>
	                    </div>
	                </div>
	                <a href="<%=request.getContextPath()%>/danh-sach-dieu-phoi">
	                    <div class="panel-footer">
	                        <span class="pull-left">Xem chi tiết</span>
	                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                        <div class="clearfix"></div>
	                    </div>
	                </a>
	            </div>
	        </div>
	        <div class="col-lg-4 col-md-6">
	            <div class="panel panel-info">
	                <div class="panel-heading">
	                    <div class="row">
	                        <div class="col-xs-3">
	                            <i class="fa fa-calendar fa-5x"></i>
	                        </div>
	                        <div class="col-xs-9 text-right">
	                            <div class="huge"><%=dbb.getSoVangNghi() %></div>
	                            <div>Quản lý vắng nghỉ</div>
	                        </div>
	                    </div>
	                </div>
	                <a href="<%=request.getContextPath()%>/danh-sach-vang-nghi">
	                    <div class="panel-footer">
	                        <span class="pull-left">Xem chi tiết</span>
	                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                        <div class="clearfix"></div>
	                    </div>
	                </a>
	            </div>
	        </div>
	        <div class="col-lg-4 col-md-6">
	            <div class="panel panel-warning">
	                <div class="panel-heading">
	                    <div class="row">
	                        <div class="col-xs-3">
	                            <i class="fa fa-wrench fa-5x"></i>
	                        </div>
	                        <div class="col-xs-9 text-right">
	                            <div class="huge"><%=dbb.getSoXeBaoDuong() %></div>
	                            <div>Quản lý xe bảo dưỡng</div>
	                        </div>
	                    </div>
	                </div>
	                <a href="<%=request.getContextPath()%>/bao-cao-xe-bao-duong">
	                    <div class="panel-footer">
	                        <span class="pull-left">Xem chi tiết</span>
	                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                        <div class="clearfix"></div>
	                    </div>
	                </a>
	            </div>
	        </div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="../_footer-start.jsp" />


<jsp:include page="../_footer-end.jsp" />