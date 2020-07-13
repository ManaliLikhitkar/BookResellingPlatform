package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBookDetails extends HttpServlet 
{
	private static final long serialVersionUID = -150758358138872084L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String title=request.getParameter("title");
		String publication=request.getParameter("pub");
		String author1=request.getParameter("a1");
		String author2=request.getParameter("a2");
		int bid=0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
			PreparedStatement ps=c.prepareStatement("insert into books values(NULL,?,?,?,?)");
			ps.setString(1, title);
			ps.setString(2, author1);
			ps.setString(3, author2);
			ps.setString(4,publication);
			
			ps.executeUpdate();
			PreparedStatement ps1=c.prepareStatement("select last_insert_id()");
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				bid=rs1.getInt(1);
			}
			System.out.println(bid);
			c.close();
			request.setAttribute("bid", bid);
			request.getRequestDispatcher("adminbookdeptyr.jsp").forward(request, response);
			//response.sendRedirect("adminbookdeptyr.jsp");
		
		}
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
