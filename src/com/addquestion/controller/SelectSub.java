package com.addquestion.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SelectSub
 */
@WebServlet("/SelectSub")
public class SelectSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		try
		{
			String url ="jdbc:mysql://localhost:3306/oes";
			String driver="com.mysql.jdbc.Driver";
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			String query="select * from branch";
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			rs=st.executeQuery(query);
			session.setAttribute("rs",rs);
			RequestDispatcher rd=request.getRequestDispatcher("select.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
