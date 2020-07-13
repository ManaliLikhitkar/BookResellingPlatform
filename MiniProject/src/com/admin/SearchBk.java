package com.admin;

import com.filter.Book;
import java.util.ArrayList;
import java.util.List;
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

public class SearchBk extends HttpServlet {
	
	private static final long serialVersionUID = 6415447451903638790L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String title=new String("");
		if(request.getParameter("title")!=null)
			title=request.getParameter("title");
		
		String publ=new String("");
		if(request.getParameter("pub")!=null)
			publ=request.getParameter("pub");
		
		List<Book> bklist=new ArrayList<Book>();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
			
			if(!title.isEmpty())
			{
				PreparedStatement ps = c.prepareStatement("select b_name,author1,author2,publication,b_id from books where b_name=?");
				ps.setString(1, title);
				
				ResultSet rs = ps.executeQuery();
				 
				while (rs.next())
				{	
					Book bk=new Book();
					bk.title=rs.getString(1);
					bk.author1=rs.getString(2);
					bk.author2=rs.getString(3);
					bk.pub=rs.getString(4);
					bk.bookid=rs.getInt(5);
					bklist.add(bk);
				}
				
				c.close();
				request.setAttribute("bk",bklist);
				request.getRequestDispatcher("bksrch.jsp").forward(request, response);
			}
			
			if(!publ.isEmpty())
			{
				PreparedStatement ps = c.prepareStatement("select b_name,author1,author2,publication,b_id from books where publication=?");
				ps.setString(1,publ);
				
				ResultSet rs = ps.executeQuery();
				 
				while (rs.next())
				{	
					Book bk=new Book();
					bk.title=rs.getString(1);
					bk.author1=rs.getString(2);
					bk.author2=rs.getString(3);
					bk.pub=rs.getString(4);
					bk.bookid=rs.getInt(5);
					bklist.add(bk);
				}
				c.close();
				request.setAttribute("bk",bklist);
				request.getRequestDispatcher("bksrch.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
