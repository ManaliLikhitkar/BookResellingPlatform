<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>BookaZon | My Cart</title>
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
	<%@page import="java.io.*"%>
<%@page import="java.util.List"%>
<%@page import="com.filter.Advert"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bg-image"></div>		
		<div class="bg-text">
 <div class="topnav">
 	
  <a  href="home">Home</a>
  <a href="plad">Place Ad</a>
  <div class="drpdown">
  	<button class="drpbtn">My Adverts</button>
  	<div class="drpdown-content">
  	  <a href="myadvert">Unsold</a>
  	  <a href="myadvertsold">Sold</a>
    </div>
  </div>
  
  <a class="active" href="mycart.jsp">My Cart</a>
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
<c:set var="price" value="${0}"/>
<center>
<table>
<c:forEach var="cart" items="${cart}">
	<c:set var="price" value="${price + cart.price}"/>
</c:forEach> 
<c:if test="${price > 0 }">
<tr>
	<th>Book Title</th>
	<th>Publication</th>
	<th>Price</th>
	<th></th>
</tr>
</c:if>


<c:forEach var="cart" items="${cart}">
	<tr>
		<td><a href="indi?adid=<c:out value="${cart.aid}"/>"><c:out value="${cart.title}"></c:out></a></td>
		<td><c:out value="${cart.publication}"></c:out></td>
		<td><c:out value="${cart.price}"></c:out></td>
		<td><input type="button" style="background-color:#126c87;border: none;color: white;text-align: center;text-decoration: none;display: inline-block;font-size: 14px;cursor: pointer;border-radius:5px; padding:8px 15px " value="Remove from cart" onclick="location.href='rmcart?aid=<c:out value="${cart.aid}"/>'"/></td>
	</tr>

</c:forEach>
</table>

<br><br><br>
<c:choose>
		<c:when test="${price == 0}">
			No Items in your cart!!
		</c:when>
		<c:otherwise>
			<font size="5">Total Price : Rs. <c:out value="${price}"/>/-</font>
			<br><br><br><br>
			<input class="button1" type="button" id="buy" value="Buy All" onclick="location.href='buy'"/>
		</c:otherwise>
	</c:choose>


</center>

</div>
</body>
</html>