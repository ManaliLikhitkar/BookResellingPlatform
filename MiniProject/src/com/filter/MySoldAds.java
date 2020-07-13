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


public class MySoldAds extends HttpServlet {
	
	private static final long serialVersionUID = 6108498698799636554L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=(String)request.getSession().getAttribute("username");
		
		List<Advert> adlist=new ArrayList<Advert>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select ad_id,advert.u_id,b_name,price,publication from advert,books,users where advert.b_id=books.b_id and users.u_id=advert.u_id and is_sold='Y' and u_name=?");
		ps.setString(1, uname);
 
		ResultSet rs = ps.executeQuery();
 
		while (rs.next()) {
			
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
		request.getRequestDispatcher("mysoldads.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

	

}
