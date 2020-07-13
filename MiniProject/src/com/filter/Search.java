package com.filter;

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

public class Search extends HttpServlet {
	
	private static final long serialVersionUID = 6415447451903638790L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		int uid=(int)session.getAttribute("uid");
		String dep=new String("");
		if(request.getParameter("dept")!=null)
			dep=request.getParameter("dept");
		String year=new String("");
		if(request.getParameter("year")!=null)
			year=request.getParameter("year");
		String title=new String("");
		if(request.getParameter("title")!=null)
			title=request.getParameter("title");
		List<Advert> adlist=new ArrayList<Advert>();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
			if((!dep.isEmpty()) && (!year.isEmpty()))
			{
				PreparedStatement ps = c.prepareStatement("select ad_id,u_id,b_name,price,publication from advert,books,book_dept_year where advert.b_id=books.b_id and books.b_id=book_dept_year.b_id and is_sold='N' and dept=? and year=? and u_id<>? order by price");
				ps.setString(1, dep);
				ps.setString(2, year);
				ps.setInt(3, uid);
		 
				ResultSet rs = ps.executeQuery();
		 
				while (rs.next())
				{	
					Advert ad=new Advert();
					ad.aid=rs.getInt(1);
					ad.uid=rs.getInt(2);
					ad.title=rs.getString(3);
					ad.price=rs.getInt(4);
					ad.publication=rs.getString(5);
					adlist.add(ad);
				}
				request.setAttribute("adlist",adlist);
				request.getRequestDispatcher("search.jsp").forward(request, response);
			}
			if(!title.isEmpty())
			{
				PreparedStatement ps = c.prepareStatement("select distinct ad_id,u_id,b_name,price,publication from advert,books where advert.b_id=books.b_id and is_sold='N' and b_name=? and u_id<>?");
				ps.setString(1, title);
				ps.setInt(2, uid);
				ResultSet rs = ps.executeQuery();
				 
				while (rs.next())
				{	
					Advert ad=new Advert();
					ad.aid=rs.getInt(1);
					ad.uid=rs.getInt(2);
					ad.title=rs.getString(3);
					ad.price=rs.getInt(4);
					ad.publication=rs.getString(5);
					adlist.add(ad);
				}
				c.close();
				request.setAttribute("adlist",adlist);
				request.getRequestDispatcher("search.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
