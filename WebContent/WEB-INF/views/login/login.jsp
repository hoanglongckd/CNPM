<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="Quản lý công ty taxi">
	    <meta name="author" content="SE04">
	   	
		<title>Login</title>
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/public/images/favicon.ico">
		<!-- Bootstrap Core CSS -->
	    <link href="<%=request.getContextPath()%>/public/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" Type="text/css">
	
	    <!-- MetisMenu CSS -->
	    <link href="<%=request.getContextPath()%>/public/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet"  Type="text/css">
	
	    <!-- Custom CSS -->
	    <link href="<%=request.getContextPath()%>/public/dist/css/sb-admin-2.css" rel="stylesheet" Type="text/css">
	
	    <!-- Custom Fonts -->
	    <link href="<%=request.getContextPath()%>/public/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" Type="text/css">
	</head>
	
	<%
		int loi = 0;
		String maNV = null;
		if(request.getParameter("loi")!=null){
			loi = Integer.parseInt(request.getParameter("loi"));
			if(loi==2) maNV = (String)request.getAttribute("maNV");
		}
	%>
	
	<body>
		<div class="container">
	        <div class="row">
	            <div class="col-md-4 col-md-offset-4">
	                <div class="login-panel panel panel-default">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Please Sign In</h3>
	                    </div>
	                    <div class="panel-body">
	                        <form role="form" action="" method="POST">
	                            <fieldset>
	                            	<%if(loi==1){%>
	                                <div class="form-group">
	                                	<p style="color:red">Sai Ma Nhan Vien</p>
	                                    <input class="form-control" placeholder="Ma Nhan Vien" name="maNV" type="text" autofocus>
	                                </div>
	                                <%}else if(loi==2){%>
	                                <div class="form-group">
	                                	<input class="form-control" placeholder="Ma Nhan Vien" name="maNV" type="text" value="<%=maNV%>"autofocus>
	                               		<p style="color:red">Sai Password</p>
	                                </div>
	                                <%}else {%>
	                                 <div class="form-group">
	                                	<input class="form-control" placeholder="Ma Nhan Vien" name="maNV" type="text" autofocus>
	                                </div>
	                                <%} %>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
	                                	
	                                </div>
	                                <button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
	                            </fieldset>
	                        </form>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	 
	    <!-- jQuery -->
	    <script src="<%=request.getContextPath()%>/public/bower_components/jquery/dist/jquery.min.js"></script>
	
	    <!-- Bootstrap Core JavaScript -->
	    <script src="<%=request.getContextPath()%>/public/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	
	    <!-- Metis Menu Plugin JavaScript -->
	    <script src="<%=request.getContextPath()%>/public/bower_components/metisMenu/dist/metisMenu.min.js"></script>
	
	    <!-- Custom Theme JavaScript -->
	    <script src="<%=request.getContextPath()%>/public/dist/js/sb-admin-2.js"></script>
	</body>
</html>