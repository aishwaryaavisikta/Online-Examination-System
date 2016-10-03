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

import com.signup.pojo.SignupPojo;

/**
 * Servlet implementation class UpdateStudentProfile
 */
@WebServlet("/UpdateStudentProfile")
public class UpdateStudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		int studentid=Integer.parseInt(request.getParameter("studentid"));
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String phoneno=request.getParameter("phoneno");
		String branch=request.getParameter("branch");
		
		try{
			String url ="jdbc:mysql://localhost:3306/oes";
			String driver="com.mysql.jdbc.Driver";
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
						
			String query="update student set firstname='"+firstname+"',lastname='"+lastname+"',phoneno='"+phoneno+"',email='"+email+"',branch='"+branch+"' where studentid="+studentid;
			System.out.println(query);	
			
			String query1="select * from student where studentid="+studentid;
			System.out.println(query);	
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			st.executeUpdate(query);
			rs=st.executeQuery(query1);		
			session.setAttribute("rs",rs);
			session.setAttribute("studentid", studentid);
			RequestDispatcher rd=request.getRequestDispatcher("studentprofile.jsp");
			rd.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
	}

}
