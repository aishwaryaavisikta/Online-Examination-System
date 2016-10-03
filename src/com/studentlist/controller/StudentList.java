package com.studentlist.controller;

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
 * Servlet implementation class StudentList
 */
@WebServlet("/StudentList")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		try{
		String url ="jdbc:mysql://localhost:3306/oes";
		String driver="com.mysql.jdbc.Driver";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		int totalpage=10;
		int counter=Integer.parseInt(request.getParameter("page"));
		System.out.println(counter);
		if(counter==1)
		{
			counter=counter-1;
			
		}
		else
		{
			counter=counter-1;
			counter=counter*totalpage;
		}
					
		String query="select * from student limit "+counter+","+totalpage+"";
		System.out.println(query);
		
		
				
		Class.forName(driver);
		con=DriverManager.getConnection(url,"root", "root");
		st=con.createStatement();
		rs=st.executeQuery(query);
		
		session.setAttribute("rs",rs);
		session.setAttribute("st",st);
		RequestDispatcher rd=request.getRequestDispatcher("studentlist.jsp");
		rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
