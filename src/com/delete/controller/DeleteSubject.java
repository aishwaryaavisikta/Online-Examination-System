package com.delete.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteSubject
 */
@WebServlet("/DeleteSubject")
public class DeleteSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			int subjectid=Integer.parseInt(request.getParameter("subjectid"));
			System.out.println(subjectid+"hello");
			String url ="jdbc:mysql://localhost:3306/oes";
			String driver="com.mysql.jdbc.Driver";
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			int questionid=0;
			int branchid=0;
			
			String query="select * from question where subjectid="+subjectid;
					
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			rs=st.executeQuery(query);
			
			while(rs.next())
			{
				questionid=rs.getInt("questionid");
				System.out.println(questionid);
			}
			if(questionid==0)
			{
				String query2="select branchid from subject where subjectid="+subjectid;
				rs=st.executeQuery(query2);
				while(rs.next())
				{
					branchid=rs.getInt("branchid");
				}
				String query1="delete from subject where subjectid="+subjectid;
				System.out.println(query1);
				st.executeUpdate(query1);
				
				RequestDispatcher rd=request.getRequestDispatcher("ViewSubject");
				request.setAttribute("msg", "Subject Deleted Successfully");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("ViewSubject");
				request.setAttribute("msg", "Subject Could not Deleted. Delete Questions of perticular branch");
				rd.forward(request, response);
				
			}
			}catch(Exception e)
		{
				e.printStackTrace();
		}
	}

}
