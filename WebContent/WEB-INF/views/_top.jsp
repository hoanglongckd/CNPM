<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/public/images/favicon.ico">
    
	<!-- Bootstrap Core CSS -->
	<link href="<%=request.getContextPath()%>/public/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/public/bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	
	<!--  DateTimePicker -->
	<link href="<%=request.getContextPath()%>/public/datetimepicker/css/daterangepicker.css" rel="stylesheet">
	
	<!-- MetisMenu CSS -->
	<link href="<%=request.getContextPath()%>/public/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
	
	<!-- Custom CSS -->
	<link href="<%=request.getContextPath()%>/public/dist/css/sb-admin-2.css" rel="stylesheet">
	
	<!-- Custom Fonts -->
	<link href="<%=request.getContextPath()%>/public/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<!-- DataTables CSS -->
	<link href="<%=request.getContextPath()%>/public/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">
	
	<!-- DataTables Responsive CSS -->
	<link href="<%=request.getContextPath()%>/public/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">
</head>
<body>
	<div id="wrapper">
	
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Admin Area - SE04</a>
		</div>
		<!-- /.navbar-header -->
	
		<ul class="nav navbar-top-links navbar-right">
			<!-- /.dropdown -->
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
				</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="<%=request.getContextPath()%>/profile"><i class="fa fa-user fa-fw"></i> User Profile</a></li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a></li>
					<li class="divider"></li>
					<li><a href="<%=request.getContextPath()%>/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
				</ul>
				<!-- /.dropdown-user -->
			</li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->