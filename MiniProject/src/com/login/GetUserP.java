package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetUserP extends HttpServlet 
{
	private static final long serialVersionUID = 7045301727532373414L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		int uid=(int)session.getAttribute("uid");
		
	    UserP user=new UserP();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
			PreparedStatement ps=c.prepareStatement("select f_name,l_name,mobile,dept,pwd from users where u_id=?");
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				user.fname=rs.getString(1);
				user.lname=rs.getString(2);
				user.mob=rs.getLong(3);
				user.dep=rs.getString(4);
				user.pwd=rs.getString(5);
			}
			c.close();
			request.setAttribute("user", user);
			request.getRequestDispatcher("/editprof.jsp").forward(request, response);
			
			
		} catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
