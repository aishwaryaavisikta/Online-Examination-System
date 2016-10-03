package com.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;
import com.login.pojo.LoginPojo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String email = request.getParameter("email");
	    String password = request.getParameter("password");	
	    String type = request.getParameter("type");	
	   
	    LoginPojo pojo=new LoginPojo();	    
	    pojo.setEmail(email);
	    pojo.setPassword(password);	   
	    pojo.setType(type);
	    System.out.println(type);
	    LoginDao dao =new LoginDao();
	    if(type.equals("manager"))
	    {
	    	int userid=dao.loginManager(pojo);
	    	System.out.println(userid);
	    	if(userid!=0)
	    	{
	    		session.setAttribute("userid", userid);
	    		session.setAttribute("email", email);    	  
			    System.out.println(userid);		
			    System.out.println(userid);
	    		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
	    		session.setAttribute("userid", userid);
	    		request.setAttribute("msg", "LOGIN SUCCESSFUL ");
	    		rd.forward(request,response);
	    	}
	    	else
	    	{
	    		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	    		request.setAttribute("msg", "INCORRECT EMAIL OR PASSWORD ");
	    		rd.forward(request,response);
	    	}
	    }
  	   else
  	   {
  		   	dao.loginuser(pojo);
		    int userid=dao.loginuser(pojo);
		    System.out.println(userid);
		    
		    if(userid!=0  )
	  	   	    {
		    		session.setAttribute("userid", userid);
		    		session.setAttribute("email", email);    	  
		    		
		    		RequestDispatcher rd=request.getRequestDispatcher("instruction.jsp");
			    	request.setAttribute("msg", "LOGIN SUCCESSFUL ");
			    	rd.forward(request,response);
	  	   	    }
		    else
		    {
		  		   RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		  		   request.setAttribute("msg", "INCORRECT EMAIL OR PASSWORD ");
		  		   rd.forward(request,response);
		    }
  	   }
	    

	}

}
