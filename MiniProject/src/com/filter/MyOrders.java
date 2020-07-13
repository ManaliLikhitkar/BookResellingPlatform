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


public class MyOrders extends HttpServlet {
	
	private static final long serialVersionUID = 6108498698799636554L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=(String)request.getSession().getAttribute("username");
		int uid=(int)(request.getSession().getAttribute("uid"));
		
		List<Advert> adlist=new ArrayList<Advert>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select advert.ad_id,b_name,publication,advert.price from bill_buyer,billing,advert,books,users where billing.bill_id=bill_buyer.bill_id and billing.ad_id=advert.ad_id and advert.b_id=books.b_id and advert.u_id=users.u_id and bill_buyer.buyer_id=?");
		ps.setInt(1, uid);
 
		ResultSet rs = ps.executeQuery();
 
		while (rs.next()) {
			
			Advert ad=new Advert();
			ad.aid=rs.getInt(1);
			//ad.uid=rs.getInt(2);
			ad.title=rs.getString(2);
			ad.price=rs.getInt(4);
			ad.publication=rs.getString(3);
			adlist.add(ad);
			
		}
		c.close();
		request.setAttribute("adlist",adlist);
		request.getRequestDispatcher("myorders.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

	

}
