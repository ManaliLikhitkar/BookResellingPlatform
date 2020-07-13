<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>BookaZon| Home</title>
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

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		
	<div class="bg-image"></div>
<div class="bg-text">	
 <div class="topnav">
 	
   <a  href="home">Home</a>
  <a class="active" href="plad">Place Ad</a>
  <div class="drpdown">
  	<button class="drpbtn">My Adverts</button>
  	<div class="drpdown-content">
  	  <a href="myadvert">Unsold</a>
  	  <a href="myadvertsold">Sold</a>
    </div>
  </div>
  
  <a href="mycart.jsp">My Cart</a>
  <a href="myord">My Orders</a>
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
	<h1 style="color:#0975ab;"><b><i>Sell Your Book</h1>
	<br><br><br>
	<font size="5">Search by:</font><br><br><br><br>
	
	<form action="getbytitle">
	<font size="5">Title:</font>&nbsp; &nbsp;
		<select name="title" style="padding: 8px 12px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;">
			<c:forEach var="bktitle" items="${bklist}">
				<option value="<c:out value="${bktitle}"/>"> <c:out value="${bktitle}"/></option>	
			</c:forEach>
		</select>
		<br><br><br><br><br>
		<button class="button" type="submit" >Proceed</button>
	</form>
	<br><br>
	Not finding the right book? Click <a href="requestrev.jsp">here</a> to help us expand the Catalogue ! 
</center>
	</div>
	
</body>
</html>