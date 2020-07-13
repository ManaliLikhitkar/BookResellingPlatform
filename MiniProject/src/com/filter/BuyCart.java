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


public class BuyCart extends HttpServlet
{
	private static final long serialVersionUID = 530285105650697917L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
			HttpSession session=request.getSession();
			int uid=(int)(session.getAttribute("uid"));
			int bill=0;
			PreparedStatement ps=c.prepareStatement("insert into bill_buyer values(NULL,?,?,curdate())");
			ps.setInt(1, uid);
			ps.setInt(2, 0);
			
			ps.executeUpdate();
			
			PreparedStatement ps1=c.prepareStatement("select bill_id from bill_buyer order by bill_id desc limit 1");
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				bill=rs1.getInt(1);
			}
			
			ArrayList<Advert> cart=(ArrayList<Advert>)session.getAttribute("cart");
			
			for(int i=0;i<cart.size();i++)
			{
				PreparedStatement ps2=c.prepareStatement("insert into billing values(?,?)");
				//PreparedStatement ps3=c.prepareStatement("update advert set is_sold='Y' where ad_id=?");
				ps2.setInt(1, bill);
				ps2.setInt(2, cart.get(i).getaid());
				//ps3.setInt(1, cart.get(i).getaid());
				
				ps2.executeUpdate();
				//ps3.executeUpdate();
				
			}
			cart.clear();
			c.close();
			session.setAttribute("cart", cart);
			response.sendRedirect("home");
		
		}
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
