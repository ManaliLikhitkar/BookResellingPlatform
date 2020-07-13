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
import com.login.UserP;

public class IndiSold extends HttpServlet 
{
	
	private static final long serialVersionUID = -3357412616816046627L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int aid=Integer.parseInt(request.getParameter("adid"));
		//int uid=0;
		Advert ad=new Advert();
		UserP s=new UserP();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select ad_id,u_id,b_name,price,publication,author1,author2,description from advert,books where advert.b_id=books.b_id and ad_id=?");
		ps.setInt(1, aid);
		
		//PreparedStatement ps1=c.prepareStatement("select f_name,l_name,mobile from users where u_id=?");
		PreparedStatement ps1=c.prepareStatement("select billing.bill_id,buyer_id,f_name,l_name,mobile from billing,bill_buyer,users where billing.bill_id=bill_buyer.bill_id and bill_buyer.buyer_id=users.u_id and ad_id=?");
		ps1.setInt(1, aid);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) 
		{	
			ad.aid=rs.getInt(1);
			ad.uid=rs.getInt(2);
			//uid=rs.getInt(2);
			ad.title=rs.getString(3);
			ad.price=rs.getInt(4);
			ad.publication=rs.getString(5);
			ad.author1=rs.getString(6);
			ad.author2=rs.getString(7);
			ad.desc=rs.getString(8);
		}
		
		//ps1.setInt(1, uid);
		
		ResultSet rs1=ps1.executeQuery();
		
		while(rs1.next())
		{
			s.fname=rs1.getString(3);
			s.lname=rs1.getString(4);
			s.mob=rs1.getLong(5);
		}
		c.close();
		request.setAttribute("adlist",ad);
		request.setAttribute("buyer", s);
		request.getRequestDispatcher("mysoldindi.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

}
