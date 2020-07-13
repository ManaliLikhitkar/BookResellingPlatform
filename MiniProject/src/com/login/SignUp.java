package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet 
{
	
	private static final long serialVersionUID = -8837623452836295377L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fname=new String(request.getParameter("fname"));
		String lname=new String (request.getParameter("lname"));
		long mobno=Long.parseLong(request.getParameter("mob"));
		String dep=new String(request.getParameter("dep"));
		String uname=new String(request.getParameter("uname"));
		String pwd=new String (request.getParameter("pwd"));
		
		String success="Signup Successful!";
		String fail="Signup Unsuccessful!";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
	 
			PreparedStatement ps1=c.prepareStatement("select u_name from users where u_name=?");
			ps1.setString(1, uname);
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				request.setAttribute("message", fail);
				request.getRequestDispatcher("/signup.jsp").forward(request, response);
			}
			PreparedStatement ps = c.prepareStatement("insert into users values(NULL,?,?,?,?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setLong(5, mobno);
			ps.setString(6, dep);
			ps.setString(7, "N");
	 
			int i = ps.executeUpdate();
			c.close();
			if(i>0)
			{
				request.setAttribute("message", success);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
