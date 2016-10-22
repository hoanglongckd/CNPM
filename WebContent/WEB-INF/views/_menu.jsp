<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
					<a href="#"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
				</li>
				<li>
					<a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Category<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#">List Category</a></li>
						<li><a href="#">Add Category</a></li>
					</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-cube fa-fw"></i> Product<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#">List Product</a></li>
						<li><a href="#">Add Product</a></li>
					</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-car"></i> Quản lý xe<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/them-xe">Thêm xe mới</a></li>
							<li><a href="<%=request.getContextPath()%>/list-xe">Danh sách xe</a></li>
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
			</ul>
		</div>
	<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>