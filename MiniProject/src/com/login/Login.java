package com.login;

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
import java.util.List;

public class Login extends HttpServlet
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5714397158127256942L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=new String(request.getParameter("uname"));
		String pwd=new String (request.getParameter("pwd"));
		String fail="Invalid credentials";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select u_id,u_name,pwd,type from users where u_name=? and pwd=?");
		ps.setString(1, uname);
		ps.setString(2, pwd);
		
		
		String type;
		
 
		ResultSet rs = ps.executeQuery();
 
		while (rs.next()) 
		{
			HttpSession session=request.getSession();
			int uid=rs.getInt(1);
			type=rs.getString(4);
			session.setAttribute("uid", uid);
			session.setAttribute("username",uname);
			
			if(type.equals("N"))
			{
				PreparedStatement ps1=c.prepareStatement("select distinct b_name from books order by b_name");
				String title;
				List<String> bklist=new ArrayList<String>();
				
				session.setAttribute("cart", new ArrayList<com.filter.Advert>());
				
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next())
				{
					title=rs1.getString(1);
					bklist.add(title);
				}
				request.setAttribute("bklist", bklist);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
			else
			{
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

		}
		c.close();
		request.setAttribute("message", fail);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
