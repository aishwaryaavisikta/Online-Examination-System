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
 * Servlet implementation class CheckSubject2
 */
@WebServlet("/CheckSubject2")
public class CheckSubject2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int branchid=Integer.parseInt(request.getParameter("branchid"));
		System.out.println(branchid);
			       
        try
        {	
        	String url ="jdbc:mysql://localhost:3306/oes";
        	String driver="com.mysql.jdbc.Driver";
        	Connection con=null;
        	Statement st=null;
        	ResultSet rs=null;
        	
        	String query="select * from subject where branchid="+branchid;
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			out.print("<select id='subjectid' name='subjectid' onchange='fun()'>");
			out.print("<option value=''>--SELECT SUBJECT--</option>");
			rs=st.executeQuery(query);
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
