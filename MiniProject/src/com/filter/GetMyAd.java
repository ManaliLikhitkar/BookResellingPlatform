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

public class GetMyAd extends HttpServlet 
{
	private static final long serialVersionUID = -6977613475451775290L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int aid=Integer.parseInt(request.getParameter("adid"));
		Advert ad=new Advert();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select ad_id,advert.u_id,b_name,price,publication,author1,author2,description from advert,books where advert.b_id=books.b_id and ad_id=?");
		ps.setInt(1, aid);
 
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) 
		{		
			ad.aid=rs.getInt(1);
			ad.uid=rs.getInt(2);
			ad.title=rs.getString(3);
			ad.price=rs.getInt(4);
			ad.publication=rs.getString(5);
			ad.author1=rs.getString(6);
			ad.author2=rs.getString(7);
			ad.desc=rs.getString(8);
		}
		c.close();
		request.setAttribute("adlist",ad);
		request.getRequestDispatcher("myindividual.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

}
