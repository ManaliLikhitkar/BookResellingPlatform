package com.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.filter.Book;

public class GetByTitle extends HttpServlet 
{
	
	private static final long serialVersionUID = -1243352255004995075L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
		String title=new String(request.getParameter("title"));
		System.out.println(title);
		
		PreparedStatement ps1=c.prepareStatement("select b_name,author1,author2,publication,b_id from books where b_name=?");
		ps1.setString(1, title);
		
		List<Book> bklist=new ArrayList<Book>();
 
		ResultSet rs = ps1.executeQuery();
 
		while (rs.next()) 
		{
			Book b=new Book();
			b.title=rs.getString(1);
			b.author1=rs.getString(2);
			b.author2=rs.getString(3);
			b.pub=rs.getString(4);
			b.bookid=rs.getInt(5);
			System.out.println(b.bookid);
			bklist.add(b);
		}
		c.close();
		request.setAttribute("bk", bklist);
		request.getRequestDispatcher("booklist.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
