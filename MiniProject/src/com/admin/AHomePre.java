package com.admin;

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

public class AHomePre extends HttpServlet
{
	
	private static final long serialVersionUID = 4930326023517809381L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
		
		PreparedStatement ps1=c.prepareStatement("select count(*) from advert where is_sold='N'");
		PreparedStatement ps2=c.prepareStatement("select count(*) from advert where is_sold='Y'");
		PreparedStatement ps3=c.prepareStatement("select count(*) from tobe_app_books");
		int tot_act_ads=0,tot_sold=0,tot_rev=0;
		
		ResultSet rs1=ps1.executeQuery();
		ResultSet rs2=ps2.executeQuery();
		ResultSet rs3=ps3.executeQuery();
		while(rs1.next())
		{
			tot_act_ads=rs1.getInt(1);
		}
		while(rs2.next())
		{
			tot_sold=rs2.getInt(1);
		}
		while(rs3.next())
		{
			tot_rev=rs3.getInt(1);
		}
		
		c.close();
		request.setAttribute("active", tot_act_ads);
		request.setAttribute("sold", tot_sold);
		request.setAttribute("revno", tot_rev);
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
