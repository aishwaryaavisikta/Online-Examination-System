package com.check.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckSubject
 */
@WebServlet("/CheckSubject")
public class CheckSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
  		PrintWriter out=response.getWriter();
		String subjectcode=request.getParameter("subjectcode") ;
		try
		{
			String Driver="com.mysql.jdbc.Driver";
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost/oes";
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			String qry="select * from subject where subjectcode='"+subjectcode+"'";
			Class.forName(Driver);
			con=DriverManager.getConnection(url,user,password);
			st=con.createStatement();
			rs=st.executeQuery(qry);
			System.out.println("CONNECTED");
			if(rs.next())
			{
				rs.getString("subjectcode");
				
				out.print("Subject is exist..!!");
			}
			else
			{
				out.print("");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
