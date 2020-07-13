<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	
	body, html 
	{
	  	  height: 100%;
	}
	
	.error 
	{
  		  border:2px solid red;
	}

	.bg-image 
	{
		  background-image: url("img0.jpg");
		  filter: blur(5px);
		  -webkit-filter: blur(5px);
		  height: 100%; 
		  background-position: center;
		  background-repeat: no-repeat;
		  background-size: cover;
	}
	
	.bg-text 
	{
		  background-color: rgb(0,0,0); 
		  background-color: rgba(0,0,0, 0.1); 
		  color: black;
		  font-weight: bold;
		  position: absolute;
		  top: 50%;
		  left: 50%;
		  transform: translate(-50%, -50%);
		  z-index: 2;
		  width: 70%;
		  height:90%;
		  padding: 20px;
		  text-align: center;
	}
	
	.one
	{
		  font-size:20px;
		  color:#126c87;
	}
	
	.two
	{
		  font-size:23px;
		  color:#126c87;
	}
	
	p
	{
	  	  font-size:18px;
	}
	
	.button 
	{
		  background-color: #99cede;
		  border: none;
		  color: black;
		  padding: 5px 20px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;	 
		  cursor: pointer;
		  border-radius:15px;
	}
	
	
	.button1
	{
		  background-color: #126c87;
		  border: none;
		  color: white;
		  padding: 15px 32px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;
		  cursor: pointer;
		  font-weight:bold;
		  border-radius:15px;
	}
	
	.topnav 
	{
	  background-color: #333;
	  overflow: hidden;
	}

	
	/* Style the links inside the navigation bar */
	.topnav a 
	{
	  float: left;
	  color: #f2f2f2;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	  font-size: 17px;
	}

	
	/* Change the color of links on hover */
	.topnav a:hover 
	{
	  background-color: #ddd;
	  color: black;
	}

	
	/* Add a color to the active/current link */
	.topnav a.active 
	{
	  background-color: #4CAF50;
	  color: white;
	}

	
	.topnav a.logout 
	{
	  float: right;
	  background-color: #4CAF50;
	  color: white;
	}
	
	.dropdown 
	{
	  float:right;
	  overflow: hidden;
	  padding:0 15px 0 0;
	}

	
	.dropdown .dropbtn 
	{
	  font-size: 16px;  
	  border: none;
	  outline: none;
	  color: white;
	  padding: 14px 16px;
	  background-color: inherit;
	  font-family: inherit;
	  margin: 0;
	}

	.navbar a:hover, .dropdown:hover .dropbtn 
	{
	  background-color: #ddd;
	  color: black;
	  cursor: pointer;
	}

	.dropdown-content 
	{
	  display: none;
	  position: absolute;
	  background-color: #f9f9f9;	  
	  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	}

	.dropdown-content a 
	{
	  float: left;
	  color: black;
	  padding: 12px 16px;
	  text-decoration: none;
	  display: block;
	  text-align: left;
	}

	.dropdown-content a:hover 
	{
	  background-color: #333;
	  color: white;
	}

	.dropdown:hover .dropdown-content 
	{
	  display: block;
	}
	
	.drpdown 
	{
	  float:left;
	  overflow: hidden;
	  padding:0 15px 0 0;
	}
	
	.drpdown .drpbtn 
	{
	  font-size: 16px;  
	  border: none;
	  outline: none;
	  color: white;
	  padding: 14px 16px;
	  background-color: inherit;
	  font-family: inherit;
	  margin: 0;
	}

	.navbar a:hover, .drpdown:hover .drpbtn 
	{
	  background-color: #ddd;
	  color: black;
	  cursor: pointer;
	}

	.drpdown-content 
	{
	  display: none;
	  position: absolute;
	  background-color: #f9f9f9;	  
	  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	}

	.drpdown-content a 
	{
	  float: left;
	  color: black;
	  padding: 12px 16px;
	  text-decoration: none;
	  display: block;
	  text-align: left;
	}

	.drpdown-content a:hover 
	{
	  background-color: #333;
	  color: white;
	}

	.drpdown:hover .drpdown-content 
	{
	  display: block;
	}
	
	
	</style>
	
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookaZon | Ad Details</title>
</head>
<body>
<script>
		
		function valpr()
		{  
				var pr=document.myform.price.value; 
			
				if (isNaN(pr))
				{ 
				  document.getElementById("price").style.borderColor="red";  
				  return false;  
				}
				else
				{  
				  document.getElementById("price").style.borderColor="green";
				  return true;  
				}  
		}  
		
		function val()
		{			
				if(valpr())
				 return true;
				else
				{
				   alert("Please enter correct price!");
				   return false;
				}
		}
		
		
	</script>

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
<%@page import="com.filter.Book"%>
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
<br>
			<font class="two">Place Your Ad</font>
			<br><br>

			<form autocomplete="off" name="myform" action="insertad" onsubmit="return val()">
			
				<input type="hidden" name="bookid" value="<c:out value="${book.bookid}"/>">
			  <fieldset id="section1">
				<legend class="one">Book information</legend>
				
				<center>
				<table>
				
				<tr style="padding:20px">
				
				 	<td align="right" style="padding:20px"><label for="title"><b>Title :</b></label>
					<input type="text" name="title" id="title" size="50" value="<c:out value="${book.title}"/>" style="border-radius:20px; padding:5px;"  disabled/>
					</td>
					
					<td align="right" style="padding:20px"> <label for="pub"><b> Publication :</b></label>
					<input type="text" name="pub" id="pub" size="50" value="<c:out value="${book.pub}"/>" style="border-radius:20px; padding:5px;" disabled>
					</td>
				</tr>
				
				<tr style="padding:20px">
				
					<td align="right" style="padding:20px"><label for="author1"><b>Author 1 :</b></label>
					<input type="text" name="a1" id="a1" size="50" value="<c:out value="${book.author1}"/>" style="border-radius:20px; padding:5px;" disabled>
					</td>
					
					<td align="right" style="padding:20px; float:left;"><label for="a2"><b>Author 2 :</b></label>
					<input type="text" name="a2" id="a2" size="50" value="<c:out value="${book.author2}"/>" style="border-radius:20px; padding:5px;" disabled>
					</td>
				</tr>
				</table>
				
				<br>
				
				<br>

			  </fieldset>
			  
			  <br>
			  
			  <fieldset id="section2">
				<legend class="one">Ad Information</legend>
				
				<br>
				
				Price : <input type="text" name="price" id="price" style="border-radius:20px; padding:5px;" onkeyup="valpr()"required>
				
				<br><br><br>
				
				Description : <textarea rows="5" cols="20" name="desc" style="border-radius:20px; padding:5px;" required></textarea>
				<br><br><br>
				
			  </fieldset>
			  
			  <br>
			  			   
			  <input class="button1" type="submit" value="Place Ad">
			  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			  
			</form>
			
			
		</div>
</body>
</html>