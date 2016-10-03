package com.check.controller;

import java.io.IOException;
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckEmail
 */
@WebServlet("/CheckEmail")
public class CheckEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 String email=request.getParameter("email") ;


		 try{
		 	

		 String Driver="com.mysql.jdbc.Driver";
		 String user="root";
		 String password="root";
		 String url="jdbc:mysql://localhost/oes";
		 Connection con=null;
		 Statement st=null;
		 ResultSet rs=null;
		 String qry="select * from login where email='"+email+"'";
		 Class.forName(Driver);
		 con=DriverManager.getConnection(url,user,password);
		 st=con.createStatement();
		 rs=st.executeQuery(qry);
		 System.out.println("CONNECTED");
		 while(rs.next())
		 {
		 	rs.getString("password");
		 	out.print("!Error.... Email is already registerd. try another");
		 }
		 }
		 catch(Exception e)
		 {
		 	e.printStackTrace();
		 }


	}

}
