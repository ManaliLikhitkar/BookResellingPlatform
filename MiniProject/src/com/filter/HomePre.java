package com.filter;

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
import java.util.ArrayList;
import java.util.List;

public class HomePre extends HttpServlet
{
	private static final long serialVersionUID = 3191192626064200125L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
		
		PreparedStatement ps1=c.prepareStatement("select distinct b_name from books order by b_name");
		String title;
		
		ResultSet rs1=ps1.executeQuery();
		List<String> bklist=new ArrayList<String>();
		while(rs1.next())
		{
			title=rs1.getString(1);
			bklist.add(title);
		}
		c.close();
		request.setAttribute("bklist", bklist);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
