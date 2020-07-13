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
 	
  <a class="active" href="ahome">Home</a>
  <a href="searchbkpre">Book Catalog</a>
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
<br><br><br><br>
	<font size="5px">
	Total active ads: ${active }
	<br><br><br>
	Total sold ads: ${sold }
	<br><br><br>
	Total books to review: ${revno}
	</font>
	</div>
	
</body>
</html>