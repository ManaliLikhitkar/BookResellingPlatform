package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.filter.Book;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReviewList extends HttpServlet 
{
	private static final long serialVersionUID = 3579799167011131285L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 // loads driver
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
				List<Book> bklist=new ArrayList<Book>();
				PreparedStatement ps = c.prepareStatement("select b_id,b_name,author1,author2,publication from tobe_app_books");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					Book bk=new Book();
					bk.bookid=rs.getInt(1);
					bk.title=rs.getString(2);
					bk.author1=rs.getString(3);
					bk.author2=rs.getString(4);
					bk.pub=rs.getString(5);
					bklist.add(bk);
				}
				
				request.setAttribute("bk",bklist);
				request.getRequestDispatcher("admrevlist.jsp").forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
