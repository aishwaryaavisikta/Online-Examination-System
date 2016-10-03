package com.profile.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		int userid=Integer.parseInt(session.getAttribute("userid").toString());
		session.setAttribute("userid", userid); 
		
		try
		{
			String url ="jdbc:mysql://localhost:3306/oes";
			String driver="com.mysql.jdbc.Driver";
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			String query="select * from manager where userid="+userid;
			System.out.println(userid);
		
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			rs=st.executeQuery(query);
			session.setAttribute("rs", rs);
			RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
