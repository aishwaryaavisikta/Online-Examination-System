package com.signup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.signup.dao.SignupDao;
import com.signup.pojo.SignupPojo;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String firstname=request.getParameter("firstname") ;
		String lastname=request.getParameter("lastname") ;
		String email=request.getParameter("email") ;
		String password=request.getParameter("password") ;
		int batch=Integer.parseInt(request.getParameter("batch")) ;
		String phoneno=request.getParameter("phoneno") ;
		String branch=request.getParameter("branch") ;
		String gender=request.getParameter("gender") ;

		SignupPojo pojo=new SignupPojo();
		pojo.setFirstname(firstname);
		pojo.setLastname(lastname);
		pojo.setEmail(email);
		pojo.setPassword(password);
		pojo.setPhoneno(phoneno);
		pojo.setBatch(batch);
		pojo.setBranch(branch);
		pojo.setGender(gender);
		
		SignupDao dao=new SignupDao();
		int status=dao.save(pojo);
		
		if(status>0)
		{	
			/*RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
			request.setAttribute("msg","Signup successful..!! Go for Login...");
			rd.forward(request, response);*/
			response.sendRedirect("signup.jsp?msg=Signup successful..!! Go for Login...");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
			request.setAttribute("msg","Signup fails..!! Try again...");
			rd.forward(request, response);
		}


	}

}
