package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.filter.Book;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndiBk extends HttpServlet 
{
	private static final long serialVersionUID = -5370084418278804375L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int bid=Integer.parseInt(request.getParameter("bid"));
		Book b=new Book();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
		
		PreparedStatement ps1=c.prepareStatement("select b_name,author1,author2,publication,b_id from books where b_id=?");
		ps1.setInt(1, bid);
 
		ResultSet rs = ps1.executeQuery();
 
		while (rs.next()) 
		{
			b.title=rs.getString(1);
			b.author1=rs.getString(2);
			b.author2=rs.getString(3);
			b.pub=rs.getString(4);
			b.bookid=rs.getInt(5);
		}
		c.close();
		request.setAttribute("bk", b);
		request.getRequestDispatcher("admindbk.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
