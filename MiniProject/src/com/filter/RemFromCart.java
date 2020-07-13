package com.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;



public class RemFromCart extends HttpServlet 
{
	private static final long serialVersionUID = 6379737660150703605L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 // loads driver
		HttpSession session=request.getSession();
		int aid=Integer.parseInt(request.getParameter("aid"));
		int pos=0;
		
		ArrayList<Advert> cart=(ArrayList<Advert>)session.getAttribute("cart");
		
		for(int i=0;i<cart.size();i++)
		{
			if(cart.get(i).aid==aid)
				{
					pos=i;
					break;
				}
				
		}
		cart.remove(pos);
		
		session.setAttribute("cart", cart);
		response.sendRedirect("mycart.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
