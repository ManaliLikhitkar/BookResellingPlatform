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
	
	</style>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>
		function clear_form_elements(ele) 
		{
			    tags = ele.getElementsByTagName('input');
			    for(i = 0; i < tags.length; i++) 
			    {
				switch(tags[i].type) 
				{
				    case 'password':
				    case 'text':
					tags[i].value = '';
					break;
				    case 'checkbox':
				    case 'radio':
					tags[i].checked = false;
					break;
				}
			    }				   
			    tags = ele.getElementsByTagName('select');
			    for(i = 0; i < tags.length; i++) 
			    {
				if(tags[i].type == 'select-one') 
				{		
				    tags[i].selectedIndex = 0;
				}
				else 
				{
				    for(j = 0; j < tags[i].options.length; j++) 
				    {
					tags[i].options[j].selected = false;
				    }
				}
			    }
			    tags = ele.getElementsByTagName('textarea');
			    for(i = 0; i < tags.length; i++) 
			    {
				tags[i].value = '';
			    }
		   
		}
		
		function f1name()
		{			
				var letters = /^[A-Za-z]+$/; 
				var fn=document.myform.firstname.value;
				if(letters.test(fn))
				{
					document.getElementById("fname").style.borderColor="green";
					return true;
				}
				else
				{
					document.getElementById("fname").style.borderColor="red";
					return false;
				}
		}
		
		function l1name()
		{			
				var letters = /^[A-Za-z]+$/; 
				var fn=document.myform.lastname.value;
				if(letters.test(fn))
				{
					document.getElementById("lname").style.borderColor="green";
					return true;
				}
				else
				{
					document.getElementById("lname").style.borderColor="red";
					return false;
				}
		}
		
		
		
		function validatephn()
		{  
				var num=document.myform.phno.value; 
			
				if (isNaN(num) || num.length!=10)
				{ 
				  document.getElementById("phno").style.borderColor="red";  
				  return false;  
				}
				else
				{  
				  document.getElementById("phno").style.borderColor="green";
				  return true;  
				}  
		}  
		
		function val()
		{			
				if(validatephn() && l1name() && f1name())
				 return true;
				else
				{
				   alert("Please enter correct data!");
				   return false;
				}
		}
		
	</script>


	<div class="bg-image"></div>
	<p> ${message} </p>
			
		
		<div class="bg-text">

			<font class="two">New User</font>
			<br><br>

			<form autocomplete="off" name="myform" action="signup" method="post" onsubmit="return val()">
			
			  <fieldset id="section1">
				<legend class="one">Personal information</legend>
				
				<center>
				<table>
				
				<tr style="padding:20px">
				
				 	<td align="right" style="padding:20px"><label for="firstname"><b>First Name :</b></label>
					<input type="text" name="fname" id="fname"  style="border-radius:20px; padding:5px;" onkeyup="f1name()"  required/>
					</td>
					
					<td align="right" style="padding:20px"> <label for="lastname"><b> Last name :</b></label>
					<input type="text" name="lname" id="lname" style="border-radius:20px; padding:5px;" onkeyup="l1name()" required>
					</td>
				</tr>
				
				<tr style="padding:20px">
				
					<td align="right" style="padding:20px"><label for="mob"><b>Mobile :</b></label>
					<input type="text" name="mob" id="phno" maxlength="10" style="border-radius:20px; padding:5px;" onkeyup="validatephn()" required>
					</td>
					
					<td align="right" style="padding:20px; float:left;"><label for="dept"><b>Department :</b></label>
					<select name="dep" style="border-radius:20px; padding:5px;" required>
						<option value="IT">IT</option>
						<option value="CS">CS</option>
						<option value="EnTC">EnTC</option>
					</select> 
					</td>
				</tr>
				</table>
				
				<br>
				
				<input class="button" type="button" value="Reset" onclick="clear_form_elements(document.getElementById('section1'))">
				<br>

			  </fieldset>
			  
			  <br>
			  
			  <fieldset id="section2">
				<legend class="one">Login Information</legend>
				
				<br>
				
				Username : <input type="text" name="uname" style="border-radius:20px; padding:5px;" required>
				
				<br><br><br>
				
				Password : <input type="password" maxlength="12" name="pwd" style="border-radius:20px; padding:5px;" required>
				<br><br><br>
				
				<input class="button" type="button" value="Reset" onclick="clear_form_elements(document.getElementById('section2'))">

			  </fieldset>
			  
			  <br><br>
			  			   
			  <input class="button1" type="submit" value="Register">
			  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			  <input class="button1" type="reset" value="Reset">
			</form>
			
			<p>Already a user? Click <a href="login.jsp" class="two">here</a> to login!</p>
		</div>
</body>
</html>