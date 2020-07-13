<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>BookaZon | Login</title>
</head>
<body>

	<div class="bg-image"></div>		
		<div class="bg-text">
			<br>
			<p><font color="red"> ${message} </font></p>
			<font class="two">Existing User</font>
			<br><br>		
			<br><br><br>					
			<form action="join" method="post" autocomplete="off">
			  <fieldset>
				<legend class="one">Login Information:</legend>
				<br><br>
				Username:
				<input type="text" name="uname" style="border-radius:20px; padding:5px;" required>
				<br><br><br>
				
				Password:
				<input type="password" name="pwd" style="border-radius:20px; padding:5px;" required>
				<br><br><br>

			  </fieldset>
			  <br><br><br>
			  <input class="button" type="submit" value="Login">
			  <br><br><br>
			  <p>Not a user yet? Click <a href="signup.jsp" class="two">here</a> to register!</p>
			</form>
		</div>		
	
</body>
</html>


