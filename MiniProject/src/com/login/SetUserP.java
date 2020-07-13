package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetUserP extends HttpServlet 
{
	private static final long serialVersionUID = 887460351313737772L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fname=new String(request.getParameter("fname"));
		String lname=new String (request.getParameter("lname"));
		long mobno=Long.parseLong(request.getParameter("mob"));
		String dep=new String(request.getParameter("dep"));
		String uname=new String(request.getParameter("uname"));
		String pwd=new String (request.getParameter("pwd"));
		HttpSession session=request.getSession();
		int uid=(int)session.getAttribute("uid");
		
		String success="Update Successful! Please login again!";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
	 
			
			PreparedStatement ps = c.prepareStatement("update users set u_name=?,pwd=?,f_name=?,l_name=?,mobile=?,dept=? where u_id=?");
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setLong(5, mobno);
			ps.setString(6, dep);
			ps.setInt(7, uid);
	 
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
