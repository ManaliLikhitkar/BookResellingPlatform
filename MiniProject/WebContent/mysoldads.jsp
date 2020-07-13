<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>BookaZon | MyAdvert</title>
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
<%@page import="com.filter.Advert"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bg-image"></div>		
		<div class="bg-text">
	 <div class="topnav">
 	
   <a href="home">Home</a>
  <a href="plad">Place Ad</a>
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

<center>
	<table border="1" cellpadding="5">
            <caption><h2>My Ads</h2></caption>
            <tr>
                <th>Title</th>
                <th>Publication</th>
                <th>Price</th>
                
            </tr>
             <c:forEach var="ad" items="${adlist}">
            
                <tr>
                    <td><a href="mysoldindi?adid=<c:out value="${ad.aid}"/>"><c:out value="${ad.title}" /></a></td>
                    <td><c:out value="${ad.publication}"/></td>
                    <td><c:out value="${ad.price}" /></td>
                    
                </tr>
            </c:forEach>
        </table>
</center>
</div>
</body>
</html>