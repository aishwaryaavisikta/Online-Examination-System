package com.delete.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBranch
 */
@WebServlet("/DeleteBranch")
public class DeleteBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		try
		{
			int branchid=Integer.parseInt(request.getParameter("branchid"));
			System.out.println(branchid+"hello");
			String url ="jdbc:mysql://localhost:3306/oes";
			String driver="com.mysql.jdbc.Driver";
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			int subjectid=0;
			
			String query="select * from subject where branchid="+branchid;
					
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			rs=st.executeQuery(query);
			
			while(rs.next())
			{
				subjectid=rs.getInt("subjectid");
				System.out.println(subjectid+"x");
			}
			if(subjectid==0)
			{
				String query1="delete from branch where branchid="+branchid;
				System.out.println(query1);
				st.executeUpdate(query1);
				RequestDispatcher rd=request.getRequestDispatcher("ViewBranch?page=1");
				request.setAttribute("msg", "Branch Deleted Successfully");
				rd.forward(request, response);
			}
			
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("ViewBranch?page=1");
				request.setAttribute("msg", "Branch Could not Deleted. Delete subjects of perticular branch");
				rd.forward(request, response);
				
			}
			
			}catch(Exception e)
		{
				e.printStackTrace();
		}
	}

}
