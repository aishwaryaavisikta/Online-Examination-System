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
 * Servlet implementation class ViewAnswer
 */
@WebServlet("/ViewAnswer")
public class ViewAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int questionid=Integer.parseInt(request.getParameter("questionid"));
		System.out.println(questionid);
			
        
        try
        {	
        	String url ="jdbc:mysql://localhost:3306/oes";
        	String driver="com.mysql.jdbc.Driver";
        	Connection con=null;
        	Statement st=null;
        	ResultSet rs=null;
      				
        	String query="select * from question where questionid="+questionid;
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			rs=st.executeQuery(query);
			int count=1;
	
			while(rs.next())
			{
				out.print("<input type='text' id='answerid' value='"+rs.getString("answer")+"'>");
      }
}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	     
      
		
		

	}

}
