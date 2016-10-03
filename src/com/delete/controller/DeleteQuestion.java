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
 * Servlet implementation class DeleteQuestion
 */
@WebServlet("/DeleteQuestion")
public class DeleteQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			int questionid=Integer.parseInt(request.getParameter("questionid"));
			System.out.println(questionid);
			String url ="jdbc:mysql://localhost:3306/oes";
			String driver="com.mysql.jdbc.Driver";
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			int questionoptionid=0;
		
			String query="select * from questionoption where questionid="+questionid;
					
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			rs=st.executeQuery(query);
			
			while(rs.next())
			{
				questionoptionid=rs.getInt("questionoptionid");
				System.out.println(questionoptionid);
			}
			if(questionoptionid!=0)
			{
				System.out.println(questionoptionid);
				String query1="delete from questionoption where questionid="+questionid;
				System.out.println(query1);
				st.executeUpdate(query1);
				String query2="delete from question where questionid="+questionid;
				System.out.println(query2);
				st.executeUpdate(query2);
				RequestDispatcher rd=request.getRequestDispatcher("ViewQuestion");
				request.setAttribute("msg", " Deleted Successfully");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("ViewQuestion");
				request.setAttribute("msg", "Question Could not Deleted.");
				rd.forward(request, response);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
