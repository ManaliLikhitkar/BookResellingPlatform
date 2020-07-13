<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>BookaZon| My Profile</title>
</head>
<body>

<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	%>

<%@page import="com.login.UserP"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="bg-image"></div>		
		<div class="bg-text">
 <div class="topnav">
 	
   <a class="active" href="home">Home</a>
  <a href="plad">Place Ad</a>
  <div class="drpdown">
  	<button class="drpbtn">My Adverts</button>
  	<div class="drpdown-content">
  	  <a href="myadvert">Unsold</a>
  	  <a href="myadvertsold">Sold</a>
    </div>
  </div>
  
  <a href="mycart.jsp">My Cart</a>
  <div class="dropdown">
  	<button class="dropbtn">${username}</button>
  	<div class="dropdown-content">
  	  <a href="userpr">My Profile</a>
      <a href="break">Logout</a>
    </div>
  	
  </div>
  
</div> 
<br><br><br>
<center>
	Name: <c:out value="${user.fname}"/>  <c:out value="${user.lname}"/>
	<br><br><br>
	Department: <c:out value="${user.dep}"/>
	<br><br><br>
	Mobile: <c:out value="${user.mob}"/>
	<br><br><br>
	<input type="button" value="Edit Details" onclick="location.href='editp'"/>
</center>	
</div>
</body>
</html>