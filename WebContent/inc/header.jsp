<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Quản lý công ty taxi">
    <meta name="author" content="SE04">
    <title>Admin - SE04</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bower_components/bootstrap/dist/css/bootstrap.min.css" media="screen" />

    <!-- MetisMenu CSS -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bower_components/metisMenu/dist/metisMenu.min.css" media="screen" />

    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/dist/css/sb-admin-2.css" media="screen" />
    
    <!-- Custom Fonts -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bower_components/font-awesome/css/font-awesome.min.css" media="screen" />
    
    <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" media="screen" />
    
    <!-- DataTables Responsive CSS -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bower_components/datatables-responsive/css/dataTables.responsive.css" media="screen" />
    
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
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->