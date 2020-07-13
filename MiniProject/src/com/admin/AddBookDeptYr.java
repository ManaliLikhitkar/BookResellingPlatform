package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBookDeptYr extends HttpServlet 
{
	private static final long serialVersionUID = -1634254143509014788L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int bid=Integer.parseInt(request.getParameter("bid"));
		String depyr[]=request.getParameterValues("dept-yr");
		String domains=request.getParameter("domains");
		String domsp[]=domains.split(",");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookonlinesale", "root", "Atharva@18"); // gets a new connection
			for(String value : depyr)
			{
				String depyrsp[]=value.split("-");
				String dep=depyrsp[0];
				String yr=depyrsp[1];
				System.out.println(bid+ dep + yr);
				PreparedStatement ps=c.prepareStatement("insert into book_dept_year values(?,?,?)");
				ps.setInt(1,bid);
				ps.setString(2, dep);
				ps.setString(3, yr);
				ps.executeUpdate();
			}
			for(String value : domsp)
			{
				PreparedStatement ps=c.prepareStatement("insert into book_domain values(?,?)");
				ps.setInt(1,bid);
				ps.setString(2, value);
				ps.executeUpdate();
			}
			c.close();
			response.sendRedirect("ahome");
		
		}
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
