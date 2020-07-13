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
import javax.servlet.http.HttpSession;
import java.util.ArrayList;



public class AddToCart extends HttpServlet 
{
	private static final long serialVersionUID = 3103598824519185484L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
		
		PreparedStatement ps = c.prepareStatement("select ad_id,advert.u_id,b_name,price,publication from advert,books,users where advert.b_id=books.b_id and users.u_id=advert.u_id and ad_id=?");
		ps.setInt(1, Integer.parseInt(request.getParameter("aid")));
 
		ResultSet rs = ps.executeQuery();
		
		HttpSession session=request.getSession();
		
		ArrayList<Advert> cart=(ArrayList<Advert>)session.getAttribute("cart");
		while (rs.next())
		{
			Advert ad=new Advert();
			ad.aid=rs.getInt(1);
			ad.uid=rs.getInt(2);
			ad.title=rs.getString(3);
			ad.price=rs.getInt(4);
			ad.publication=rs.getString(5);
			System.out.println(ad.aid);
			cart.add(ad);
		}
		session.setAttribute("cart", cart);
		c.close();
		response.sendRedirect("mycart.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
