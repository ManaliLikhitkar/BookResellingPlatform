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


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="bg-image"></div>
<div class="bg-text">	
 <div class="topnav">
 	
  <a  href="ahome">Home</a>
  <a class="active" href="searchbkpre">Book Catalog</a>
  <a href="admactad">Active Ads</a>
  <a href="sale">Sales</a>
  <a href="reviewlist">Books to Review</a>
  <a href="singlebookadmin.jsp">Add new Book</a>
  
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.3/jquery.min.js"></script>
	<h1 style="color:#0975ab;"><b><i>Search Books by</i></b></h1>
	<br>
	<p style="font-size:20px;">Search by: &nbsp;&nbsp;
	<select id="searchfilter" style="padding: 5px 20px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;">
		<option value="title">Title</option>
		<option value="pub">Publication</option>
	</select>
	</p>
	<br><br><br>
	
	<div id="title" class="searchby">
	<form action="bfind">
	<h3>
	Title:&nbsp;
		 <select name="title" style="padding: 8px 32px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;">
			<c:forEach var="bktitle" items="${bklist}">
				<option value='<c:out value="${bktitle}"/>'> <c:out value="${bktitle}"/></option>	
			</c:forEach>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" style="background-color: #126c87; color:white; padding: 8px 25px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;" value="Search">
	</form>
	</div>
	
	<div id="pub" class="searchby">
	<form action="bfind">
	<h3>
	Publication:&nbsp;
		 <select name="pub" style="padding: 8px 32px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;">
			<c:forEach var="pbtitle" items="${pblist}">
				<option value='<c:out value="${pbtitle}"/>'> <c:out value="${pbtitle}"/></option>	
			</c:forEach>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" style="background-color: #126c87; color:white; padding: 8px 25px; text-align: center; cursor: pointer; font-weight:bold; border-radius:15px;" value="Search">
	</form>
	</div>
	
	
</center>
</div>
	<script>
	$(document).ready(function(){

		  //hides dropdown content
		  $(".searchby").hide();
		  
		  //unhides first option content
		  $("#title").show();
		  
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