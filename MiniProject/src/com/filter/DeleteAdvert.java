package com.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAdvert extends HttpServlet
{
	private static final long serialVersionUID = -1195947272369314099L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			int aid=Integer.parseInt(request.getParameter("adid"));
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			 // loads driver
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
				PreparedStatement ps=c.prepareStatement("delete from advert where ad_id=?");
				ps.setInt(1, aid);
				
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
