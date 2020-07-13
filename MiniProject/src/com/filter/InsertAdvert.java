package com.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAdvert extends HttpServlet 
{
	
	private static final long serialVersionUID = -2622117881050199265L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int bid=Integer.parseInt(request.getParameter("bookid"));
		HttpSession session=request.getSession();
		int uid=(int)session.getAttribute("uid");
		int price=Integer.parseInt(request.getParameter("price"));
		String desc=request.getParameter("desc");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
			PreparedStatement ps=c.prepareStatement("insert into advert values(NULL,?,?,curdate(),?,NULL,?,'N')");
			ps.setInt(1, bid);
			ps.setInt(2, uid);
			ps.setInt(3, price);
			ps.setString(4,desc);
			
			ps.executeUpdate();
			c.close();
			response.sendRedirect("home");
		
		}
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
