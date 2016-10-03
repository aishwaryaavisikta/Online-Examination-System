package com.exam.controller;

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

import com.addbranch.pojo.AddBranchPojo;

/**
 * Servlet implementation class SaveExamQuestion
 */
@WebServlet("/SaveExamQuestion")
public class SaveExamQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	int count=Integer.parseInt(request.getParameter("count"));
	int examid=Integer.parseInt(request.getParameter("examid"));
	int questionid=0;
	String Driver="com.mysql.jdbc.Driver";
	String user="root";
	String password="root";
	String url="jdbc:mysql://localhost:3306/oes";
	Connection con=null;
	Statement st=null;
	
	try
	{
		Class.forName(Driver);
		con=DriverManager.getConnection(url,user,password);
		st=con.createStatement();
		if(request.getParameter("questionid")!=null)
			{
				String arr[]=request.getParameterValues("questionid");
				String question="";	
				for(int i=0;i<arr.length;i++)
				{
					question+=arr[i]+"\t";
					
				}
				
				for(int j=0;j<arr.length;j++)
				{
				questionid=Integer.parseInt(arr[j]);
				String qry="insert into examination(examid,questionid) values ("+examid+","+questionid+")";
				System.out.println(qry);
				st.executeUpdate(qry);
				}
		
		}
		RequestDispatcher rd=request.getRequestDispatcher("Exam");
		rd.forward(request, response);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
