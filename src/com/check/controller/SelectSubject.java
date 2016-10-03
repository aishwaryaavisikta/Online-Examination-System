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
 * Servlet implementation class SelectSubject
 */
@WebServlet("/SelectSubject")
public class SelectSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String branchid=request.getParameter("branchid") ;
		try
		{
			String Driver="com.mysql.jdbc.Driver";
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost/oes";
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			String qry="select * from subject where branchid='"+branchid+"'";
			Class.forName(Driver);
			con=DriverManager.getConnection(url,user,password);
			st=con.createStatement();
			rs=st.executeQuery(qry);
			System.out.println("CONNECTED");
			out.print("<select id='subjectid' name='subjectid'>");
			out.print("<option value=''>--SELECT SUBJECT--</option>");
			while(rs.next())
			{
				int subjectid=rs.getInt("subjectid");
				System.out.println(subjectid+"aish");
				out.print("<option value="+subjectid+">"+rs.getString("subjectname")+"</option>");
			}
			out.print("</select>");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}
