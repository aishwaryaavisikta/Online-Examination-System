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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddExamQuestion1
 */
@WebServlet("/AddExamQuestion1")
public class AddExamQuestion1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		int subjectid=Integer.parseInt(request.getParameter("subjectid"));
		int examid=Integer.parseInt(request.getParameter("examid"));
		System.out.println(examid+"EXAMID");
		System.out.println(subjectid+"subjectid");
		String url ="jdbc:mysql://localhost:3306/oes";
		String driver="com.mysql.jdbc.Driver";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			String query1="select * from question where  subjectid="+subjectid;
			System.out.println(query1);
			rs=st.executeQuery(query1);
			session.setAttribute("rs",rs);
			RequestDispatcher rd=request.getRequestDispatcher("addexamquestion.jsp?subjectid="+subjectid+"& examid="+examid);
			rd.forward(request, response);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
