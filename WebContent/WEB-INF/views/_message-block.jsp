
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String messages = (String)request.getAttribute("messages");
	HttpSession msg = request.getSession();
	String message = "";
	String error = "";	
%>
            
            <div class="col-lg-12">
           		<%
            		if (msg.getAttribute("messages") != null) {
            			message = (String)msg.getAttribute("messages");
           		%>
            	<div class="alert alert-success" >
					<%=message %>
				</div>
				<%
	            	}
           			if (msg.getAttribute("errors") != null) {
           				error = (String)msg.getAttribute("errors");
     			%>
     			<div class="alert alert-danger" >
     				<%=error %>
     			</div>
     			<%
           			}
      				msg.removeAttribute("messages"); 
      				msg.removeAttribute("errors"); 
     			%>
            </div>