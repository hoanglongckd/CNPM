<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    HttpSession s = request.getSession();
    String maChucVu = s.getAttribute("maChucVu").toString();
    if(maChucVu.equals("AD")){
    %>
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				<!-- /input-group -->
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
				</li>
				<li>
					<a href="#"><i class="fa fa-user"></i> Quản lý nhân viên<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=request.getContextPath()%>/them-nhan-vien">Thêm nhân viên</a></li>
						<li><a href="<%=request.getContextPath()%>/danh-sach-nhan-vien">Danh sách nhân viên</a></li>
						<li><a href="<%=request.getContextPath()%>/phan-cong-nhan-vien">Phân công nhân viên</a></li>
<%-- 						<li><a href="<%=request.getContextPath()%>/phan-cong-nhan-vien">Bảng phân công nhân viên</a></li> --%>
					</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-credit-card"></i> Quản lý tài khoản<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=request.getContextPath()%>/quan-ly-tai-khoan">Danh sách tài khoản</a></li>
					</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-users"></i> Quản lý tài xế<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=request.getContextPath()%>/them-tai-xe">Thêm tài xế</a></li>
						<li><a href="<%=request.getContextPath()%>/danh-sach-tai-xe">Danh sách tài xế</a></li>
						<li><a href="<%=request.getContextPath()%>/phan-cong-tai-xe">Phân công tài xế</a></li>
					</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-taxi"></i> Quản lý xe<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/them-xe">Thêm xe mới</a></li>
							<li><a href="<%=request.getContextPath()%>/list-xe">Danh sách xe</a></li>
						</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-location-arrow"></i> Điều phối<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/dieu-phoi">Thêm điều phối</a></li>
							<li><a href="<%=request.getContextPath()%>/danh-sach-dieu-phoi">Lịch sử điều phối</a></li>
						</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-calendar"></i> Quản lý vắng nghỉ<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/them-nhan-vien-nghi">Thêm nhân viên vắng</a></li>
							<li><a href="<%=request.getContextPath()%>/danh-sach-vang-nghi">Báo cáo tình hình vắng</a></li>
						</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-wrench"></i> Bảo dưỡng xe<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/them-xe-bao-duong">Thêm xe bảo dưỡng</a></li>
							<li><a href="<%=request.getContextPath()%>/bao-cao-xe-bao-duong">Báo cáo bảo dưỡng</a></li>
						</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-usd"></i> Thống kê lợi nhuận<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/thong-ke-theo-thang">Theo tháng</a></li>
							<li><a href="<%=request.getContextPath()%>/thong-ke-theo-nam">Theo năm</a></li>
						</ul>
					<!-- /.nav-second-level -->
				</li>
			</ul>
		</div>
	<!-- /.sidebar-collapse -->
	</div>
	<%}
    else{
    %>
    <div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				<!-- /input-group -->
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
				</li>
				<li>
					<a href="#"><i class="fa fa-location-arrow"></i> Điều phối<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/dieu-phoi">Thêm điều phối</a></li>
							<li><a href="<%=request.getContextPath()%>/danh-sach-dieu-phoi">Lịch sử điều phối</a></li>
						</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-calendar"></i> Quản lý vắng nghỉ<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/them-nhan-vien-nghi">Thêm nhân viên vắng</a></li>
							<li><a href="<%=request.getContextPath()%>/danh-sach-vang-nghi">Báo cáo tình hình vắng</a></li>
						</ul>
					<!-- /.nav-second-level -->
				</li>
				</ul>
		</div>
	<!-- /.sidebar-collapse -->
	</div>
	<%} %>
	<!-- /.navbar-static-side -->
</nav>