<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>BookaZon/Home</title>
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
  <a href="myord">My Orders</a>
  <div class="dropdown">
  	<button class="dropbtn">${username}</button>
  	<div class="dropdown-content">
  	  <a href="userpr">My Profile</a>
      <a href="break">Logout</a>
    </div>
  	
  </div>
  
</div> 
<br><br>

<center>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.3/jquery.min.js"></script>
<br><p><font color="red"> ${message} </font></p><br>
	<h1 style="color:#0975ab;"><b><i>Buy Books</h1>
	<br>
	<p style="font-size:20px;">Search by: &nbsp;&nbsp;
	<select id="searchfilter" style="padding: 5px 20px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;">
		<option value="depyr">Department-Year</option>
		<option value="title">Title</option>
		<option value="author">Author</option>
		<option value="pub">Publication</option>
	</select>
	</p>
	<br><br><br>
	<div id="depyr" class="searchby">
	<form action="find">
	<h3>
		Department:
			&nbsp;
				<select name="dept" style="padding: 5px 20px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;">
					<option value=FE>FE</option>
					<option value="IT">IT</option>
					<option value="CS">CS</option>
					<option value="EnTC">EnTC</option>
					
				</select>
				
				&nbsp;&nbsp;&nbsp;&nbsp;
				
		Year:
			&nbsp;
				<select name="year" style="padding: 5px 20px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;">
					<option value="FE">FE</option>
					<option value="SE">SE</option>
					<option value="TE">TE</option>
					<option value="BE">BE</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<input type="submit" style="background-color: #126c87; color:white; padding: 8px 25px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;" value="Search">
	</form>
	</div>
	<br>
	<div id="title" class="searchby">
	<form action="find">
	<h3>
	Title:&nbsp;
		 <select name="title" style="padding: 8px 12px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;">
			<c:forEach var="bktitle" items="${bklist}">
				<option value='<c:out value="${bktitle}"/>'> <c:out value="${bktitle}"/></option>	
			</c:forEach>
		</select>
		<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->
		<br><br><br><br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" style="background-color: #126c87; color:white; padding: 8px 25px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;" value="Search">
	</form>
	</div>
	
	<div id="author" class="searchby">
	<form action="find">
	<h3>
	Author:&nbsp;
		 <input type="text" name="author" style="padding: 8px 32px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;">
		<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->
		<br><br><br><br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" style="background-color: #126c87; color:white; padding: 8px 25px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;" value="Search">
	</form>
	</div>
	
	<div id="pub" class="searchby">
	<form action="find">
	<h3>
	Publication:&nbsp;
		 <input type="text" name="pub" style="padding: 8px 32px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;">
		<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->
		<br><br><br><br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" style="background-color: #126c87; color:white; padding: 8px 25px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;" value="Search">
	</form>
	</div>
	
</center>
	</div>
	<script>
	$(document).ready(function(){

		  //hides dropdown content
		  $(".searchby").hide();
		  
		  //unhides first option content
		  $("#depyr").show();
		  
		  //listen to dropdown for change
		  $("#searchfilter").change(function(){
		    //rehide content on change
		    $('.searchby').hide();
		    //unhides current item
		    $('#'+$(this).val()).show();
		  });
		  
		});
	</script>
</body>
</html>